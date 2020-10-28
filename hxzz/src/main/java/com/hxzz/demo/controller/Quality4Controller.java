package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.bean.Date;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Quality4;
import com.hxzz.demo.result.Quality4Package;
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
import java.util.LinkedHashMap;
import java.util.List;

import static java.lang.Integer.parseInt;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * <p>
 * 前端控制器
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
    Quality4Package quality4Package;

    @RequestMapping("/showClient")
    public Result showClient() {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject = quality4Package.showPackage();
        return Result.succ(jsonObject);
    }


    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(date.getTime2(), dateTimeFormatter);
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject = quality4Package.infoPackage(date1, date2);

        return Result.succ(jsonObject);

    }

}
