package com.management.controller;

import com.management.utils.ChatGgtUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TokisakiKurumi
 * @className OnlineCustomerServiceController
 * @date 2024/3/13
 * @description
 **/
@RestController
@RequestMapping("/online")
public class OnlineCustomerServiceController {

    @GetMapping()
    public AjaxResult getAnswer(@RequestParam("q") String question) {
        String answer = ChatGgtUtils.sendQuestion(question);
        if (StringUtils.isEmpty(answer)) {
            return AjaxResult.warn("暂无答案");
        }
        return AjaxResult.success(answer);
    }
}
