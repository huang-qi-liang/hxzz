package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.bean.ScglShow;
import com.hxzz.demo.service.Quality2Service;
import com.hxzz.demo.service.ScglService;
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
public class ScglPackage {
    @Autowired
    ScglService scglService;

    public JSONObject showPackage() {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name", "合计");
        jsonObject.put("targetCapacity", scglService.showSum().getTargetCapacity());
        jsonObject.put("actualCapacity", scglService.showSum().getActualCapacity());
        jsonObject.put("targetEfficiency", scglService.showSum().getTargetEfficiency());

        jsonObject.put("actualEfficiency", scglService.showSum().getActualEfficiency());
        jsonObject.put("workingHours", scglService.showSum().getWorkingHours());
        jsonObject.put("theoreticalCapacity", scglService.showSum().getTheoreticalCapacity());
        jsonObject.put("beat", scglService.showSum().getBeat());
        jsonObject.put("date", scglService.showSum().getDate());

        return jsonObject;

    }


    public JSONObject ClientPackage(LocalDate date1, LocalDate date2) {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name", "合计");
        jsonObject.put("targetCapacity", scglService.infoSum(date1, date2).getTargetCapacity());
        jsonObject.put("actualCapacity", scglService.infoSum(date1, date2).getActualCapacity());
        jsonObject.put("targetEfficiency", scglService.infoSum(date1, date2).getTargetEfficiency());

        jsonObject.put("actualEfficiency", scglService.infoSum(date1, date2).getActualEfficiency());
        jsonObject.put("workingHours", scglService.infoSum(date1, date2).getWorkingHours());
        jsonObject.put("theoreticalCapacity", scglService.infoSum(date1, date2).getTheoreticalCapacity());
        jsonObject.put("beat", scglService.infoSum(date1, date2).getBeat());
        jsonObject.put("date", scglService.infoSum(date1, date2).getDate());
        return jsonObject;
    }

    public List showAllPackage() {
        List list = new ArrayList();
        List<ScglShow> list1 = new ArrayList();

        list1 = scglService.showClient();

        int size = list1.size();
        int i;
        JSONObject jsonObject1 = new JSONObject(new LinkedHashMap<>());
        jsonObject1.put("name", "目标台量");
        for (i = 0; i < size; i++) {
            jsonObject1.put(list1.get(i).getName(), list1.get(i).getTargetCapacity());

        }
        jsonObject1.put("合计", scglService.showSum().getTargetCapacity());
        list.add(jsonObject1);
        JSONObject jsonObject2 = new JSONObject(new LinkedHashMap<>());
        jsonObject2.put("name", "实际台量");
        for (i = 0; i < size; i++) {
            jsonObject2.put(list1.get(i).getName(), list1.get(i).getActualCapacity());

        }
        jsonObject2.put("合计", scglService.showSum().getActualCapacity());
        list.add(jsonObject2);
        JSONObject jsonObject3 = new JSONObject(new LinkedHashMap<>());
        jsonObject3.put("name", "实际效率");
        for (i = 0; i < size; i++) {
            jsonObject3.put(list1.get(i).getName(), list1.get(i).getActualEfficiency());

        }
        jsonObject3.put("合计", scglService.showSum().getActualEfficiency());
        list.add(jsonObject3);

        return list;
    }


    public List infoAllPackage(LocalDate date1, LocalDate date2) {
        List list = new ArrayList();
        List<ScglShow> list1 = new ArrayList();

        list1 = scglService.infoClient(date1, date2);

        int size = list1.size();
        int i;
        JSONObject jsonObject1 = new JSONObject(new LinkedHashMap<>());
        jsonObject1.put("name", "目标台量");
        for (i = 0; i < size; i++) {
            jsonObject1.put(list1.get(i).getName(), list1.get(i).getTargetCapacity());

        }
        jsonObject1.put("合计", scglService.infoSum(date1, date2).getTargetCapacity());
        list.add(jsonObject1);
        JSONObject jsonObject2 = new JSONObject(new LinkedHashMap<>());
        jsonObject2.put("name", "实际台量");
        for (i = 0; i < size; i++) {
            jsonObject2.put(list1.get(i).getName(), list1.get(i).getActualCapacity());

        }
        jsonObject2.put("合计", scglService.infoSum(date1, date2).getActualCapacity());
        list.add(jsonObject2);
        JSONObject jsonObject3 = new JSONObject(new LinkedHashMap<>());
        jsonObject3.put("name", "实际效率");
        for (i = 0; i < size; i++) {
            jsonObject3.put(list1.get(i).getName(), list1.get(i).getActualEfficiency());

        }
        jsonObject3.put("合计", scglService.infoSum(date1, date2).getActualEfficiency());
        list.add(jsonObject3);

        return list;
    }
    public List lineTotal(String date) {
        List list = new ArrayList();

        String string=date.substring(0,4);
        log.println(string);

        Integer date2=Integer.valueOf(string);
        log.println(date2);

        list.addAll(scglService.total(date2));
        return list;
    }

    public List line(String date, String name) {

        List list = new ArrayList();
        String string=date.substring(0,4);
        log.println(string);

        Integer date2=Integer.valueOf(string);
        log.println(date2);

        list.addAll(scglService.each(date2, name));
        return list;
    }
}
