package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.Quality2Service;
import com.hxzz.demo.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Configuration
@Component
public class QualityPackage {
    @Autowired
    QualityService qualityService;

    public JSONObject showPackage() {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name", "合计");
        jsonObject.put("offLine", qualityService.showSum().getOffLine());
        jsonObject.put("dLine", qualityService.showSum().getDLine());
        jsonObject.put("lingYu", qualityService.showSum().getLingYu());
        jsonObject.put("careLine", qualityService.showSum().getCareLine());
        jsonObject.put("roadTest", qualityService.showSum().getRoadTest());
        jsonObject.put("DR", qualityService.showSum().getDR());
        jsonObject.put("date", qualityService.showSum().getDate());

        return jsonObject;

    }


    public JSONObject ClientPackage(LocalDate date1, LocalDate date2) {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name", "合计");
        jsonObject.put("offLine", qualityService.infoSum(date1, date2).getOffLine());
        jsonObject.put("dLine", qualityService.infoSum(date1, date2).getDLine());
        jsonObject.put("lingYu", qualityService.infoSum(date1, date2).getLingYu());
        jsonObject.put("careLine", qualityService.infoSum(date1, date2).getCareLine());
        jsonObject.put("roadTest", qualityService.infoSum(date1, date2).getRoadTest());
        jsonObject.put("DR", qualityService.infoSum(date1, date2).getDR());
        jsonObject.put("date", qualityService.infoSum(date1, date2).getDate());
        return jsonObject;
    }
    public List lineTotal(String date) {
        List list = new ArrayList();

        String string=date.substring(0,4);
        log.println(string);

        Integer date2=Integer.valueOf(string);
        log.println(date2);
        list.add(qualityService.totalYear(date2));
        list.addAll(qualityService.total(date2));
        return list;
    }
}
