package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.*;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.PersonD;
import com.hxzz.demo.page.PersonDPage;
import com.hxzz.demo.result.PersonDPackage;
import com.hxzz.demo.service.PersonDService;
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
 * @since 2020-09-23
 */
@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/PersonD")
public class PersonDController {
    @Autowired
    PersonDService personDService;
    @Autowired
    PersonDPackage personDPackage;
    @Autowired
    PersonDPage personDPage;

    @RequestMapping("/show")
    public Result show() {

        List list = new ArrayList<>();
        list.add(personDService.show());
        return Result.succ(list);

    }

    @RequestMapping("/showClient")
    public Result showClient() {
        List list = new ArrayList();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        list1 = personDService.showClient();

        list2.add(personDPackage.showClientPackage());

        list.addAll(list1);
        list.addAll(list2);
        return Result.succ(list);


    }

    @RequestMapping("/info")
    public Result info(@RequestBody Info info) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);


        PageInfo<PersonD> pageInfo = personDService.findAll(info.getPageNum(), info.getPageSize(), date1, date2);


//pageInfo.setPageSize(5);
//pageInfo.setSize(5);
        return Result.succ(pageInfo);

    }

    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(date.getTime2(), dateTimeFormatter);
        log.println(date);
        List list = new ArrayList();
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject = personDPackage.ClientPackage(date1, date2);
        list = personDService.getClient(date1, date2);
        list.add(jsonObject);


        return Result.succ(list);

    }
    @RequestMapping("/total")
    public Result total(@RequestBody viewTime date) {

        List list = new ArrayList();
        list = personDPackage.Total(date.getTime());

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
            personDService.del(id);
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
            personDService.add(jsonObject.getString("region"),jsonObject.getInteger("personalLeave"),
                    jsonObject.getInteger("sickLeave"),jsonObject.getInteger("annualLeave"),jsonObject.getInteger(
                            "nursingLeave"),jsonObject.getInteger("bereavementLeave"),jsonObject.getString("shift"),
                    date);
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
            personDService.change(jsonObject.getInteger("id"),jsonObject.getString("region"),jsonObject.getInteger(
                    "personalLeave"),
                    jsonObject.getInteger("sickLeave"),jsonObject.getInteger("annualLeave"),jsonObject.getInteger(
                            "nursingLeave"),jsonObject.getInteger("bereavementLeave"),jsonObject.getString("shift"),
                    date);
        }
        return Result.succ("success");
    }


}
