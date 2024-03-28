package com.management.entity.thread;

import com.management.utils.CrawlerUtils;
import lombok.Data;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.IOException;

/**
 * @author TokisakiKurumi
 * @className WebThread
 * @date 2024/3/21
 * @description
 **/
@Data
public class WebThread extends Thread {

    public static Elements boxes = null;
    private String url = "";

    @Override
    public void run() {
        Document document = null;
        try {
            document = CrawlerUtils.fetch(url);
        } catch (IOException e) {
            return;
        }
        if (ObjectUtils.isEmpty(document)) {
            return;
        }
        Elements elements = document.getElementsByClass("show-ctn");
        if (!ObjectUtils.isEmpty(elements)) {
            boxes = elements;
        }
    }

    public WebThread(String url) {
        this.url = url;
    }
}

