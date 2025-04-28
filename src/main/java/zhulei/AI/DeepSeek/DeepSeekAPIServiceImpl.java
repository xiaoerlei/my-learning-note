package zhulei.AI.DeepSeek;

import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.Pair;
import okhttp3.Response;
import zhulei.AI.Entity.*;
import zhulei.Utils.OkHttpUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class DeepSeekAPIServiceImpl implements DeepSeekAPIService{

    private static final String chatUrl = "https://api.deepseek.com/chat/completions";

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    @Override
    public Pair<String, String> chat(List<Message> messages, BlockingQueue<EventInfo> eventQueue) throws Exception {
        // 1、构建请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer xxxxx");
        headers.put("Accept", "text/event-stream");  // 明确接受流式响应
        // 2、构建请求对象
        DSRequestBody req = new DSRequestBody();
        req.setMessages(messages);
        req.setStream(true);
        req.setMaxTokens(1024);
        req.setTemperature(1);
        req.setTopP(1);
        req.setModel("deepseek-reasoner");
        // 3、请求 ds 接口
        Response response = OkHttpUtils.post(chatUrl, headers, jsonMapper.writeValueAsString(req));
        if (!response.isSuccessful() || response.body() == null) {
            throw new Exception("请求失败: " + response.code());
        }
        // 4、处理流式结果
        boolean isFinished = false;
        StringBuilder fullContent = new StringBuilder();
        StringBuilder fullReasonContent = new StringBuilder();
        try (InputStream inputStream = response.body().byteStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 处理每一行
                if (line.isEmpty()) {
                    continue;
                }
                if (line.startsWith("data")) {
                    String dataContent = line.substring(6, line.length() - 1);
                    if (dataContent.startsWith("[DONE]")) {
                        eventQueue.put(new EventInfo("data", "[DONE]"));
                        isFinished = true;
                    }
                    // 解析流数据
                    DSResponseBody rsp = jsonMapper.readValue(line, DSResponseBody.class);
                    if (!rsp.getChoices().isEmpty()) {
                        if (rsp.getChoices().get(0).getFinishReason().equals("stop")) {
                            eventQueue.put(new EventInfo("data", new SteamResponse(true, rsp.getCreated())));
                            isFinished = true;
                            continue;
                        }
                        String content = rsp.getChoices().get(0).getDelta().getContent();
                        String reasoningContent = rsp.getChoices().get(0).getDelta().getReasoningContent();
                        if (!content.isEmpty()) {
                            fullContent.append(content);
                        }
                        if (!reasoningContent.isEmpty()) {
                            fullReasonContent.append(reasoningContent);
                        }
                        eventQueue.put(new EventInfo("data", new SteamResponse(content, reasoningContent, true, rsp.getCreated())));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("流处理异常: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            throw new IOException("流式处理中断", e);
        }

        if (!isFinished) {
            return null;
        }
        return new Pair<>(fullContent.toString(), fullReasonContent.toString());
    }
}
