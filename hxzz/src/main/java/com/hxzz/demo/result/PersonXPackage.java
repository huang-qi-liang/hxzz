package com.hxzz.demo.result;


import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.PersonXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.LinkedHashMap;

@Configuration
@Component
public class PersonXPackage {
    @Autowired
    PersonXService personXService;
    @Autowired
    PersonXPackage personXPackage;

    public JSONObject showClientPackage() {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("region", "合计");
        jsonObject.put("personalLeave", personXService.Sum().getPersonalLeave());
        jsonObject.put("sickLeave", personXService.Sum().getSickLeave());
        jsonObject.put("annualLeave", personXService.Sum().getAnnualLeave());
        jsonObject.put("nursingLeave", personXService.Sum().getNursingLeave());
        jsonObject.put("bereavementLeave", personXService.Sum().getBereavementLeave());
        jsonObject.put("total", personXService.Sum().getTotal());
        jsonObject.put("date", personXService.Sum().getDate());
        return jsonObject;
    }

    public JSONObject ClientPackage(LocalDate date1, LocalDate date2) {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put("region", "合计");
        jsonObject.put("personalLeave", personXService.sumClient(date1, date2).getPersonalLeave());
        jsonObject.put("sickLeave", personXService.sumClient(date1, date2).getSickLeave());
        jsonObject.put("annualLeave", personXService.sumClient(date1, date2).getAnnualLeave());
        jsonObject.put("nursingLeave", personXService.sumClient(date1, date2).getNursingLeave());
        jsonObject.put("bereavementLeave", personXService.sumClient(date1, date2).getBereavementLeave());
        jsonObject.put("total", personXService.sumClient(date1, date2).getTotal());
        jsonObject.put("date", personXService.sumClient(date1, date2).getDate());
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
