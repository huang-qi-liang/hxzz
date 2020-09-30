package com.hxzz.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.hxzz.demo.result.EnergyList;
import com.hxzz.demo.result.EnergyPackage;
import com.hxzz.demo.service.EnergyService;
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
@RequestMapping("/energy")
public class EnergyController {
    @Autowired
    EnergyService energyService;
    @Autowired
    EnergyPackage energyPackage;
    @Autowired
    EnergyList energyList;
    @RequestMapping("/show")
    public JSONObject show(){

      JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
      jsonObject=energyPackage.EnergyPackage();
return jsonObject;
    }

    @RequestMapping("/info")
    public List<JSONObject> info(@RequestParam(value="time1",required =false) String time1, @RequestParam(value="time2",
            required = false) String time2){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(time1,dateTimeFormatter);

        LocalDate date2=LocalDate.parse(time2,dateTimeFormatter);
        int size=energyService.getData(date1,date2).size();
        List<JSONObject> list=new ArrayList<>();
        list=energyList.EnergyList(date1,date2,size);
          return list;
    }
    @RequestMapping("/add")
    public String add(@RequestBody JSONObject jsonObject){
        JSONObject jsondata=new JSONObject(new LinkedHashMap<>());
        jsondata=jsonObject.getJSONObject("data");
        JSONArray jsonArray=new JSONArray();
        jsonArray=jsondata.getJSONArray("message");
        JSONObject jsonObjectEnergy=(JSONObject) JSONObject.toJSON(jsonArray.get(0));
        energyService.add(jsonObjectEnergy.getString("name"),jsonObjectEnergy.getFloat("standardsWater"),
                jsonObjectEnergy.getFloat("water"),jsonObjectEnergy.getFloat("standardsElectricity"),
                jsonObjectEnergy.getFloat("electricity"),jsonObjectEnergy.getFloat("standardsGas"),
                jsonObjectEnergy.getFloat("gas"));
        return "success";

    }
   @RequestMapping("/delete")
    public String del(@RequestParam(value="id",required =false)Integer id){
        energyService.del(id);
        return "success";
   }
   @RequestMapping("/change")
    public String change(@RequestBody JSONObject jsonObject){
       JSONObject jsondata=new JSONObject(new LinkedHashMap<>());
       jsondata=jsonObject.getJSONObject("data");
       JSONArray jsonArray=new JSONArray();
       jsonArray=jsondata.getJSONArray("message");
       JSONObject jsonObjectEnergy=(JSONObject) JSONObject.toJSON(jsonArray.get(0));
        energyService.change(jsonObjectEnergy.getInteger("id"),jsonObjectEnergy.getString("name"),jsonObjectEnergy.getFloat("standardsWater"),
                jsonObjectEnergy.getFloat("water"),jsonObjectEnergy.getFloat("standardsElectricity"),
                jsonObjectEnergy.getFloat("electricity"),jsonObjectEnergy.getFloat("standardsGas"),
                jsonObjectEnergy.getFloat("gas"));
        return "success";
   }



}
