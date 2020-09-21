package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.result.SgmwPackage;
import com.hxzz.demo.service.SgmwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

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
@RequestMapping("/sgmw")
public class SgmwController {
    @Autowired
    SgmwService sgmwService;
    @Autowired
    SgmwPackage sgmwPackage;
    @RequestMapping("/show")
    public JSONObject show(){
        JSONObject objectaim=new JSONObject(new LinkedHashMap<>());
        JSONObject objectactual=new JSONObject(new LinkedHashMap<>());
objectaim=sgmwPackage.aimwjson();
objectactual=sgmwPackage.actualjson();
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(0,objectaim);
        jsonArray.add(1,objectactual);
        JSONObject result1=new JSONObject();
        result1.put("total",2);
        result1.put("message",jsonArray);
        JSONObject result=new JSONObject();
        result.put("data",result1);

return result;
    }



}
