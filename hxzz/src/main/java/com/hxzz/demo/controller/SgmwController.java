package com.hxzz.demo.controller;


import com.hxzz.demo.bean.Time;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.result.SgmwPackage;
import com.hxzz.demo.service.AimService;
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
import com.hxzz.demo.bean.Date;

import static java.lang.Integer.parseInt;

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
@RequestMapping("/Sgmw")
public class SgmwController {
    @Autowired
    AimService aimService;
    @Autowired
    SgmwPackage sgmwPackage;

    @RequestMapping("/showClient")
    public Result showClient(){
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate);
        String stringTime=localDate.toString().substring(0,7);
        List list=new ArrayList<>();


        list=sgmwPackage.showPackage();
        return Result.succ(list);

    }


    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(date.getTime1(),dateTimeFormatter);

        LocalDate date2=LocalDate.parse(date.getTime2(),dateTimeFormatter);
        List list=new ArrayList<>();



        list=sgmwPackage.infoPackage(date1,date2);
        return Result.succ(list);

    }

}
