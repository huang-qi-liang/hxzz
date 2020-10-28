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

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

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

    public JSONObject showPackage() {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());

        jsonObject.put("target", aimService.show().getQuality());
        jsonObject.put("actual", qualityService.showSum().getDR());
        jsonObject.put("responsibility", quality3Service.showClient().get(1).getTotal());
        jsonObject.put("interceptionProblem", quality3Service.showClient().get(0).getTotal());
        jsonObject.put("quantity", quality2Service.showSum().getTotal());
        return jsonObject;
    }

    public JSONObject infoPackage(LocalDate date1, LocalDate date2) {
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());

        jsonObject.put("target", aimService.show().getQuality());

        jsonObject.put("actual", qualityService.infoSum(date1, date2).getDR());

        jsonObject.put("responsibility", quality3Service.infoClient(date1, date2).get(1).getTotal());

        jsonObject.put("interceptionProblem", quality3Service.infoClient(date1, date2).get(0).getTotal());

        jsonObject.put("quantity", quality2Service.infoSum(date1, date2).getTotal());

        return jsonObject;

    }

}
