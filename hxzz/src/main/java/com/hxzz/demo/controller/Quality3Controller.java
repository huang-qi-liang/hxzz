package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Date;
import com.hxzz.demo.bean.Info;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Quality2;
import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.service.Quality3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import static java.lang.Integer.parseInt;

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
@RequestMapping("/Quality3")
public class Quality3Controller {
    @Autowired
    Quality3Service quality3Service;

    @RequestMapping("/show")
    public Result show() {
        List list = new ArrayList<>();
        list = quality3Service.show();
        return Result.succ(list);
    }

    @RequestMapping("/showClient")
    public Result showClient() {
        List list = new ArrayList<>();


        list = quality3Service.showClient();
        Collections.reverse(list);
        return Result.succ(list);
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Info info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<Quality3> pageInfo = quality3Service.findAll(info.getPageNum(), info.getPageSize(), date1, date2);

        return Result.succ(pageInfo);

    }

    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(date.getTime2(), dateTimeFormatter);
        List list = new ArrayList();

        list = quality3Service.infoClient(date1, date2);

        Collections.reverse(list);


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
            quality3Service.del(id);
        }
        return Result.succ("success");
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Quality3 quality3) {
        quality3Service.add(quality3.getName(), quality3.getDC(), quality3.getDD(), quality3.getXB(), quality3.getXC(),
                quality3.getDate());
        return Result.succ("success");
    }

    @RequestMapping("/change")
    public Result change(@RequestBody Quality3 quality3) {
        quality3Service.change(quality3.getId(), quality3.getName(), quality3.getDC(), quality3.getDD(), quality3.getXB(),
                quality3.getXC(), quality3.getDate());
        return Result.succ("success");
    }
}
