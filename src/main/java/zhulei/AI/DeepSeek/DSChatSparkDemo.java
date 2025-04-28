package zhulei.AI.DeepSeek;

import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.Pair;
import spark.Request;
import spark.Response;
import spark.Route;
import zhulei.AI.Entity.EventInfo;
import zhulei.AI.Entity.Message;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static spark.Spark.*;
public class DSChatSparkDemo {

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    private static final BlockingQueue<EventInfo> eventQueue = new LinkedBlockingQueue<>(1000); // 定义一个消息内容队列，最多缓存 1000 条

    public static void main(String[] args) {
        port(8080);

        // 获取 ds 的流式数据（调试接口）
        getStreamData();

        // 发送 sse
        get("/chat", new SseHandler());
    }

    private static void getStreamData() {
        Thread producerThread = new Thread(() -> {
            // 创建对话内容
            List<Message> chatMessage = new ArrayList<>();
            chatMessage.add(new Message("system", "你是一个生活技能大师，了解很多丰富且有趣的生活技能，擅长聊天、解决和分析问题、翻译、阅读等等，并且乐于帮忙别人解决问题", ""));
            chatMessage.add(new Message("user", "如何有效的锻炼能够达到健康的减肥效果", ""));
            // 请求 ds 接口，拿到流式数据
            DeepSeekAPIService deepSeekAPIService = new DeepSeekAPIServiceImpl();
            try {
                Pair<String, String> chatResult = deepSeekAPIService.chat(chatMessage, eventQueue);
                // 输出结果
                System.out.println("Content: " + chatResult.getFirst());
                System.out.println("ReasoningContent: " + chatResult.getSecond());
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        });
        producerThread.setDaemon(true); // 设置为守护线程，主线程退出时自动终止
        producerThread.start();
    }

    // SSE 处理器（消费者）
    static class SseHandler implements Route {
        @Override
        public Object handle(Request request, Response response) throws Exception {
            response.type("text/event-stream");
            response.header("Cache-Control", "no-cache");
            response.header("Connection", "keep-alive");

            PrintWriter writer = response.raw().getWriter();

            try {
                // 持续消费队列数据，直到线程被中断
                while (!Thread.currentThread().isInterrupted()) {
                    EventInfo event = eventQueue.take(); // 阻塞直到有数据
                    StringBuilder sb = new StringBuilder();
                    if (event.getName() != null) {
                        sb.append("data: ").append(jsonMapper.writeValueAsString(event.getMessage())).append("\n");
                    }
                    writer.write(sb.toString()); // 写出完整 SSE 消息
                    writer.flush();
                }
            } catch (InterruptedException e) {
                System.out.println("sse consumer thread interrupted.");
            }

            return "";
        }
    }

}
