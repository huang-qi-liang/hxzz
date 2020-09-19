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
      /*  List<Object> listDC = new ArrayList<>(scglDCService.getDataIN(date1, date2));
        List<Object> listDD = new ArrayList<>(scglDDService.getDataIN(date1, date2));
        List<Object> listXC = new ArrayList<>(scglXCService.getDataIN(date1, date2));
        List<Object> listXD = new ArrayList<>(scglXDService.getDataIN(date1, date2));

       */
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

            JSONObject object1=new JSONObject(new LinkedHashMap<>());

            object1.put("targetCapacity",  scglDCService.getDataIN(date1, date2).get(i).getTargetCapacity());
            object1.put("actualCapacity",scglDCService.getDataIN(date1, date2).get(i).getActualCapacity());
            object1.put("targetEfficiency",scglDCService.getDataIN(date1, date2).get(i).getTargetEfficiency());
            object1.put("actualEfficiency",scglDCService.getDataIN(date1, date2).get(i).getActualEfficiency());
            object1.put("workingHours",scglDCService.getDataIN(date1, date2).get(i).getWorkingHours());
            object1.put("theoreticalCapacity",scglDCService.getDataIN(date1, date2).get(i).getTheoreticalCapacity());

           // log.println(listDC.get(i));
            JSONObject objectDC=new JSONObject(new LinkedHashMap<>());
            objectDC.putAll(jsonObjectDC);
            objectDC.putAll(object1);
            objecty.add(objectDC);
           // objectDC.clear();
            JSONObject object2=new JSONObject(new LinkedHashMap<>());

            object2.put("targetCapacity",  scglDDService.getDataIN(date1, date2).get(i).getTargetCapacity());
            object2.put("actualCapacity",scglDDService.getDataIN(date1, date2).get(i).getActualCapacity());
            object2.put("targetEfficiency",scglDDService.getDataIN(date1, date2).get(i).getTargetEfficiency());
            object2.put("actualEfficiency",scglDDService.getDataIN(date1, date2).get(i).getActualEfficiency());
            object2.put("workingHours",scglDDService.getDataIN(date1, date2).get(i).getWorkingHours());
            object2.put("theoreticalCapacity",scglDDService.getDataIN(date1, date2).get(i).getTheoreticalCapacity());

            JSONObject objectDD=new JSONObject(new LinkedHashMap<>());
            objectDD.putAll(jsonObjectDD);
            objectDD.putAll(object2);
            objecty.add(objectDD);
            //objectDD.clear();
            JSONObject object3=new JSONObject(new LinkedHashMap<>());

            object3.put("targetCapacity",  scglXCService.getDataIN(date1, date2).get(i).getTargetCapacity());
            object3.put("actualCapacity",scglXCService.getDataIN(date1, date2).get(i).getActualCapacity());
            object3.put("targetEfficiency",scglXCService.getDataIN(date1, date2).get(i).getTargetEfficiency());
            object3.put("actualEfficiency",scglXCService.getDataIN(date1, date2).get(i).getActualEfficiency());
            object3.put("workingHours",scglXCService.getDataIN(date1, date2).get(i).getWorkingHours());
            object3.put("theoreticalCapacity",scglXCService.getDataIN(date1, date2).get(i).getTheoreticalCapacity());

            JSONObject objectXC=new JSONObject(new LinkedHashMap<>());
            objectXC.putAll(jsonObjectXC);
            objectXC.putAll(object3);
            objecty.add(objectXC);
           // objectXC.clear();
            JSONObject object4=new JSONObject(new LinkedHashMap<>());

            object4.put("targetCapacity",  scglXDService.getDataIN(date1, date2).get(i).getTargetCapacity());
            object4.put("actualCapacity",scglXDService.getDataIN(date1, date2).get(i).getActualCapacity());
            object4.put("targetEfficiency",scglXDService.getDataIN(date1, date2).get(i).getTargetEfficiency());
            object4.put("actualEfficiency",scglXDService.getDataIN(date1, date2).get(i).getActualEfficiency());
            object4.put("workingHours",scglXDService.getDataIN(date1, date2).get(i).getWorkingHours());
            object4.put("theoreticalCapacity",scglXDService.getDataIN(date1, date2).get(i).getTheoreticalCapacity());

            JSONObject objectXD=new JSONObject(new LinkedHashMap<>());
            objectXD.putAll(jsonObjectXD);
            objectXD.putAll(object4);
            objecty.add(objectXD);



        }

        return objecty;


    }
}