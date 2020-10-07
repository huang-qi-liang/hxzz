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

    public List LzcsjList(LocalDate date1, LocalDate date2) {
        long i;
        LocalDate localDate;
        localDate=date1;

        List list = new ArrayList<>();
        for (i=0; i<= ChronoUnit.DAYS.between(date1,date2); i++) {

            if (lzcsjService.show(localDate).isEmpty()) {
                localDate = localDate.plusDays(1);

            }
            else
                {

                list.addAll(lzcsjService.show(localDate));

             JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
                jsonObject=lzcsjPackage.LzcsjObject(localDate);
                List list1=new ArrayList();
                list1.add(jsonObject);
                list.addAll(list1);



                localDate =localDate.plusDays(1);
            }
            /*
            jsonObject.put("name", "合计");
            jsonObject.put("waitingToBeLoaded", lzcsjService.SumData(date1, date2).get(i).getWaitingToBeLoaded());
            jsonObject.put("loopToCrossTheLine", lzcsjService.SumData(date1, date2).get(i).getLoopToCrossTheLine());
            jsonObject.put("bhCirculation", lzcsjService.SumData(date1, date2).get(i).getBhCirculation());
            jsonObject.put("actualCirculation", lzcsjService.SumData(date1, date2).get(i).getActualCirculation());
            jsonObject.put("total", lzcsjService.SumData(date1, date2).get(i).getTotal());
            jsonObject.put("date", lzcsjService.SumData(date1, date2).get(i).getDate());

             */


        }
        return list;
    }
    public JSONObject LzcsjObject(LocalDate date){
        if(lzcsjService.Sum(date)!=null){

        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name", "合计");
      jsonObject.put("waitingToBeLoaded", lzcsjService.Sum(date).getWaitingToBeLoaded());
     jsonObject.put("loopToCrossTheLine", lzcsjService.Sum(date).getLoopToCrossTheLine());
        jsonObject.put("bhCirculation", lzcsjService.Sum(date).getBhCirculation());
        jsonObject.put("actualCirculation", lzcsjService.Sum(date).getActualCirculation());
        jsonObject.put("total",lzcsjService.Sum(date).getTotal());
        jsonObject.put("date",date);
            return jsonObject;}
        else
        { JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject.put("name", "待加入");
            jsonObject.put("waitingToBeLoaded","待加入");
            jsonObject.put("loopToCrossTheLine", "待加入");
            jsonObject.put("bhCirculation","待加入");
            jsonObject.put("actualCirculation", "待加入");
            jsonObject.put("total","待加入");
            jsonObject.put("date",date);
            return jsonObject;}




    }
    public JSONObject LzcsjNull(){
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("name", "待加入");
        jsonObject.put("waitingToBeLoaded","待加入");
        jsonObject.put("loopToCrossTheLine", "待加入");
        jsonObject.put("bhCirculation","待加入");
        jsonObject.put("actualCirculation", "待加入");
        jsonObject.put("total","待加入");
        jsonObject.put("date",LocalDate.now());
        return  jsonObject;
    }
}