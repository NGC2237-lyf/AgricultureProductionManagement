package com.management.entity.thread;

import com.management.utils.CrawlerUtils;
import lombok.Data;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.ObjectUtils;

/**
 * @author TokisakiKurumi
 * @className WebThread
 * @date 2024/3/21
 * @description
 **/
@Data
public class WebThread extends Thread {

    public static Elements boxes = new Elements();
    private String url = "";

    @Override
    public void run() {
        Document document = CrawlerUtils.fetch(url);
        if (ObjectUtils.isEmpty(document)) {
            return;
        }
        Elements boxes = document.getElementsByClass("show-ctn");
        if (!ObjectUtils.isEmpty(boxes)) {
            WebThread.boxes = boxes;
        }
    }

    public WebThread(String url) {
        this.url = url;
    }
}

