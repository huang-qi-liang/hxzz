package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.PersonDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Configuration
@Component
public class PersonDPackage {
    @Autowired
    PersonDService personDService;
    /*
    public List<JSONObject> PersonDPackage(){
       List<JSONObject> list=new ArrayList<>();
       JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
       jsonObject.put("A线内饰",personDService.showDCTrim().getRegion());
       jsonObject.put("personnalLeave",personDService.showDCTrim().getPersonalLeave());
       jsonObject.put("sickLeave",personDService.showDCTrim().getSickLeave());
       jsonObject.put("annualLeave",personDService.showDCTrim().getAnnualLeave());
       jsonObject.put("nursingLeave",personDService.showDCTrim().getNursingLeave());
       jsonObject.put("bereavementLeave",personDService.showDCTrim().getBereavementLeave());
       jsonObject.put("total",personDService.showDCTrim().getTotal());
       jsonObject.put("date",personDService.showDCTrim().getDate());
       list.add(jsonObject);
     JSONObject jsonObject2=new JSONObject(new LinkedHashMap<>());
       jsonObject2.put("A线底盘",personDService.showDCDomain().getRegion());
        jsonObject2.put("personnalLeave",personDService.showDCDomain().getPersonalLeave());
        jsonObject2.put("sickLeave",personDService.showDCDomain().getSickLeave());
        jsonObject2.put("annualLeave",personDService.showDCDomain().getAnnualLeave());
        jsonObject2.put("nursingLeave",personDService.showDCDomain().getNursingLeave());
        jsonObject2.put("bereavementLeave",personDService.showDCDomain().getBereavementLeave());
        jsonObject2.put("total",personDService.showDCDomain().getTotal());
        jsonObject2.put("date",personDService.showDCDomain().getDate());
        list.add(jsonObject2);
     JSONObject jsonObject3=new JSONObject(new LinkedHashMap<>());
        jsonObject3.put("A线门线",personDService.showDCGateLine().getRegion());
        jsonObject3.put("personnalLeave",personDService.showDCGateLine().getPersonalLeave());
        jsonObject3.put("sickLeave",personDService.showDCGateLine().getSickLeave());
        jsonObject3.put("annualLeave",personDService.showDCGateLine().getAnnualLeave());
        jsonObject3.put("nursingLeave",personDService.showDCGateLine().getNursingLeave());
        jsonObject3.put("bereavementLeave",personDService.showDCGateLine().getBereavementLeave());
        jsonObject3.put("total",personDService.showDCGateLine().getTotal());
        jsonObject3.put("date",personDService.showDCGateLine().getDate());
        list.add(jsonObject3);
     JSONObject jsonObject4=new JSONObject(new LinkedHashMap<>());
        jsonObject4.put("A线终线",personDService.showDCTerminalLine().getRegion());
        jsonObject4.put("personnalLeave",personDService.showDCTerminalLine().getPersonalLeave());
        jsonObject4.put("sickLeave",personDService.showDCTerminalLine().getSickLeave());
        jsonObject4.put("annualLeave",personDService.showDCTerminalLine().getAnnualLeave());
        jsonObject4.put("nursingLeave",personDService.showDCTerminalLine().getNursingLeave());
        jsonObject4.put("bereavementLeave",personDService.showDCTerminalLine().getBereavementLeave());
        jsonObject4.put("total",personDService.showDCTerminalLine().getTotal());
        jsonObject4.put("date",personDService.showDCTerminalLine().getDate());
        list.add(jsonObject4);
     JSONObject jsonObject5=new JSONObject(new LinkedHashMap<>());
        jsonObject5.put("B线内饰",personDService.showDDTrim().getRegion());
        jsonObject5.put("personnalLeave",personDService.showDDTrim().getPersonalLeave());
        jsonObject5.put("sickLeave",personDService.showDDTrim().getSickLeave());
        jsonObject5.put("annualLeave",personDService.showDDTrim().getAnnualLeave());
        jsonObject5.put("nursingLeave",personDService.showDDTrim().getNursingLeave());
        jsonObject5.put("bereavementLeave",personDService.showDDTrim().getBereavementLeave());
        jsonObject5.put("total",personDService.showDDTrim().getTotal());
        jsonObject5.put("date",personDService.showDDTrim().getDate());
        list.add(jsonObject5);
     JSONObject jsonObject6=new JSONObject(new LinkedHashMap<>());
        jsonObject6.put("B线底盘",personDService.showDDDomain().getRegion());
        jsonObject6.put("personnalLeave",personDService.showDDDomain().getPersonalLeave());
        jsonObject6.put("sickLeave",personDService.showDDDomain().getSickLeave());
        jsonObject6.put("annualLeave",personDService.showDDDomain().getAnnualLeave());
        jsonObject6.put("nursingLeave",personDService.showDDDomain().getNursingLeave());
        jsonObject6.put("bereavementLeave",personDService.showDDDomain().getBereavementLeave());
        jsonObject6.put("total",personDService.showDDDomain().getTotal());
        jsonObject6.put("date",personDService.showDDDomain().getDate());
        list.add(jsonObject6);
     JSONObject jsonObject7=new JSONObject(new LinkedHashMap<>());
        jsonObject7.put("B线门线",personDService.showDDGateLine().getRegion());
        jsonObject7.put("personnalLeave",personDService.showDDGateLine().getPersonalLeave());
        jsonObject7.put("sickLeave",personDService.showDDGateLine().getSickLeave());
        jsonObject7.put("annualLeave",personDService.showDDGateLine().getAnnualLeave());
        jsonObject7.put("nursingLeave",personDService.showDDGateLine().getNursingLeave());
        jsonObject7.put("bereavementLeave",personDService.showDDGateLine().getBereavementLeave());
        jsonObject7.put("total",personDService.showDDGateLine().getTotal());
        jsonObject7.put("date",personDService.showDDGateLine().getDate());
        list.add(jsonObject7);
     JSONObject jsonObject8=new JSONObject(new LinkedHashMap<>());

        jsonObject8.put("B线终线",personDService.showDDTerminalLine().getRegion());
        jsonObject8.put("personnalLeave",personDService.showDDTerminalLine().getPersonalLeave());
        jsonObject8.put("sickLeave",personDService.showDDTerminalLine().getSickLeave());
        jsonObject8.put("annualLeave",personDService.showDDTerminalLine().getAnnualLeave());
        jsonObject8.put("nursingLeave",personDService.showDDTerminalLine().getNursingLeave());
        jsonObject8.put("bereavementLeave",personDService.showDDTerminalLine().getBereavementLeave());
        jsonObject8.put("total",personDService.showDDTerminalLine().getTotal());
        jsonObject8.put("date",personDService.showDDTerminalLine().getDate());
        list.add(jsonObject8);
        JSONObject jsonObject9=new JSONObject(new LinkedHashMap<>());

        log.println(list);
        return list;
    }

     */
    public void PersonList(){

    }
}
