package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.SgmwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Configuration
@Component
public class SgmwPackage {
    @Autowired
    SgmwService sgmwService;
    public JSONObject aimwjson(){
        JSONObject objectx=new JSONObject(new LinkedHashMap<>());
        objectx.put("name","目标");
        objectx.put("safe",sgmwService.showaimIN().getSafe());
        objectx.put("production",sgmwService.showaimIN().getProduction());
        objectx.put("lzc",sgmwService.showaimIN().getLzc());
        objectx.put("quality",sgmwService.showaimIN().getQuality());
        objectx.put("personnel",sgmwService.showaimIN().getPersonnel());
        objectx.put("energyConsumption",sgmwService.showaimIN().getEnergyConsumption());
        objectx.put("equipment",sgmwService.showaimIN().getEquipment());
        return objectx;

    }
    public JSONObject actualjson(){
        JSONObject objecty=new JSONObject(new LinkedHashMap<>());
        objecty.put("name","实际");
        objecty.put("safe",sgmwService.showactualIN().getSafe());
        objecty.put("production",sgmwService.showactualIN().getProduction());
        objecty.put("lzc",sgmwService.showactualIN().getLzc());
        objecty.put("quality",sgmwService.showactualIN().getQuality());
        objecty.put("personnel",sgmwService.showactualIN().getPersonnel());
        objecty.put("energyConsumption",sgmwService.showactualIN().getEnergyConsumption());
        objecty.put("equipment",sgmwService.showactualIN().getEquipment());
        return objecty;

    }


}
