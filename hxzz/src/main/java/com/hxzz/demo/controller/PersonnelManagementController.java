package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.PersonnelManagement;
import com.hxzz.demo.service.PersonnelManagementService;
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
