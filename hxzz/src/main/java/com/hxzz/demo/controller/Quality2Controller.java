package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Date;
import com.hxzz.demo.bean.Info;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.PersonX;
import com.hxzz.demo.entity.Quality2;
import com.hxzz.demo.result.Quality2Package;
import com.hxzz.demo.service.Quality2Service;
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

/**
 * <p>
 *  前端控制器
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
@RequestMapping("/Quality2")
public class Quality2Controller {
    @Autowired
    Quality2Service quality2Service;
    @Autowired
    Quality2Package quality2Package;
    @RequestMapping("/show")
    public Result show(){
        List list=new ArrayList<>();
       list=quality2Service.show();
        return Result.succ(list);
    }
    @RequestMapping("/showClient")
    public Result showClient(){
        List list=new ArrayList<>();
        JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
        jsonObject=quality2Package.showPackage();
        list=quality2Service.showClient();
        list.add(jsonObject);
        return Result.succ(list);
    }
    @RequestMapping("/info")
    public Result info(@RequestBody Info info){

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(info.getTime1(),dateTimeFormatter);

        LocalDate date2=LocalDate.parse(info.getTime2(),dateTimeFormatter);

        PageInfo<Quality2> pageInfo=quality2Service.findAll(info.getPageNum(),info.getPageSize(),date1,date2);

        return Result.succ(pageInfo);

    }
    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(date.getTime1(),dateTimeFormatter);

        LocalDate date2=LocalDate.parse(date.getTime2(),dateTimeFormatter);
        List list=new ArrayList();
        JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
        jsonObject=quality2Package.ClientPackage(date1,date2);
        list=quality2Service.infoClient(date1,date2);
        list.add(jsonObject);



        return Result.succ(list);

    }
    @RequestMapping("/delete")
    public Result delete(@RequestParam(value="id",required =false)Integer id){
        quality2Service.del(id);
        return Result.succ("success");
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Quality2 quality2){
        quality2Service.add(quality2.getProductionLine(),quality2.getBreakpoint(),quality2.getPaa(),quality2.getPtr()
                ,quality2.getCraft(),quality2.getTools());
        return Result.succ("success");
    }
    @RequestMapping("/change")
    public Result change(@RequestBody Quality2 quality2){
        quality2Service.change(quality2.getId(),quality2.getProductionLine(),quality2.getBreakpoint(),quality2.getPaa(),quality2.getPtr()
                ,quality2.getCraft(),quality2.getTools());
        return Result.succ("success");
    }
}
