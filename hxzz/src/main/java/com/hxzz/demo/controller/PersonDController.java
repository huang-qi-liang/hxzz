package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.PersonD;
import com.hxzz.demo.result.PersonDPackage;
import com.hxzz.demo.service.PersonDService;
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
 * @since 2020-09-23
 */
@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/personD")
public class PersonDController {
    @Autowired
    PersonDService personDService;
    @Autowired
    PersonDPackage personDPackage;
    @RequestMapping("/show")
    public Result show(){
        List<JSONObject> list=new ArrayList<>();
        list=personDPackage.PersonDPackage();
        return Result.succ(list);

    }
    @RequestMapping("/info")
    public void info(){
        List<JSONObject> list=new ArrayList<>();

    }
    @RequestMapping("/delete")
    public Result delete(@RequestParam(value="id",required =false)Integer id){
        personDService.del(id);
        return Result.succ("success");
    }
@RequestMapping("/add")
    public Result add(@RequestBody PersonD personD){
        personDService.add(personD.getRegion(),personD.getPersonalLeave(),personD.getSickLeave(),
                personD.getAnnualLeave(),personD.getNursingLeave(),personD.getBereavementLeave());
return Result.succ("success");

    }
    @RequestMapping("/change")
    public Result change(@RequestBody PersonD personD){
        personDService.change(personD.getId(),personD.getRegion(),personD.getPersonalLeave(),personD.getSickLeave(),
                personD.getAnnualLeave(),personD.getNursingLeave(),personD.getBereavementLeave());
        return Result.succ("success");
    }

}
