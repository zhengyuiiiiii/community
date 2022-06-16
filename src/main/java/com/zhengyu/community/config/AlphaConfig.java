package com.zhengyu.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {

    @Bean
    //意思是：这个方法返回的对象将被装入容器中
    public SimpleDateFormat simpleDateFormat() {
        return  new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    }
}
