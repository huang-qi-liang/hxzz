package com.hxzz.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.hxzz.demo.entity.Date;
import com.hxzz.demo.entity.ScglDC;
import com.hxzz.demo.entity.ScglXC;
import com.hxzz.demo.result.ScglList;
import com.hxzz.demo.result.ScglPackage;
import com.hxzz.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.hxzz.demo.result.Scgl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hql
 * @since 2020-09-14
 */
@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/scgl")
public class ScglController {
    @Autowired
    ScglPackage scglPackage;
    @Autowired
    ScglDCService scglDCService;
    @Autowired
    ScglDDService scglDDService;
    @Autowired
    ScglXCService scglXCService;
    @Autowired
    ScglXDService scglXDService;
    @Autowired
    Scgl scgl;
    @Autowired
    ScglList scglList;

    @Autowired
    WebSocket webSocket;
    @RequestMapping("/show")

    public JSONObject show(){
        JSONObject objectDC=new JSONObject(new LinkedHashMap<>());
        JSONObject objectDD=new JSONObject(new LinkedHashMap<>());
        JSONObject objectXC=new JSONObject(new LinkedHashMap<>());
        JSONObject objectXD=new JSONObject(new LinkedHashMap<>());
       objectDC=scglPackage.ScglDC();
       objectDD=scglPackage.ScglDD();
       objectXC=scglPackage.ScglXC();
       objectXD=scglPackage.ScglXD();

      /*  JSONObject objectDC=new JSONObject(new LinkedHashMap<>());
       JSONObject objecty=new JSONObject();

         JSONObject object1= (JSONObject) JSONObject.toJSON(scglDCService.showIN());

objecty.put("name","东C");
objectDC.putAll(objecty);
objectDC.putAll(object1);


        JSONObject objectDD=new JSONObject(new LinkedHashMap<>());
        JSONObject objecty2=new JSONObject();
        JSONObject object12= (JSONObject) JSONObject.toJSON(scglDDService.showIN());

        objecty2.put("name","东D");
        objectDD.putAll(objecty2);
        objectDD.putAll(object12);


        JSONObject objectXC=new JSONObject(new LinkedHashMap<>());
        JSONObject objecty3=new JSONObject();
        JSONObject object13= (JSONObject) JSONObject.toJSON(scglXCService.showIN());
        objecty3.put("name","西B");
        objectXC.putAll(objecty3);
        objectXC.putAll(object13);
        JSONObject objectXD=new JSONObject(new LinkedHashMap<>());
        JSONObject objecty4=new JSONObject();
        JSONObject object14= (JSONObject) JSONObject.toJSON(scglXDService.showIN());
        objecty4.put("name","西C");
        objectXD.putAll(objecty4);
        objectXD.putAll(object14);
log.println(objectXD);


       */
        //对合计部分进行封装
        JSONObject objectx=new JSONObject(new LinkedHashMap<>());
        objectx.put("name","合计");
objectx.put("targetCapacity",scgl.targetCapacitySum());
objectx.put("actualCapacity",scgl.actualCapacitySum());
objectx.put("targetEfficiency",scgl.targetEfficiencySum());
objectx.put("actualEfficiency",scgl.actualEfficiencySum());
objectx.put("workingHours",scgl.workingHoursSum());
objectx.put("theoreticalCapacity",scgl.theoreticalCapacitySum());
log.println(objectx);
JSONObject object5=new JSONObject();

object5.put("sum",objectx);




        JSONArray jsonArray=new JSONArray();
        jsonArray.add(0,objectDC);
        jsonArray.add(1,objectDD);
        jsonArray.add(2,objectXC);
        jsonArray.add(3,objectXD);
        jsonArray.add(4,objectx);
JSONObject result1=new JSONObject();
result1.put("total",4);
result1.put("message",jsonArray);
JSONObject result=new JSONObject();
result.put("data",result1);

log.println(jsonArray.size());
return  result;



    }
    @RequestMapping("/info")
    public List<JSONObject> getinfo(@RequestParam(value="time1",required =false) String time1,@RequestParam(value="time2",required = false) String time2){

       log.println(time1);

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
       LocalDate date1=LocalDate.parse(time1,dateTimeFormatter);

        LocalDate date2=LocalDate.parse(time2,dateTimeFormatter);

        log.println(date1);
        int lenth;
        log.println(date2);
       // lenth=scglDCService.getDataIN(date.getDate1(),date.getDate2()).size();
    lenth=scglDCService.getDataIN(date1,date2).size();

log.println(lenth);
       List<JSONObject> list=new ArrayList<>();
       list=scglList.getData(date1,date2,lenth);
       return list;

        /*log.println(date.getDate1());
        log.println(date.getDate2());
        log.println(scglXCService.getDataIN(date.getDate1(),date.getDate2()));
        return scglXCService.getDataIN(date.getDate1(),date.getDate2());

*/

    }
    @RequestMapping("/add")
    public String  add(@RequestBody JSONObject object){

        scglDCService.addIN(object.getInteger("targetCapacity"),object.getFloat("actualCapacity"),object.getFloat( "targetEfficiency"),object.getFloat( "workingHours"),object.getFloat( "theoreticalCapacity"));
        return "success";
    }
@RequestMapping("/delete")
    public String delete(@RequestBody ScglDC scglDC){
        scglDCService.delIN(scglDC.getDate());
    scglDDService.delIN(scglDC.getDate());
    scglXCService.delIN(scglDC.getDate());
    scglXDService.delIN(scglDC.getDate());

        return "success";
}
@RequestMapping("/change")
    public  String change(@RequestBody ScglDC scglDC){
        scglDCService.changeIN(scglDC.getTargetCapacity(),scglDC.getActualCapacity(),scglDC.getTargetEfficiency(),scglDC.getWorkingHours(),scglDC.getBeat(),scglDC.getDate());
        return  "success";
}
@RequestMapping("/test")
    public  void test(@RequestBody JSONObject json){
        log.println(json);

   JSONArray jsonArray=new JSONArray();
   jsonArray=json.getJSONArray("data");
JSONObject objectDC=(JSONObject) JSONObject.toJSON(jsonArray.get(0));
    log.println(objectDC);

}

}
