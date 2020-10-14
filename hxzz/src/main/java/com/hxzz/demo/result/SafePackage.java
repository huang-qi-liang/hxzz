package com.hxzz.demo.result;

import com.alibaba.fastjson.JSONObject;
import com.hxzz.demo.entity.Safe;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Configuration
@Component
public class SafePackage {
    public List showPackage(List<Safe> listSafe, int size){

     List list=new ArrayList();
     for(int i=0;i<size;i++){
         JSONObject jsonObject=new JSONObject(new LinkedHashMap<>());
         if( listSafe.get(i).getRed()!=0){
             jsonObject.put("corlor","red");
             jsonObject.put("number",listSafe.get(i).getRed());
         }
          else if(listSafe.get(i).getYellow()!=0){
             jsonObject.put("corlor","yellow");
             jsonObject.put("number",listSafe.get(i).getYellow());
             }
         else if(listSafe.get(i).getBlue()!=0){
             jsonObject.put("corlor","blue");
             jsonObject.put("number",listSafe.get(i).getBlue());
         }
         else if(listSafe.get(i).getGrey()!=0){
             jsonObject.put("corlor","grey");
             jsonObject.put("number",listSafe.get(i).getGrey());
         }
         else {
             jsonObject.put("corlor","green");

             jsonObject.put("number",0);
         }
jsonObject.put("date",listSafe.get(i).getDate());
         list.add(jsonObject);
         }




     return list;

    }



}
