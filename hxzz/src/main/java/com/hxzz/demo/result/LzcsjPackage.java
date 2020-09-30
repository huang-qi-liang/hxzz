package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.mapper.LzcsjMapper;
import com.hxzz.demo.service.LzcsjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Configuration
@Component
public class LzcsjPackage {
    @Autowired
    LzcsjService lzcsjService;

    public ArrayList LzcsjPackage(LocalDate date, int size) {
        int i;
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        for (i = 0; i < size; i++) {
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject.put("name", lzcsjService.show(date).get(i).getName());
            jsonObject.put("waitingToBeLoaded", lzcsjService.show(date).get(i).getWaitingToBeLoaded());
            jsonObject.put("loopToCrossTheLine", lzcsjService.show(date).get(i).getLoopToCrossTheLine());
            jsonObject.put("bhCirculation", lzcsjService.show(date).get(i).getBhCirculation());
            jsonObject.put("actualCirculation", lzcsjService.show(date).get(i).getActualCirculation());
            jsonObject.put("total", lzcsjService.show(date).get(i).getTotal());
            jsonObject.put("date", lzcsjService.show(date).get(i).getDate());
            arrayList.add(jsonObject);
        }
        return arrayList;
    }

    public ArrayList LzcsjList(LocalDate date1, LocalDate date2, int size) {
        int i;
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        for (i = 0; i < size; i++) {
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject.put("name", lzcsjService.getData(date1, date2).get(i).getName());
            jsonObject.put("waitingToBeLoaded", lzcsjService.getData(date1, date2).get(i).getWaitingToBeLoaded());
            jsonObject.put("loopToCrossTheLine", lzcsjService.getData(date1, date2).get(i).getLoopToCrossTheLine());
            jsonObject.put("bhCirculation", lzcsjService.getData(date1, date2).get(i).getBhCirculation());
            jsonObject.put("actualCirculation", lzcsjService.getData(date1, date2).get(i).getActualCirculation());
            jsonObject.put("total", lzcsjService.getData(date1, date2).get(i).getTotal());
            jsonObject.put("date", lzcsjService.getData(date1, date2).get(i).getDate());
            arrayList.add(jsonObject);
        }
        return arrayList;
    }
}