package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.EquipmentstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Configuration
@Component
public class EquipmentPackage {
    @Autowired
    EquipmentstatusService equipmentstatusService;
    public JSONObject showPackage() {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name", "合计");
        jsonObject.put("failureTime ", equipmentstatusService.showSum().getFailureTime());
        jsonObject.put("officeTime", equipmentstatusService.showSum().getOfficeTime());
        jsonObject.put("rate", equipmentstatusService.showSum().getRate());
        jsonObject.put("date", equipmentstatusService.showSum().getDate());
        return jsonObject;

    }


    public JSONObject ClientPackage(LocalDate date1, LocalDate date2) {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name", "合计");
        jsonObject.put("failureTime ", equipmentstatusService.infoSum(date1, date2).getFailureTime());
        jsonObject.put("officeTime", equipmentstatusService.infoSum(date1, date2).getOfficeTime());
        jsonObject.put("rate", equipmentstatusService.infoSum(date1, date2).getRate());

        return jsonObject;
    }
    public List lineTotal(String date) {
        List list = new ArrayList();
        list.add(equipmentstatusService.totalYear(date));
        list.addAll(equipmentstatusService.total(date));
        return list;
    }

    public List line(String date, String name) {
        List list = new ArrayList();
        list.add(equipmentstatusService.eachYear(date, name));
        list.addAll(equipmentstatusService.each(date, name));
        return list;
    }

}
