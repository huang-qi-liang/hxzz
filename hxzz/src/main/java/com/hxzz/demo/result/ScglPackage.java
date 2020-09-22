package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.ScglDCService;
import com.hxzz.demo.service.ScglDDService;
import com.hxzz.demo.service.ScglXCService;
import com.hxzz.demo.service.ScglXDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Configuration
@Component
public class ScglPackage
{
    @Autowired
    ScglDCService scglDCService;
    @Autowired
    ScglDDService scglDDService;
    @Autowired
    ScglXCService scglXCService;
    @Autowired
    ScglXDService scglXDService;

    public JSONObject ScglDC(){
    JSONObject objectx=new JSONObject(new LinkedHashMap<>());
    objectx.put("id",scglDCService.showIN().getId());
    objectx.put("name","东C");
    objectx.put("targetCapacity",scglDCService.showIN().getTargetCapacity());
    objectx.put("actualCapacity",scglDCService.showIN().getActualCapacity());
    objectx.put("targetEfficiency",scglDCService.showIN().getTargetEfficiency());
    objectx.put("actualEfficiency",scglDCService.showIN().getActualEfficiency());
    objectx.put("workingHours",scglDCService.showIN().getWorkingHours());
    objectx.put("theoreticalCapacity",scglDCService.showIN().getTheoreticalCapacity());
    return  objectx;

    }
   public JSONObject ScglDD(){
        JSONObject objectx=new JSONObject(new LinkedHashMap<>());
        objectx.put("id",scglDDService.showIN().getId());
        objectx.put("name","东D");
        objectx.put("targetCapacity",scglDDService.showIN().getTargetCapacity());
        objectx.put("actualCapacity",scglDDService.showIN().getActualCapacity());
        objectx.put("targetEfficiency",scglDDService.showIN().getTargetEfficiency());
        objectx.put("actualEfficiency",scglDDService.showIN().getActualEfficiency());
        objectx.put("workingHours",scglDDService.showIN().getWorkingHours());
        objectx.put("theoreticalCapacity",scglDDService.showIN().getTheoreticalCapacity());
        return  objectx;

    }

    public JSONObject ScglXC(){
        JSONObject objectx=new JSONObject(new LinkedHashMap<>());
        objectx.put("id",scglXCService.showIN().getId());
        objectx.put("name","西B");
        objectx.put("targetCapacity",scglXCService.showIN().getTargetCapacity());
        objectx.put("actualCapacity",scglXCService.showIN().getActualCapacity());
        objectx.put("targetEfficiency",scglXCService.showIN().getTargetEfficiency());
        objectx.put("actualEfficiency",scglXCService.showIN().getActualEfficiency());
        objectx.put("workingHours",scglXCService.showIN().getWorkingHours());
        objectx.put("theoreticalCapacity",scglXCService.showIN().getTheoreticalCapacity());
        return  objectx;

    }
    public JSONObject ScglXD(){
        JSONObject objectx=new JSONObject(new LinkedHashMap<>());
        objectx.put("id",scglXDService.showIN().getId());
        objectx.put("name","西C");
        objectx.put("targetCapacity",scglXDService.showIN().getTargetCapacity());
        objectx.put("actualCapacity",scglXDService.showIN().getActualCapacity());
        objectx.put("targetEfficiency",scglXDService.showIN().getTargetEfficiency());
        objectx.put("actualEfficiency",scglXDService.showIN().getActualEfficiency());
        objectx.put("workingHours",scglXDService.showIN().getWorkingHours());
        objectx.put("theoreticalCapacity",scglXDService.showIN().getTheoreticalCapacity());
        return  objectx;

    }
}
