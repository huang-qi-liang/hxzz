package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Configuration
@Component
public class EnergyPackage {
    @Autowired
    EnergyService energyService;
    public JSONObject EnergyPackage(){
        int water,electricity,gas;
        JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
        if(energyService.show().getWater()>energyService.show().getStandardsWater()){

            water=0;
        }
        else
            water=1;
        if(energyService.show().getElectricity()>energyService.show().getStandardsElectricity()){
            electricity=0;
        }
        else
            electricity=1;
        if(energyService.show().getGas()>energyService.show().getStandardsGas()){
           gas=0;
        }
        else
            gas=1;
        jsonObject.put("id",energyService.show().getId());
        jsonObject.put("water",water);
        jsonObject.put("eletricity",electricity);
        jsonObject.put("gas",gas);
        jsonObject.put("date",energyService.show().getDate());
        return jsonObject;
    }
}
