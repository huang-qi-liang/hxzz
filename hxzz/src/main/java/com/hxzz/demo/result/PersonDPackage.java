package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.PersonDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Configuration
@Component
public class PersonDPackage {
    @Autowired
    PersonDService personDService;
    public void PersonDPackage(){
       List<JSONObject> list=new ArrayList<>();
       JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
       jsonObject.put("A线内饰",personDService.showDCTrim().getRegion());
       jsonObject.put("personnalLeave",personDService.showDCTrim().getPersonalLeave());
       jsonObject.put("sickLeave",personDService.showDCTrim().getSickLeave());
       jsonObject.put("annualLeave",personDService.showDCTrim().getAnnualLeave());
       jsonObject.put("nursingLeave",personDService.showDCTrim().getNursingLeave();
       jsonObject.put("bereavementLeave",personDService.showDCTrim().getBereavementLeave());
       jsonObject.put("total",personDService.showDCTrim().getTotal());
       jsonObject.put("date",personDService.showDCTrim().getDate());
       list.add(jsonObject);
       jsonObject

    }
}
