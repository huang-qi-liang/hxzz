package com.hxzz.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Date;
import com.hxzz.demo.bean.Id;
import com.hxzz.demo.bean.Info;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Energy;
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

import static java.lang.Integer.parseInt;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * <p>
 * 前端控制器
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
@RequestMapping("/Energy")
public class EnergyController {
    @Autowired
    EnergyService energyService;
    @Autowired
    EnergyPackage energyPackage;

    @RequestMapping("/show")
    public Result show() {
        List list = new ArrayList<>();
        list = energyService.show();
        return Result.succ(list);
    }

    @RequestMapping("/showClient")
    public Result showClient() {
        List list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());

        jsonObject = energyPackage.EnergyPackage();
        return Result.succ(jsonObject);
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Info info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<Energy> pageInfo = energyService.findAll(info.getPageNum(), info.getPageSize(), date1, date2);

        return Result.succ(pageInfo);

    }

    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(date.getTime2(), dateTimeFormatter);
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());

        jsonObject = energyPackage.infoPackage(date1, date2);


        return Result.succ(jsonObject);

    }

    @RequestMapping("/add")
    public Result add(@RequestBody Energy energy) {
        energyService.add(energy.getName(), energy.getStandardsWater(), energy.getWater(),
                energy.getStandardsElectricity(), energy.getElectricity(), energy.getStandardsGas(), energy.getGas(),
                energy.getDate());
        /*
        JSONObject jsondata=new JSONObject(new LinkedHashMap<>());
        jsondata=jsonObject.getJSONObject("data");
        JSONArray jsonArray=new JSONArray();
        jsonArray=jsondata.getJSONArray("message");
        JSONObject jsonObjectEnergy=(JSONObject) JSONObject.toJSON(jsonArray.get(0));
        energyService.add(jsonObjectEnergy.getString("name"),jsonObjectEnergy.getFloat("standardsWater"),
                jsonObjectEnergy.getFloat("water"),jsonObjectEnergy.getFloat("standardsElectricity"),
                jsonObjectEnergy.getFloat("electricity"),jsonObjectEnergy.getFloat("standardsGas"),
                jsonObjectEnergy.getFloat("gas"));

         */
        return Result.succ("success");

    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody List<JSONObject> list) {

        int size = list.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            String Id = jsonObject.getString("id");
            Integer id = parseInt(Id, 10);
            energyService.del(id);
        }
        return Result.succ("success");
    }

    @RequestMapping("/change")
    public Result change(@RequestBody Energy energy) {
        /*
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

         */
        energyService.change(energy.getId(), energy.getName(), energy.getStandardsWater(), energy.getWater(),
                energy.getStandardsElectricity(), energy.getElectricity(), energy.getStandardsGas(), energy.getGas(),
                energy.getDate());
        return Result.succ("success");

    }

    @RequestMapping("/save")
    public Result save(@RequestBody Energy energy) {
        log.println(energy);
        if (energy.getId() == null) {
            energyService.add(energy.getName(), energy.getStandardsWater(), energy.getWater(),
                    energy.getStandardsElectricity(), energy.getElectricity(), energy.getStandardsGas(), energy.getGas()
                    , energy.getDate());

        } else {
            energyService.change(energy.getId(), energy.getName(), energy.getStandardsWater(), energy.getWater(),
                    energy.getStandardsElectricity(), energy.getElectricity(), energy.getStandardsGas(), energy.getGas()
                    , energy.getDate());
            return Result.succ("success");
        }
        return Result.succ("success");

    }

}
