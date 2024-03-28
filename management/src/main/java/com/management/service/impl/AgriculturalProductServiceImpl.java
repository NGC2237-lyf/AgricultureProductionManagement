package com.management.service.impl;

import cn.hutool.extra.pinyin.engine.pinyin4j.Pinyin4jEngine;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.entity.AgriculturalProduct;
import com.management.entity.AgriculturalProductPrice;
import com.management.entity.AgriculturalProductSales;
import com.management.entity.thread.WebThread;
import com.management.mapper.AgriculturalProductPriceMapper;
import com.management.service.AgriculturalProductService;
import com.management.mapper.AgriculturalProductMapper;
import com.management.utils.CrawlerUtils;
import com.management.utils.PinYinUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 * @description 针对表【agricultural_product】的数据库操作Service实现
 * @createDate 2024-03-07 21:03:05
 */
@Service
public class AgriculturalProductServiceImpl extends ServiceImpl<AgriculturalProductMapper, AgriculturalProduct>
        implements AgriculturalProductService {

    @Autowired
    private AgriculturalProductMapper agriculturalProductMapper;

    @Autowired
    private AgriculturalProductPriceMapper agriculturalProductPriceMapper;

    @Override
    public boolean insertProduct(AgriculturalProduct product) {
        boolean result = save(product);
        new Thread(() -> {
            findData(product);
        });
        return result;
    }

    public void findData(AgriculturalProduct product) {
        String pinYin = PinYinUtils.toChinesePinYin(product.getProductName());
        char[] chars = product.getProductName().toCharArray();
        String pinYinM = "";
        for (int i = 0; i < chars.length; i++) {
            pinYinM += PinYinUtils.toChinesePinYin(String.valueOf(chars[i])).substring(0, 1);
        }
        Elements boxes;
        WebThread webThread1 = new WebThread("https://www.cnhnb.com/p/" + pinYin);
        WebThread webThread2 = new WebThread("https://www.cnhnb.com/p/" + pinYinM);
        webThread1.start();
        webThread2.start();
        while (webThread1.isAlive() || webThread2.isAlive()) {
        }
        boxes = WebThread.boxes;
        WebThread.boxes = null;
        if (!boxes.isEmpty()) {
            for (int i = 0; i < boxes.size(); i++) {
                if (!boxes.get(i).getElementsByTag("h2").html().contains(product.getProductName())) {
                    boxes.remove(i);
                }
            }
        }
        if (!boxes.isEmpty()) {
            for (int i = 0; i < Math.min(boxes.size(), 5); i++) {
                BigDecimal price = new BigDecimal(boxes.get(i).getElementsByClass("sp1").text());
                String unit = boxes.get(i).getElementsByClass("shops-price").text();
                String description = boxes.get(i).getElementsByTag("h2").text();
                AgriculturalProductPrice agriculturalProductPrice = new AgriculturalProductPrice();
                agriculturalProductPrice.setProductId(product.getProductId());
                agriculturalProductPrice.setProductName(product.getProductName());
                agriculturalProductPrice.setPrice(price);
                agriculturalProductPrice.setUnit(unit);
                agriculturalProductPrice.setDescription(description);
                agriculturalProductPriceMapper.insert(agriculturalProductPrice);
            }
        }
    }

    public List<AgriculturalProductPrice> findData(String word) {
        String pinYin = PinYinUtils.toChinesePinYin(word);
        char[] chars = word.toCharArray();
        String pinYinM = "";
        for (int i = 0; i < chars.length; i++) {
            pinYinM += PinYinUtils.toChinesePinYin(String.valueOf(chars[i])).substring(0, 1);
        }
        Elements boxes;
        List<AgriculturalProductPrice> agriculturalProductPrices = new ArrayList<>();
        WebThread webThread1 = new WebThread("https://www.cnhnb.com/p/" + pinYin);
        WebThread webThread2 = new WebThread("https://www.cnhnb.com/p/" + pinYinM);
        webThread1.start();
        webThread2.start();
        while (webThread1.isAlive() || webThread2.isAlive()) {
        }
        boxes = WebThread.boxes;
        WebThread.boxes = null;
        if (!ObjectUtils.isEmpty(boxes)) {
            for (int i = 0; i < boxes.size(); i++) {
                if (!boxes.get(i).getElementsByTag("h2").html().contains(word)) {
                    boxes.remove(i);
                }
            }
        }
        if (!ObjectUtils.isEmpty(boxes)) {
            for (int i = 0; i < Math.min(boxes.size(), 5); i++) {
                BigDecimal price = new BigDecimal(boxes.get(i).getElementsByClass("sp1").text());
                String unit = boxes.get(i).getElementsByClass("shops-price").text();
                String description = boxes.get(i).getElementsByTag("h2").text();
                AgriculturalProductPrice agriculturalProductPrice = new AgriculturalProductPrice();
                agriculturalProductPrice.setProductName(word);
                agriculturalProductPrice.setPrice(price);
                agriculturalProductPrice.setUnit(unit);
                agriculturalProductPrice.setDescription(description);
                agriculturalProductPrices.add(agriculturalProductPrice);
            }
        }
        return agriculturalProductPrices;
    }

    public void updateData(Integer productId, String word) {
        String pinYin = PinYinUtils.toChinesePinYin(word);
        List<AgriculturalProductPrice> agriculturalProductPrices = new ArrayList<>();
        WebThread webThread = new WebThread("https://www.cnhnb.com/p/" + pinYin);
        webThread.start();
        Elements boxes = WebThread.boxes;
        WebThread.boxes = null;
        if (!boxes.isEmpty()) {
            for (int i = 0; i < boxes.size(); i++) {
                if (!boxes.get(i).getElementsByTag("h2").html().contains(word)) {
                    boxes.remove(i);
                }
            }
        }
        if (!boxes.isEmpty()) {
            for (int i = 0; i < Math.min(boxes.size(), 5); i++) {
                BigDecimal price = new BigDecimal(boxes.get(i).getElementsByClass("sp1").text());
                String unit = boxes.get(i).getElementsByClass("shops-price").text();
                String description = boxes.get(i).getElementsByTag("h2").text();
                AgriculturalProductPrice agriculturalProductPrice = new AgriculturalProductPrice();
                agriculturalProductPrice.setProductName(word);
                agriculturalProductPrice.setPrice(price);
                agriculturalProductPrice.setUnit(unit);
                agriculturalProductPrice.setDescription(description);
                agriculturalProductPrices.add(agriculturalProductPrice);
                agriculturalProductPriceMapper.update(agriculturalProductPrice, new QueryWrapper<AgriculturalProductPrice>().eq("product_id", productId));
            }
        }
    }
}




