package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Info;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Aim;
import com.hxzz.demo.entity.Safe;
import com.hxzz.demo.service.AimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hql
 * @since 2020-10-14
 */
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/Aim")
public class AimController {
    @Autowired
    AimService aimService;

    @RequestMapping("/show")
    public Result show() {

        return Result.succ(aimService.show());
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Info info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<Aim> pageInfo = aimService.findAll(info.getPageNum(), info.getPageSize(), date1, date2);

        return Result.succ(pageInfo);

    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody List<JSONObject> list) {

        int size = list.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            String Id = jsonObject.getString("id");
            Long id = Long.parseLong(Id);
            aimService.del(id);
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
          aimService.add(jsonObject.getInteger("security"),jsonObject.getInteger("lzcsj"),jsonObject.getFloat(
                  "quality"),jsonObject.getFloat("equipment"),date);
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
            aimService.change(jsonObject.getLong("id"),jsonObject.getInteger("security"),jsonObject.getInteger(
                    "lzcsj"),
                    jsonObject.getFloat(
                    "quality"),jsonObject.getFloat("equipment"),date);
        }

        return Result.succ("success");
    }


}
