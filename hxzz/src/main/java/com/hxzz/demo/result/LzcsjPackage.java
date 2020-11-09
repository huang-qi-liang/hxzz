package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.bean.LzcsjShow;
import com.hxzz.demo.bean.LzcsjSum;
import com.hxzz.demo.mapper.LzcsjMapper;
import com.hxzz.demo.service.LzcsjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Configuration
@Component
public class LzcsjPackage {
    @Autowired
    LzcsjService lzcsjService;
    @Autowired
    LzcsjPackage lzcsjPackage;

    public JSONObject showPackage() {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name", "合计");
        jsonObject.put("waitingToBeLoaded ", lzcsjService.showSum().getWaitingToBeLoaded());
        jsonObject.put("loopToCrossTheLine", lzcsjService.showSum().getLoopToCrossTheLine());
        jsonObject.put("bhCirculation", lzcsjService.showSum().getBhCirculation());
        jsonObject.put("actualCirculation", lzcsjService.showSum().getActualCirculation());
        jsonObject.put("total", lzcsjService.showSum().getTotal());
        jsonObject.put("date", lzcsjService.showSum().getDate());

        return jsonObject;

    }


    public JSONObject ClientPackage(LocalDate date1, LocalDate date2) {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name", "合计");
        jsonObject.put("waitingToBeLoaded", lzcsjService.infoSum(date1, date2).getWaitingToBeLoaded());
        jsonObject.put("loopToCrossTheLine", lzcsjService.infoSum(date1, date2).getLoopToCrossTheLine());
        jsonObject.put("bhCirculation", lzcsjService.infoSum(date1, date2).getBhCirculation());
        jsonObject.put("actualCirculation", lzcsjService.infoSum(date1, date2).getActualCirculation());

        jsonObject.put("total", lzcsjService.infoSum(date1, date2).getTotal());
        jsonObject.put("date", lzcsjService.infoSum(date1, date2).getDate());
        return jsonObject;
    }
    public List Total(String date) {
        List list = new ArrayList();

        String string=date.substring(0,4);

        Integer date2=Integer.valueOf(string);

        //list.add(lzcsjService.totalYear(date2));
        list.addAll(lzcsjService.total(date2));
        return list;
    }

}