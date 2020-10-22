package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.entity.EnvironmentSafe;
import com.hxzz.demo.entity.Safe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class EnvironmentSafePackage {
    public List showPackage(List<EnvironmentSafe> listSafe, int size) {

        List list = new ArrayList();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            if (listSafe.get(i).getBlack() != 0) {
                jsonObject.put("corlor", "black");
                jsonObject.put("number", listSafe.get(i).getBlack());
            } else if (listSafe.get(i).getRed() != 0) {
                jsonObject.put("corlor", "red");
                jsonObject.put("number", listSafe.get(i).getRed());
            } else if (listSafe.get(i).getGrey() != 0) {
                jsonObject.put("corlor", "grey");
                jsonObject.put("number", listSafe.get(i).getGrey());
            } else {
                jsonObject.put("corlor", "green");

                jsonObject.put("number", 0);
            }
            jsonObject.put("date", listSafe.get(i).getDate());
            list.add(jsonObject);
        }


        return list;

    }
}
