package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.common.lang.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hql
 * @since 2020-09-27
 */
@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/safe")
public class SafeController {
    @Autowired

    @RequestMapping("/show")
    public Result show(){
        List<JSONObject> list=new ArrayList<>();
        return Result.succ(list);
    }
    @RequestMapping("/info")
    public Result info(@RequestParam(value="time1",required =false) LocalDate time1, @RequestParam(value="time2",
            required = false) LocalDate time2){
        List<JSONObject> list=new ArrayList<>();
        return Result.succ(list);
    }
    @RequestMapping("/delete")
    public Result delete(@RequestParam(value="id",required =false)Integer id){
        return Result.succ("success");
    }
    @RequestMapping("/add")
    public Result add(){
        return Result.succ("success");
    }
    @RequestMapping("/change")
    public Result change(){
        return Result.succ("success");
    }
}
