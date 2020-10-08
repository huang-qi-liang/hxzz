package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.PersonnelManagement;
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
import java.util.List;

/**
 * <p>
 *  前端控制器
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
@RequestMapping("/personnelManagement")
public class PersonnelManagementController {
    @Autowired
    PersonnelManagementService personnelManagementService;
    @RequestMapping("/show")
    public Result show(){
        List list1=new ArrayList<>();
        List list2=new ArrayList();
        list1.add(personnelManagementService.showSgmwIN());
        list2.add(personnelManagementService.showOutsourceIN());
        list1.add(list2);
        return Result.succ(list1);
    }
    @RequestMapping("/showClient")
    public Result showClient(){

        List list1=new ArrayList<>();
        List list2=new ArrayList();
        list1.add(personnelManagementService.showSgmwIN());
        list2.add(personnelManagementService.showOutsourceIN());
        list1.add(list2);
        return Result.succ(list1);
    }
    @RequestMapping("/info")
    public Result info(@RequestParam(value="time1",required =false) String time1, @RequestParam(value="time2",
            required = false) String time2){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(time1,dateTimeFormatter);

        LocalDate date2=LocalDate.parse(time2,dateTimeFormatter);
       List list= new ArrayList();
       list.add(personnelManagementService.getData(date1,date2));
        return Result.succ(list);

    }
    @RequestMapping("/infoClient")
    public Result infoClient(@RequestParam(value="time1",required =false) String time1, @RequestParam(value="time2",
            required = false) String time2){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(time1,dateTimeFormatter);

        LocalDate date2=LocalDate.parse(time2,dateTimeFormatter);
        List list= new ArrayList();
        list.add(personnelManagementService.getClient(date1,date2));
        return Result.succ(list);

    }

    @RequestMapping("/delete")
    public Result delete(@RequestParam(value="id",required =false)Integer id){
        personnelManagementService.delIN(id);
        return Result.succ("success");
    }
    @RequestMapping("/add")
    public Result add(@RequestBody PersonnelManagement personnelManagement){
        personnelManagementService.addIN(personnelManagement.getName(),personnelManagement.getEstablishment(),
                personnelManagement.getActualNumber(),personnelManagement.getAvailableNumber(),
                personnelManagement.getAttendanceRate(),personnelManagement.getShouldArrive(),personnelManagement.getActualArrive());
        return Result.succ("success");
    }
    @RequestMapping("/change")
    public Result change(@RequestBody PersonnelManagement personnelManagement){
        personnelManagementService.changeIN(personnelManagement.getId(),personnelManagement.getName(),personnelManagement.getEstablishment(),
                personnelManagement.getActualNumber(),personnelManagement.getAvailableNumber(),
                personnelManagement.getAttendanceRate(),personnelManagement.getShouldArrive(),personnelManagement.getActualArrive());
        return Result.succ("success");
    }




}
