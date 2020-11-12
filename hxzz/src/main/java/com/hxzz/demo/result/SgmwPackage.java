package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Configuration
@Component
public class SgmwPackage {
    @Autowired
    AimService aimService;
    @Autowired
    ScglService scglService;
    @Autowired
    QualityService qualityService;
    @Autowired
    PersonnelManagementService personnelManagementService;
    @Autowired
    EnergyPackage energyPackage;
    @Autowired
    SafeService safeService;
    @Autowired
    LzcsjService lzcsjService;
    @Autowired
    EquipmentstatusService equipmentstatusService;
    @Autowired
    MonthAimService monthAimService;
    @Autowired
    DateAimService dateAimService;

    public List showPackage() {
        List list = new ArrayList();
        JSONObject jsonObject1 = new JSONObject(new LinkedHashMap<>());
        jsonObject1.put("name", "目标");
        jsonObject1.put("safe", monthAimService.show().getSecurity());
        jsonObject1.put("production", scglService.showSum().getTargetCapacity());
        jsonObject1.put("lzc", dateAimService.show().getLzcsj());
        jsonObject1.put("quality", monthAimService.showClient().getQuality());
        jsonObject1.put("personnel", personnelManagementService.showSum().getShouldArrive());
        jsonObject1.put("energyConsumption", "green");
        jsonObject1.put("equipment", monthAimService.showClient().getEquipment());
        list.add(jsonObject1);
        JSONObject jsonObject2 = new JSONObject(new LinkedHashMap<>());
        jsonObject2.put("name", "实际");
        jsonObject2.put("safe", safeService.showSum().getRed());
        jsonObject2.put("production", scglService.showSum().getActualCapacity());
        jsonObject2.put("lzc", lzcsjService.showSum().getTotal());
        jsonObject2.put("quality", qualityService.showSum().getDR());
        jsonObject2.put("personnel", personnelManagementService.showSum().getActualArrive());
        jsonObject2.put("energyConsumption", energyPackage.showResult());
        jsonObject2.put("equipment", equipmentstatusService.showSum().getRate());
        list.add(jsonObject2);
        return list;
    }

    public List infoPackage(LocalDate date1, LocalDate date2) {

        List list = new ArrayList();


        JSONObject jsonObject1 = new JSONObject(new LinkedHashMap<>());
        jsonObject1.put("name", "目标");
        jsonObject1.put("safe", 0);
        jsonObject1.put("production", scglService.infoSum(date1, date2).getTargetCapacity());
        jsonObject1.put("lzc", dateAimService.infoClient(date1,date2).getLzcsj());
        jsonObject1.put("quality", monthAimService.aimInfo(date1, date2).getQuality());
        jsonObject1.put("personnel", personnelManagementService.infoSum(date1, date2).getShouldArrive());
        jsonObject1.put("energyConsumption", "green");
        jsonObject1.put("equipment", monthAimService.aimInfo(date1, date2).getEquipment());
        list.add(jsonObject1);
        JSONObject jsonObject2 = new JSONObject(new LinkedHashMap<>());
        jsonObject2.put("name", "实际");
        jsonObject2.put("safe", safeService.infoSum(date1, date2).getRed());
        jsonObject2.put("production", scglService.infoSum(date1, date2).getActualCapacity());
        jsonObject2.put("lzc", lzcsjService.infoSum(date1, date2).getTotal());
        jsonObject2.put("quality", qualityService.infoSum(date1, date2).getDR());
        jsonObject2.put("personnel", personnelManagementService.infoSum(date1, date2).getActualArrive());
        jsonObject2.put("energyConsumption", energyPackage.infoResult(date1, date2));
        jsonObject2.put("equipment", equipmentstatusService.infoSum(date1, date2).getRate());
        list.add(jsonObject2);
        return list;
    }

}
