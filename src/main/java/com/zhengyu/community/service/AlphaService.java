package com.zhengyu.community.service;

import com.zhengyu.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public String find() {
        return alphaDao.select();
    }


    //构造器：无参构造中输入了一段话
    public AlphaService() {
        System.out.println("实例化AlphaService");
    }

    @PostConstruct
    //这个注解的意思是：这个方法会在构造器之后调用
    public void init() {
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    //这个注解的意思是：销毁
    public void destory() {
        System.out.println("销毁AlphaService");
    }
}
