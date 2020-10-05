package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.entity.Lzcsj;
import com.hxzz.demo.result.LzcsjPackage;
import com.hxzz.demo.service.LzcsjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/lzcsj")
public class LzcsjController {
    @Autowired
    LzcsjService lzcsjService;
    @Autowired
    LzcsjPackage lzcsjPackage;
    @RequestMapping("/show")
    public ArrayList<JSONObject> show(){
        LocalDate date=LocalDate.now();
        int size=lzcsjService.show(date).size();
       return lzcsjPackage.LzcsjPackage(date,size);

    }
    @RequestMapping("/info")
    public ArrayList<JSONObject> getData(@RequestParam(value="time1",required =false) String time1, @RequestParam(value="time2",
            required = false) String time2){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(time1,dateTimeFormatter);

        LocalDate date2=LocalDate.parse(time2,dateTimeFormatter);
        int size=lzcsjService.getData(date1,date2).size();
        ArrayList<JSONObject> arrayList=new ArrayList<>();
        arrayList=lzcsjPackage.LzcsjList(date1,date2,size);
        return arrayList;

    }
@RequestMapping("/add")
    public String add(@RequestBody JSONObject jsonObject){
    JSONObject jsondata=new JSONObject(new LinkedHashMap<>());
    jsondata=jsonObject.getJSONObject("data");
    JSONArray jsonArray=new JSONArray();
    jsonArray=jsondata.getJSONArray("message");
    int size=jsonArray.size();
    int i;
    ArrayList<JSONObject> arrayList=new ArrayList<>();
  for(i=0;i<size;i++){
      arrayList.add((JSONObject) JSONObject.toJSON(jsonArray.get(i)));
      lzcsjService.add(arrayList.get(i).getString("name"),arrayList.get(i).getInteger("waitingToBeLoaded"),
              arrayList.get(i).getInteger("loopToCrossTheLine"),arrayList.get(i).getInteger("bhCirculation"),
              arrayList.get(i).getInteger("actualCirculation"));
  }
  return "success";
}
    @RequestMapping("/delete")
    public String del(@RequestParam(value="id",required =false)Integer id){
        lzcsjService.del(id);
        return "success";
    }
    @RequestMapping("change")
    public String change(@RequestBody JSONObject jsonObject){
        JSONObject jsondata=new JSONObject(new LinkedHashMap<>());
        jsondata=jsonObject.getJSONObject("data");
        JSONArray jsonArray=new JSONArray();
        jsonArray=jsondata.getJSONArray("message");
        int size=jsonArray.size();
        int i;
        ArrayList<JSONObject> arrayList=new ArrayList<>();
        for(i=0;i<size;i++){
            arrayList.add((JSONObject) JSONObject.toJSON(jsonArray.get(i)));
            lzcsjService.change(arrayList.get(i).getInteger("id"),arrayList.get(i).getString("name"),
                    arrayList.get(i).getInteger(
                    "waitingToBeLoaded"),
                    arrayList.get(i).getInteger("loopToCrossTheLine"),arrayList.get(i).getInteger("bhCirculation"),
                    arrayList.get(i).getInteger("actualCirculation"));
        }
        return "success";
    }

}
