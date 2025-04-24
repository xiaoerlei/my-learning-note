package zhulei.Utils;

import okhttp3.*;

public class OkHttpUtils {
    private static final OkHttpClient client = new OkHttpClient();

    /**
     * 发送GET请求
     * @param url 请求地址
     */
    public static String get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * 发送POST请求
     * @param url 请求地址
     * @param json 请求体JSON
     */
    public static String post(String url, String json) throws Exception {
        RequestBody body = RequestBody.create(
                json, MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}

