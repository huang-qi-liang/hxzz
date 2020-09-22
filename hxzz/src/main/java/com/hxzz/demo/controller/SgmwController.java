package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.result.SgmwList;
import com.hxzz.demo.result.SgmwPackage;
import com.hxzz.demo.service.SgmwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

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
    @Autowired
    SgmwList sgmwList;
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
    @RequestMapping("/info")
    public List<JSONObject> getinfo(@RequestParam(value="time1",required =false) String time1, @RequestParam(value="time2",required = false) String time2){

        log.println(time1);

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(time1,dateTimeFormatter);

        LocalDate date2=LocalDate.parse(time2,dateTimeFormatter);

        log.println(date1);
        int lenth;
        log.println(date2);
        // lenth=scglDCService.getDataIN(date.getDate1(),date.getDate2()).size();
        lenth=sgmwService.getActualDataIN(date1,date2).size();

        log.println(lenth);
        List<JSONObject> list=new ArrayList<>();
        list=sgmwList.getData(date1,date2,lenth);
        return list;

        /*log.println(date.getDate1());
        log.println(date.getDate2());
        log.println(scglXCService.getDataIN(date.getDate1(),date.getDate2()));
        return scglXCService.getDataIN(date.getDate1(),date.getDate2());

*/

    }
    @RequestMapping("/add")
    public String  add(@RequestBody JSONObject jsonObject){
        JSONObject jsonData=new JSONObject(new LinkedHashMap<>());
        jsonData=jsonObject.getJSONObject("data");
        JSONArray jsonArray=new JSONArray();
        jsonArray=jsonData.getJSONArray("message");
        //对ScglDC数据进行插入
        JSONObject objectAim=(JSONObject) JSONObject.toJSON(jsonArray.get(0));

        sgmwService.addIN(objectAim.getString("name"),objectAim.getInteger("safe"),objectAim.getInteger(
                "production"),objectAim.getInteger( "lzc"),objectAim.getFloat( "quality"),objectAim.getInteger(
                        "personnel"),objectAim.getFloat("energyConsumption"),objectAim.getFloat("equipment"));
        //对ScglDD数据进行插入
        JSONObject objectActual=(JSONObject) JSONObject.toJSON(jsonArray.get(1));
        sgmwService.addIN(objectActual.getString("name"),objectActual.getInteger("safe"),objectActual.getInteger(
                "production"),objectActual.getInteger( "lzc"),objectActual.getFloat( "quality"),
                objectActual.getInteger("personnel"),objectActual.getFloat("energyConsumption"),objectActual.getFloat(
                        "equipment"));
       return "success";

    }
    @RequestMapping("/change")
    public  String change(@RequestBody JSONObject jsonObject){
        JSONObject jsonData=new JSONObject(new LinkedHashMap<>());
        jsonData=jsonObject.getJSONObject("data");
        JSONArray jsonArray=new JSONArray();
        jsonArray=jsonData.getJSONArray("message");
        //对ScglDC数据进行修改
        JSONObject objectAim=(JSONObject) JSONObject.toJSON(jsonArray.get(0));
        Date dateDC=objectAim.getDate("date");

        return  "success";
    }


}
