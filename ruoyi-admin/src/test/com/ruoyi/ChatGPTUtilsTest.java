package com.ruoyi;

import com.management.utils.ChatGPTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author TokisakiKurumi
 * @className ChatGPTUtilsTest
 * @date 2024/3/7
 * @description
 **/
@SpringBootTest
public class ChatGPTUtilsTest {
    @Test
    void testAPI() {
        System.out.println(ChatGPTUtils.sendQuestion("你好"));
    }
}
