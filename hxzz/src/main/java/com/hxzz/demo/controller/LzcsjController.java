package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Lzcsj;
import com.hxzz.demo.result.LzcsjPackage;
import com.hxzz.demo.service.LzcsjService;
import net.sf.saxon.functions.AccessorFn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

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
    public Result show(){
        List list=new ArrayList();
        LocalDate date=LocalDate.now();
        if(lzcsjService.show(date)==null){
list.add(lzcsjPackage.LzcsjNull());
log.println(list);
        }
        else {
       list= lzcsjService.show(date);
       list.add(lzcsjPackage.LzcsjObject(LocalDate.now()));}

return Result.succ(list);
    }
    @RequestMapping("/showMan")
    public Result showMan(){
        List list=new ArrayList();
       list=lzcsjService.showMan();

        return Result.succ(list);
    }

    @RequestMapping("/info")
    public Result getData(@RequestParam(value="time1",required =false) String time1, @RequestParam(value="time2",
            required = false) String time2){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(time1,dateTimeFormatter);

        LocalDate date2=LocalDate.parse(time2,dateTimeFormatter);


        List list=new ArrayList<>();
        list=lzcsjPackage.LzcsjList(date1,date2);
        Collections.reverse(list);

        return Result.succ(list);

    }
    @RequestMapping("/infoMan")
    public Result getDataMan(@RequestParam(value="time1",required =false) String time1, @RequestParam(value="time2",
            required = false) String time2){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1=LocalDate.parse(time1,dateTimeFormatter);

        LocalDate date2=LocalDate.parse(time2,dateTimeFormatter);

        List list=new ArrayList();
        list=lzcsjService.getDataMan(date1,date2);
        Collections.reverse(list);
        return Result.succ(list);
    }
@RequestMapping("/add")
    public Result add(@RequestBody  Lzcsj lzcsj){
        lzcsjService.add(lzcsj.getName(),lzcsj.getWaitingToBeLoaded(),lzcsj.getLoopToCrossTheLine(),
                lzcsj.getBhCirculation(),lzcsj.getActualCirculation());
        /*
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

         */
    return Result.succ("success");

}
    @RequestMapping("/delete")
    public String del(@RequestParam(value="id",required =false)Integer id){
        lzcsjService.del(id);
        return "success";
    }
    @RequestMapping("change")
    public Result change(@RequestBody  Lzcsj lzcsj){

        lzcsjService.change(lzcsj.getId(),lzcsj.getName(),lzcsj.getWaitingToBeLoaded(),lzcsj.getLoopToCrossTheLine(),
                lzcsj.getBhCirculation(),lzcsj.getActualCirculation());
        /*
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
        return "success";/

         */
        return Result.succ("success");
    }


}
