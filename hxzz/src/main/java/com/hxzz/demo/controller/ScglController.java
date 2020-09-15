package com.hxzz.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.entity.Date;
import com.hxzz.demo.entity.ScglDC;
import com.hxzz.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.hxzz.demo.result.Scgl;

import java.util.LinkedHashMap;
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
    WebSocket webSocket;
    @RequestMapping("/show")

    public JSONObject show(){

        JSONObject objectx=new JSONObject(new LinkedHashMap<>());
objectx.put("targetCapacity",scgl.targetCapacitySum());
objectx.put("actualCapacity",scgl.actualCapacitySum());
objectx.put("targetEfficiency",scgl.targetEfficiencySum());
objectx.put("actualEfficiency",scgl.actualEfficiencySum());
objectx.put("workingHours",scgl.workingHoursSum());
objectx.put("theoreticalCapacity",scgl.theoreticalCapacitySum());
JSONObject object5=new JSONObject();
object5.put("sum",objectx);




        JSONArray jsonArray=new JSONArray();
        jsonArray.add(0,scglDCService.showIN());
        jsonArray.add(1,scglDDService.showIN());
        jsonArray.add(2,scglXCService.showIN());
        jsonArray.add(3,scglXDService.showIN());
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
    public List<ScglDC> getinfo(@RequestBody Date date){
        List<ScglDC> list1;
        list1= scglDCService.getDataIN(date.getDate1(),date.getDate2());
        return list1;


    }
    @RequestMapping("/add")
    public String  add(@RequestBody ScglDC scglDC){

        scglDCService.addIN(scglDC.getTargetCapacity(),scglDC.getActualCapacity(),scglDC.getTargetEfficiency(),scglDC.getWorkingHours(),scglDC.getBeat());
        return "success";
    }
@RequestMapping("/delete")
    public String delete(@RequestBody ScglDC scglDC){
        scglDCService.delIN(scglDC.getDate());
        return "success";
}
@RequestMapping("/change")
    public  String change(@RequestBody ScglDC scglDC){
        scglDCService.changeIN(scglDC.getTargetCapacity(),scglDC.getActualCapacity(),scglDC.getTargetEfficiency(),scglDC.getWorkingHours(),scglDC.getBeat(),scglDC.getDate());
        return  "success";
}
@RequestMapping("/test")
    public  JSONObject test(){
        JSONObject jsonObject=new JSONObject();

       log.println(scgl.targetCapacitySum());
        jsonObject.put("ScglDC",scgl.targetCapacitySum());
        return  jsonObject;
}

}
