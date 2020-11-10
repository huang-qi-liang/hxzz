package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.*;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Quality2;
import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.entity.Scgl;
import com.hxzz.demo.result.ScglPackage;
import com.hxzz.demo.service.ScglService;
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
 * @since 2020-10-12
 */
@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/Scgl")
public class ScglController {
    @Autowired
    ScglService scglService;
    @Autowired
    ScglPackage scglPackage;

    @RequestMapping("/show")
    public Result show() {
        List list = new ArrayList<>();
        list = scglService.show();
        return Result.succ(list);
    }

    @RequestMapping("/showClient")
    public Result showClient() {
        List list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject = scglPackage.showPackage();
        list = scglService.showClient();
        list.add(jsonObject);
        return Result.succ(list);
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Info info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<Scgl> pageInfo = scglService.findAll(info.getPageNum(), info.getPageSize(), date1, date2);

        return Result.succ(pageInfo);

    }
    @RequestMapping("/infoShift")
    public Result infoShift(@RequestBody InfoShift info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<Scgl> pageInfo = scglService.findShiftAll(info.getName(),info.getPageNum(), info.getPageSize(),
                date1, date2);

        return Result.succ(pageInfo);

    }

    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(date.getTime2(), dateTimeFormatter);
        List list = new ArrayList();
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject = scglPackage.ClientPackage(date1, date2);
        list = scglService.infoClient(date1, date2);
        list.add(jsonObject);


        return Result.succ(list);

    }

    @RequestMapping("/showAll")
    public Result showAll() {
        List list = new ArrayList<>();
        list = scglPackage.showAllPackage();
        return Result.succ(list);
    }

    @RequestMapping("/infoAll")
    public Result infoAll(@RequestBody Date date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(date.getTime2(), dateTimeFormatter);
        List list = new ArrayList();
        list = scglPackage.infoAllPackage(date1, date2);

        return Result.succ(list);

    }
    //生产管理总计柱形图接口
    @RequestMapping("/lineTotal")
    public Result lineTotal(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = scglPackage.lineTotal(date.getTime());

        return Result.succ(list);

    }
    //生产管理A线柱形图接口
    @RequestMapping("/lineA")
    public Result lineA(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = scglPackage.line(date.getTime(), "西部A线");

        return Result.succ(list);

    }
    //生产管理B线柱形图接口
    @RequestMapping("/lineB")
    public Result lineB(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = scglPackage.line(date.getTime(), "西部B线");
        return Result.succ(list);

    }
    //生产管理C线柱形图接口
    @RequestMapping("/lineC")
    public Result lineC(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = scglPackage.line(date.getTime(), "东部C线");
        return Result.succ(list);

    }
    //生产管理D线柱形图接口
    @RequestMapping("/lineD")
    public Result lineD(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = scglPackage.line(date.getTime(), "东部D线");
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
            scglService.del(id);
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
            scglService.add(jsonObject.getString("name"),jsonObject.getInteger("targetCapacity"),jsonObject.getFloat(
                    "actualCapacity"),jsonObject.getFloat("workingHours"),
                    jsonObject.getFloat("beat"),jsonObject.getString("shift"),date);
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
            scglService.change(jsonObject.getInteger("id"),jsonObject.getString("name"),jsonObject.getInteger(
                    "targetCapacity"),
                    jsonObject.getFloat(
                    "actualCapacity"),jsonObject.getFloat("workingHours"),
                    jsonObject.getFloat("beat"),jsonObject.getString("shift"),date);
        }
        return Result.succ("success");
    }
}
