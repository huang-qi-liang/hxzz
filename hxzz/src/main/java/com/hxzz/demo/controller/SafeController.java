package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Date;
import com.hxzz.demo.bean.Info;
import com.hxzz.demo.bean.Time;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.entity.Safe;
import com.hxzz.demo.result.SafePackage;
import com.hxzz.demo.service.SafeService;
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

/**
 * <p>
 * 前端控制器
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
@RequestMapping("/Safe")
public class SafeController {
    @Autowired
    SafeService safeService;
    @Autowired
    SafePackage safePackage;

    @RequestMapping("/show")
    public Result show() {
        List list = new ArrayList<>();
        list = safeService.show();
        return Result.succ(list);
    }

    @RequestMapping("/showClient")
    public Result showClient() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        String stringTime = localDate.toString().substring(0, 7);
        List list = new ArrayList<>();

        int size = safeService.showClient(stringTime).size();
        list = safePackage.showPackage(safeService.showClient(stringTime), size);
        return Result.succ(list);

    }

    @RequestMapping("/info")
    public Result info(@RequestBody Info info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<Safe> pageInfo = safeService.findAll(info.getPageNum(), info.getPageSize(), date1, date2);

        return Result.succ(pageInfo);

    }

    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Time time) {
        List list = new ArrayList<>();


        int size = safeService.showClient(time.getTime()).size();
        list = safePackage.showPackage(safeService.showClient(time.getTime()), size);
        return Result.succ(list);

    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody List<JSONObject> list) {

        int size = list.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            String Id = jsonObject.getString("id");
            Integer id = parseInt(Id, 10);
            safeService.del(id);
        }
        return Result.succ("success");
    }

    @RequestMapping("/add")
    public Result add(@RequestBody List<JSONObject> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {

            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date=LocalDate.parse(jsonObject.getString("date"),dateTimeFormatter);
            safeService.add(jsonObject.getInteger("grey"),jsonObject.getInteger("blue"),jsonObject.getInteger("yellow"),jsonObject.getInteger("red"),date);
        }
        return Result.succ("success");
    }

    @RequestMapping("/change")
    public Result change(@RequestBody List<JSONObject> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {

            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date=LocalDate.parse(jsonObject.getString("date"),dateTimeFormatter);
            safeService.change(jsonObject.getInteger("id"),jsonObject.getInteger("grey"),jsonObject.getInteger("blue"),
                    jsonObject.getInteger(
                    "yellow")
                    ,jsonObject.getInteger("red"),date);
        }
        return Result.succ("success");
    }


}
