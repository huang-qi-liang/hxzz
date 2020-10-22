package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.PersonDService;
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
public class PersonDPackage {
    @Autowired
    PersonDService personDService;
    @Autowired
    PersonDPackage personDPackage;

    public JSONObject showClientPackage() {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("region", "合计");
        jsonObject.put("personalLeave", personDService.Sum().getPersonalLeave());
        jsonObject.put("sickLeave", personDService.Sum().getSickLeave());
        jsonObject.put("annualLeave", personDService.Sum().getAnnualLeave());
        jsonObject.put("nursingLeave", personDService.Sum().getNursingLeave());
        jsonObject.put("bereavementLeave", personDService.Sum().getBereavementLeave());
        jsonObject.put("total", personDService.Sum().getTotal());
        jsonObject.put("date", personDService.Sum().getDate());
        return jsonObject;
    }

    public JSONObject ClientPackage(LocalDate date1, LocalDate date2) {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("region", "合计");
        jsonObject.put("personalLeave", personDService.sumClient(date1, date2).getPersonalLeave());
        jsonObject.put("sickLeave", personDService.sumClient(date1, date2).getSickLeave());
        jsonObject.put("annualLeave", personDService.sumClient(date1, date2).getAnnualLeave());
        jsonObject.put("nursingLeave", personDService.sumClient(date1, date2).getNursingLeave());
        jsonObject.put("bereavementLeave", personDService.sumClient(date1, date2).getBereavementLeave());
        jsonObject.put("total", personDService.sumClient(date1, date2).getTotal());
        jsonObject.put("date", personDService.sumClient(date1, date2).getDate());
        return jsonObject;
    }
   /* public List PersonDList(LocalDate date1, LocalDate date2) {
        long i;
        LocalDate localDate;
        localDate=date1;

        List list = new ArrayList<>();
        for (i=0; i<= ChronoUnit.DAYS.between(date1,date2); i++) {

            if (personDService.getClient(localDate).isEmpty()) {
                localDate = localDate.plusDays(1);

            }
            else
            {

                list.addAll(personDService.getClient(localDate));

                JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
                jsonObject=personDPackage.ClientPackage(localDate);
                List list1=new ArrayList();
                list1.add(jsonObject);
                list.addAll(list1);



                localDate =localDate.plusDays(1);
            }



        }
        log.println(list);
        return list;
    }

    */


}
