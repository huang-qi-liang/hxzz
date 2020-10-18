package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.service.AimService;
import com.hxzz.demo.service.Quality2Service;
import com.hxzz.demo.service.Quality3Service;
import com.hxzz.demo.service.QualityService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class Quality4Package {
    @Autowired
    AimService aimService;
    @Autowired
    QualityService qualityService;
    @Autowired
    Quality2Service quality2Service;
    @Autowired
    Quality3Service quality3Service;
    public JSONObject showPackage(){
       JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());

       jsonObject.put("目标",aimService.show().getQuality());
       jsonObject.put("实际",qualityService.showSum().getDR());
       jsonObject.put("总装责任错漏装",quality3Service.showClient().get(1).getTotal());
       jsonObject.put("拦截问题",quality3Service.showClient().get(0).getTotal());
       jsonObject.put("变化点",quality2Service.showSum().getTotal());
       return  jsonObject;
    }
    public  JSONObject  infoPackage(LocalDate date1,LocalDate date2)  {
        JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());

        jsonObject.put("目标",aimService.show().getQuality());
        jsonObject.put("实际",qualityService.infoSum(date1,date2).getDR());
        jsonObject.put("总装责任错漏装",quality3Service.infoClient(date1, date2).get(1).getTotal());
        jsonObject.put("拦截问题",quality3Service.infoClient(date1, date2).get(0).getTotal());
        jsonObject.put("变化点",quality2Service.infoSum(date1, date2).getTotal());
        return  jsonObject;
    }

}
