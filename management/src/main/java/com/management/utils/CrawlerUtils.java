package com.management.utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author TokisakiKurumi
 * @className CrawlerUtils
 * @date 2024/3/7
 * @description
 **/
public class CrawlerUtils {

    private static WebClient webClient = new WebClient(BrowserVersion.FIREFOX);

    public static Document fetch(String url) {
        try {
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setActiveXNative(false);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            Page page = webClient.getPage(url);
            HtmlPage htmlPage = null;
            if (page.isHtmlPage()) {
                htmlPage = (HtmlPage) page;
            } else {
                return null;
            }
            webClient.waitForBackgroundJavaScript(5000);
            return Jsoup.parse(htmlPage.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
        return null;
    }
}
