package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Configuration
@Component
public class EnergyList {
    @Autowired
    EnergyService energyService;
    public List<JSONObject> EnergyList(LocalDate date1,LocalDate date2,int size){
       int i,water,electricity,gas;
        List<JSONObject> arrayList = new ArrayList<>();
        for(i=0;i<size;i++){
            JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
            if(energyService.getData(date1,date2).get(i).getWater()>energyService.getData(date1,date2).get(i).getStandardsWater()){

                water=0;
            }
            else
                water=1;
            if(energyService.getData(date1,date2).get(i).getElectricity()>energyService.getData(date1,date2).get(i).getStandardsElectricity()){
                electricity=0;
            }
            else
                electricity=1;
            if(energyService.getData(date1,date2).get(i).getGas()>energyService.getData(date1,date2).get(i).getStandardsGas()){
                gas=0;
            }
            else
                gas=1;
            jsonObject.put("water",water);
            jsonObject.put("eletricity",electricity);
            jsonObject.put("gas",gas);
            jsonObject.put("date",energyService.getData(date1,date2).get(i).getDate());
            arrayList.add(jsonObject);

        }
        return arrayList;
    }
}
