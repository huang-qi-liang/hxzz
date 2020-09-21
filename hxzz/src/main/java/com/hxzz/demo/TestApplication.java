package com.hxzz.demo;

import com.alibaba.fastjson.JSONObject;
//测试用代码
import com.hxzz.demo.service.ScglDDService;
import com.hxzz.demo.service.UserService;
import com.hxzz.demo.entity.User;
import com.hxzz.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Component
@Configuration
@EnableScheduling
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {

    @Autowired
    UserService userService;
@Autowired
    ScglDDService scglDDService;
    @Test
    //@Scheduled(fixedRate = 1000)
    public void contextLoads() {
  /* User user = null;


   userService.addIN("nihaoya","ggg");
        System.out.println("该用户ID为："+user.getId());
        if(user==null)
        {
            System.out.println("用户为空");
        }



  System.out.println(userService.getDataIN((long) 1));
   System.out.println(user.getId());


        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());*/
        /*List<User> list=userService.getDataIN( "b");
       System.out.println( list.get(0).getUsername());*/

        JSONObject object12= (JSONObject) new JSONObject(new HashMap<>()).toJSON(scglDDService.showIN());
        log.println(object12);
    }





}

