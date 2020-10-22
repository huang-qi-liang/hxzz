package com.hxzz.demo.result;

import com.hxzz.demo.service.EquipmentstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Component
public class EquipmentPackage {
    @Autowired
    EquipmentstatusService equipmentstatusService;

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
