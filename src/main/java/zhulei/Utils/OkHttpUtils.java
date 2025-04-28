package zhulei.Utils;

import okhttp3.*;
import java.util.Map;

public class OkHttpUtils {
    private static final OkHttpClient client = new OkHttpClient.Builder()
        .retryOnConnectionFailure(true)  // 自动重试
        .build();

    /**
     * 发送GET请求
     *
     * @param url 请求地址
     */
    public static Response get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response;
        }
    }

    /**
     * 发送POST请求
     *
     * @param url     请求地址
     * @param headers 请求头
     * @param json    请求体JSON
     */
    public static Response post(String url, Map<String, String> headers, String json) throws Exception {
        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));

        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(body);

        // 添加请求头
        requestBuilder.addHeader("Content-Type", "application/json");
        requestBuilder.addHeader("Connection", "keep-alive");
        requestBuilder.addHeader("Accept-Encoding", "gzip, deflate, br, chunked");
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        try (Response response = client.newCall(requestBuilder.build()).execute()) {
            return response;
        }
    }
}

