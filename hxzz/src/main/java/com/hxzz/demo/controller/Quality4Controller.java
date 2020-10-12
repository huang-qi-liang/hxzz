package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Quality4;
import com.hxzz.demo.service.Quality4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/Quality4")
public class Quality4Controller {
    @Autowired
    Quality4Service quality4Service;
    @RequestMapping("/show")
    public Result show(){
        List list=new ArrayList<>();
        return Result.succ(list);
    }
    @RequestMapping("/showClient")
    public Result showClient(){
        List list=new ArrayList<>();
        return Result.succ(list);
    }
    @RequestMapping("/info")
    public Result info(@RequestParam(value="time1",required =false) String time1, @RequestParam(value="time2",
            required = false) String time2){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(time1,dateTimeFormatter);

        LocalDate date2=LocalDate.parse(time2,dateTimeFormatter);
        List list= new ArrayList();

        return Result.succ(list);

    }
    @RequestMapping("/infoClient")
    public Result infoClient(@RequestParam(value="time1",required =false) String time1, @RequestParam(value="time2",
            required = false) String time2){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(time1,dateTimeFormatter);

        LocalDate date2=LocalDate.parse(time2,dateTimeFormatter);
        List list= new ArrayList();

        return Result.succ(list);

    }
    @RequestMapping("/delete")
    public Result delete(@RequestParam(value="id",required =false)Integer id){
        quality4Service.del(id);
        return Result.succ("success");
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Quality4 quality4){
        quality4Service.add(quality4.getTarget(),quality4.getActual(),quality4.getResponsibility(),
                quality4.getInterceptionProblem(),quality4.getQuantity());
        return Result.succ("success");
    }
    @RequestMapping("/change")
    public Result change(@RequestBody Quality4 quality4){
        quality4Service.change(quality4.getId(),quality4.getTarget(),quality4.getActual(),quality4.getResponsibility(),
                quality4.getInterceptionProblem(),quality4.getQuantity());
        return Result.succ("success");
    }
}
