package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.LinkedHashMap;

@Configuration
@Component
public class EnergyPackage {
    @Autowired
    EnergyService energyService;
    public JSONObject EnergyPackage(){
        int water,electricity,gas;
        JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
        if(energyService.showClient().getWater()>energyService.showClient().getStandardsWater()){

            water=0;
        }
        else
            water=1;
        if(energyService.showClient().getElectricity()>energyService.showClient().getStandardsElectricity()){
            electricity=0;
        }
        else
            electricity=1;
        if(energyService.showClient().getGas()>energyService.showClient().getStandardsGas()){
           gas=0;
        }
        else
            gas=1;

        jsonObject.put("water",water);
        jsonObject.put("eletricity",electricity);
        jsonObject.put("gas",gas);
        jsonObject.put("date",energyService.showClient().getDate());
        return jsonObject;
    }
    public JSONObject infoPackage(LocalDate date1,LocalDate date2){
        int water,electricity,gas;
        JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
        if(energyService.infoClient(date1,date2).getWater()>energyService.infoClient(date1,date2).getStandardsWater()){

            water=0;
        }
        else
            water=1;
        if(energyService.infoClient(date1,date2).getElectricity()>energyService.infoClient(date1,date2).getStandardsElectricity()){
            electricity=0;
        }
        else
            electricity=1;
        if(energyService.infoClient(date1,date2).getGas()>energyService.infoClient(date1,date2).getStandardsGas()){
            gas=0;
        }
        else
            gas=1;

        jsonObject.put("water",water);
        jsonObject.put("eletricity",electricity);
        jsonObject.put("gas",gas);
        jsonObject.put("date",energyService.infoClient(date1,date2).getDate());
        return jsonObject;
    }
}
