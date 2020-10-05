package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
@RequestMapping("/quality")
public class QualityController {
    @Autowired
    QualityService qualityService;
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
        qualityService.del(id);
        return Result.succ("success");
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Quality quality){
        qualityService.add(quality.getName(),quality.getOffLine(),quality.getDLine(),quality.getLingYu(),
                quality.getCareLine(),quality.getRoadTest());

        return Result.succ("success");
    }
    @RequestMapping("/change")
    public Result change(@RequestBody Quality quality){
        qualityService.change(quality.getId(),quality.getName(),quality.getOffLine(),quality.getDLine(),quality.getLingYu(),
                quality.getCareLine(),quality.getRoadTest());
        return Result.succ("success");
    }
}
