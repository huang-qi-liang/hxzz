package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Date;
import com.hxzz.demo.bean.EquipmentDate;
import com.hxzz.demo.bean.Info;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.PersonnelManagement;
import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.result.PersonManagementPackage;
import com.hxzz.demo.service.PersonnelManagementService;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
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
 * @since 2020-09-16
 */

@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/PersonnelManagement")
public class PersonnelManagementController {
    @Autowired
    PersonnelManagementService personnelManagementService;
@Autowired
    PersonManagementPackage personManagementPackage;
    @RequestMapping("/show")
    public Result show() {
        List list = new ArrayList<>();
        list = personnelManagementService.show();
        return Result.succ(list);
    }

    @RequestMapping("/showClient")
    public Result showClient() {
        List list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());

        list = personnelManagementService.showClient();
        list.add(jsonObject);
        return Result.succ(list);
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Info info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<PersonnelManagement> pageInfo = personnelManagementService.findAll(info.getPageNum(), info.getPageSize(), date1, date2);

        return Result.succ(pageInfo);

    }

    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(date.getTime2(), dateTimeFormatter);
        List list = new ArrayList();

        list = personnelManagementService.infoClient(date1, date2);
        list.add(list);


        return Result.succ(list);

    }

    @RequestMapping("/sgmw")
    public Result sgmw(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = personManagementPackage.line(date.getTime(), "SGMW");

        return Result.succ(list);

    }
    @RequestMapping("/epiboly")
    public Result epiboly(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = personManagementPackage.line(date.getTime(), "外包");

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
            personnelManagementService.del(id);
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
            personnelManagementService.add(jsonObject.getString("name"),jsonObject.getInteger("establishment"),
                    jsonObject.getInteger("actualNumber"),jsonObject.getInteger("availableNumber"),
                    jsonObject.getInteger("shouldArrive"),jsonObject.getFloat("actualArrive"),jsonObject.getString(
                            "shift"),date);
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
            personnelManagementService.change(jsonObject.getInteger("id"),jsonObject.getString("name"),
                    jsonObject.getInteger(
                    "establishment"),
                    jsonObject.getInteger("actualNumber"),jsonObject.getInteger("availableNumber"),
                    jsonObject.getInteger("shouldArrive"),jsonObject.getFloat("actualArrive"),jsonObject.getString(
                            "shift"),date);
        }
        return Result.succ("success");
    }


}
