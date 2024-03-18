package com.management.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Address;
import javax.mail.Message;
import java.util.Date;

/**
 * @author TokisakiKurumi
 * @className EmailUtils
 * @date 2024/3/11
 * @description
 **/
@Component
public class EmailUtils {

    private static final String FROM = "2105721136@qq.com";

    @Autowired
    private static JavaMailSender javaMailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        EmailUtils.javaMailSender = javaMailSender;
    }

    public static void sendMessage(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(FROM);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSentDate(new Date());
        javaMailSender.send(simpleMailMessage);
    }
}
