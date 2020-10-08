package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSON;
import com.hxzz.demo.entity.User;
import com.hxzz.demo.service.UserService;
import com.hxzz.demo.service.WebSocket;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static jdk.internal.org.objectweb.asm.Type.getType;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 *
 *
 */
@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
     WebSocket webSocket;

    @PostMapping("/login")

    @ApiOperation(value = "用户登录")
 public String login(@RequestBody User user1){
System.out.println(getType(user1.getUsername()));
        Map<String,Object> map=new HashMap<>();
        User user=userService.loginIN(user1.getUsername(),user1.getPassword());
        log.println(user1);
        //int user1num=Integer.parseInt(user1.getPassword());
       // log.println(user1num);
        map.put("user",user);
if(user!=null)
{System.out.println("login success");
    return  "200";
    /*Random r=new Random();

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    String s=String.valueOf(r.nextInt(1000));
    System.out.println(s);

    return s;

     */



}
else
{System.out.println("have data");
    return  "404";
}


    }
/*@PostMapping("/add")
    public String add(@RequestBody User user2){
        System.out.println("sussec??c");

        userService.addIN(user2.getUsername(),user2.getPassword());
return "保存成功";


}
    @RequestMapping("/json")
    @Scheduled(fixedRate = 1000)
    public void getMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("地学会",3245);
        map.put("sdf","hhh");
String string= JSON.toJSONString(map);
webSocket.sendOneMessage("user",string);
    }


    @RequestMapping("getData")
    public List<User> getData(){
        return  userService.getDataIN( "b");

    }
    @RequestMapping("test")
    public String sse(){
        Random r=new Random();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:当前增加的收入："+r.nextInt(1000)+"元"+"\n\n";
    }

 */


}
