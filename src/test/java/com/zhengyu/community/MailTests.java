package com.zhengyu.community;

import com.zhengyu.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailClient.sendMail("1016202423@qq.com","小鱼发的","潘潘最好看");
    }


    @Test
    public void testHtmlMail() {
        Context context = new Context();   //注意是thymeleaf的类
        context.setVariable("username", "sunday");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

         mailClient.sendMail("1016202423@qq.com", "HTML", content);
    }



}
