package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.SgmwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Configuration
@Component

public class SgmwList {
    @Autowired
    SgmwService sgmwService;
    public List<JSONObject> getData(LocalDate date1, LocalDate date2, int n) {

        int i;
      /*  List<Object> listDC = new ArrayList<>(scglDCService.getDataIN(date1, date2));
        List<Object> listDD = new ArrayList<>(scglDDService.getDataIN(date1, date2));
        List<Object> listXC = new ArrayList<>(scglXCService.getDataIN(date1, date2));
        List<Object> listXD = new ArrayList<>(scglXDService.getDataIN(date1, date2));

       */
        List<JSONObject> objecty = new ArrayList<>();



        for (i = 0; i < n; i++) {

            JSONObject object1=new JSONObject(new LinkedHashMap<>());
            object1.put("name","目标");
            object1.put("safe",sgmwService.getAimDataIN(date1, date2).get(i).getSafe());
            object1.put("production",sgmwService.getAimDataIN(date1, date2).get(i).getProduction());
            object1.put("lzc",sgmwService.getAimDataIN(date1, date2).get(i).getLzc());
            object1.put("quality",sgmwService.getAimDataIN(date1, date2).get(i).getQuality());
            object1.put("personnel",sgmwService.getAimDataIN(date1, date2).get(i).getPersonnel());
            object1.put("energyConsumption",sgmwService.getAimDataIN(date1, date2).get(i).getEnergyConsumption());
            object1.put("equipment",sgmwService.getAimDataIN(date1, date2).get(i).getEquipment());

            // log.println(listDC.get(i));
            JSONObject objectAim=new JSONObject(new LinkedHashMap<>());

            objectAim.putAll(object1);
            objecty.add(objectAim);
            // objectDC.clear();
            JSONObject object2=new JSONObject(new LinkedHashMap<>());
            object2.put("name","实际");
            object2.put("safe",sgmwService.getActualDataIN(date1, date2).get(i).getSafe());
            object2.put("production",sgmwService.getActualDataIN(date1, date2).get(i).getProduction());
            object2.put("lzc",sgmwService.getActualDataIN(date1, date2).get(i).getLzc());
            object2.put("quality",sgmwService.getActualDataIN(date1, date2).get(i).getQuality());
            object2.put("personnel",sgmwService.getActualDataIN(date1, date2).get(i).getPersonnel());
            object2.put("energyConsumption",sgmwService.getActualDataIN(date1, date2).get(i).getEnergyConsumption());
            object2.put("equipment",sgmwService.getActualDataIN(date1, date2).get(i).getEquipment());

            // log.println(listDC.get(i));
            JSONObject objectActual=new JSONObject(new LinkedHashMap<>());

            objectActual.putAll(object1);
            objecty.add(objectActual);


        }

        return objecty;


    }
}

