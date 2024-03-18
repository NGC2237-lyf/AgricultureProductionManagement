package com.management.utils;

import com.alibaba.fastjson2.JSONObject;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

/**
 * @author TokisakiKurumi
 * @className ChatGgtUtils
 * @date 2024/3/7
 * @description
 **/
public class ChatGgtUtils {

    private static final String URL = "https://api.chatanywhere.com.cn/v1/chat/completions";
    private static final String API_KEY = "Bearer sk-IzMUtjQ5gofuUlFLeBRqGJJR4EqV3gXy3dyruk0XVlgBB80M";

    public static String sendQuestion(String question) {
        String jsonBody = "{"
                + "\"model\": \"gpt-3.5-turbo\","
                + "\"messages\": "
                + "[{\"role\": \"user\", \"content\": \"" + question + "\"}]"
                + "}";
        String result = null;
        HttpPost httpPost = new HttpPost(URL);
        httpPost.addHeader("Authorization", API_KEY);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(new StringEntity(jsonBody, ContentType.APPLICATION_JSON));
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            try(CloseableHttpResponse response = httpClient.execute(httpPost)) {
                result = JSONObject.parseObject(EntityUtils.toString(response.getEntity()))
                        .getJSONArray("choices").getJSONObject(0)
                        .getJSONObject("message").getString("content");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
