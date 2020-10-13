package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.Quality2Service;
import com.hxzz.demo.service.ScglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.LinkedHashMap;

@Configuration
@Component
public class ScglPackage {
    @Autowired
    ScglService scglService;
    public JSONObject showPackage(){
        JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name","合计");
        jsonObject.put("targetCapacity",scglService.showSum().getTargetCapacity());
        jsonObject.put("actualCapacity",scglService.showSum().getActualCapacity());
        jsonObject.put("targetEfficiency",scglService.showSum().getTargetEfficiency());
        jsonObject.put("counts",scglService.showSum().getCounts());
        jsonObject.put("actualEfficiency",scglService.showSum().getActualEfficiency());
        jsonObject.put("workingHours",scglService.showSum().getWorkingHours());
        jsonObject.put("theoreticalCapacity",scglService.showSum().getTheoreticalCapacity());
        jsonObject.put("beat",scglService.showSum().getBeat());
        jsonObject.put("date",scglService.showSum().getDate());

        return  jsonObject;

    }


    public  JSONObject ClientPackage(LocalDate date1, LocalDate date2){
        JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name","合计");
        jsonObject.put("targetCapacity",scglService.infoSum(date1,date2).getTargetCapacity());
        jsonObject.put("actualCapacity",scglService.infoSum(date1,date2).getActualCapacity());
        jsonObject.put("targetEfficiency",scglService.infoSum(date1,date2).getTargetEfficiency());
        jsonObject.put("counts",scglService.infoSum(date1,date2).getCounts());
        jsonObject.put("actualEfficiency",scglService.infoSum(date1,date2).getActualEfficiency());
        jsonObject.put("workingHours",scglService.infoSum(date1,date2).getWorkingHours());
        jsonObject.put("theoreticalCapacity",scglService.infoSum(date1,date2).getTheoreticalCapacity());
        jsonObject.put("beat",scglService.infoSum(date1,date2).getBeat());
        jsonObject.put("date",scglService.infoSum(date1,date2).getDate());
        return jsonObject;
    }
}
