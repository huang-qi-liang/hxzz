package com.hxzz.demo.result;
import com.hxzz.demo.result.Scgl;
import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.ScglDCService;
import com.hxzz.demo.service.ScglDDService;
import com.hxzz.demo.service.ScglXCService;
import com.hxzz.demo.service.ScglXDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Configuration
@Component
public class ScglList {
    @Autowired
    Scgl scgl;
    @Autowired
    ScglDCService scglDCService;
    @Autowired
    ScglDDService scglDDService;
    @Autowired
    ScglXCService scglXCService;
    @Autowired
    ScglXDService scglXDService;

    public List<JSONObject> getData(LocalDate date1, LocalDate date2, int n) {

        int i;
        List<Object> listDC = new ArrayList<>(scglDCService.getDataIN(date1, date2));
        List<Object> listDD = new ArrayList<>(scglDDService.getDataIN(date1, date2));
        List<Object> listXC = new ArrayList<>(scglXCService.getDataIN(date1, date2));
        List<Object> listXD = new ArrayList<>(scglXDService.getDataIN(date1, date2));
        List<JSONObject> objecty = new ArrayList<>();
        JSONObject jsonObjectDC=new JSONObject();
        jsonObjectDC.put("name","东C");
        JSONObject jsonObjectDD=new JSONObject();
        jsonObjectDD.put("name","东D");
        JSONObject jsonObjectXC=new JSONObject();
        jsonObjectXC.put("name","西B");
        JSONObject jsonObjectXD=new JSONObject();
        jsonObjectXD.put("name","西C");
        for (i = 0; i < n; i++) {


            JSONObject object1 = (JSONObject) JSONObject.toJSON(listDC.get(i));
            Map map=new HashMap<>();
            log.println(listDC.get(i));
            JSONObject objectDC=new JSONObject(new LinkedHashMap<>());
            objectDC.putAll(jsonObjectDC);
            objectDC.putAll(object1);
            objecty.add(objectDC);
           // objectDC.clear();
            JSONObject object2 = (JSONObject) JSONObject.toJSON(listDD.get(i));
            JSONObject objectDD=new JSONObject(new LinkedHashMap<>());
            objectDD.putAll(jsonObjectDD);
            objectDD.putAll(object2);
            objecty.add(objectDD);
            //objectDD.clear();
            JSONObject object3 = (JSONObject) JSONObject.toJSON(listXC.get(i));
            JSONObject objectXC=new JSONObject(new LinkedHashMap<>());
            objectXC.putAll(jsonObjectXC);
            objectXC.putAll(object3);
            objecty.add(objectXC);
           // objectXC.clear();
            JSONObject object4 = (JSONObject) JSONObject.toJSON(listXD.get(i));
            JSONObject objectXD=new JSONObject(new LinkedHashMap<>());
            objectXD.putAll(jsonObjectXD);
            objectXD.putAll(object4);
            objecty.add(objectXD);



        }

        return objecty;


    }
}