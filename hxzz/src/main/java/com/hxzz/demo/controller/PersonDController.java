package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.result.PersonDPackage;
import com.hxzz.demo.service.PersonDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    public List<JSONObject> show(){
        List<JSONObject> list=new ArrayList<>();
        list=personDPackage.PersonDPackage();
        return list;

    }

}
