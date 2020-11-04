package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Id;
import com.hxzz.demo.bean.Info;
import com.hxzz.demo.bean.InfoShift;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Lzcsj;
import com.hxzz.demo.entity.Quality2;
import com.hxzz.demo.result.LzcsjPackage;
import com.hxzz.demo.service.LzcsjService;
import net.sf.saxon.functions.AccessorFn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import com.hxzz.demo.bean.Date;


import static java.lang.Integer.parseInt;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
@Async
@Component
@Configuration
@EnableScheduling
@RestController
@CrossOrigin
@RequestMapping("/Lzcsj")
public class LzcsjController {
    @Autowired
    LzcsjService lzcsjService;
    @Autowired
    LzcsjPackage lzcsjPackage;

    @RequestMapping("/show")
    public Result show() {
        List list = new ArrayList<>();
        list = lzcsjService.show();
        return Result.succ(list);
    }

    @RequestMapping("/showClient")
    public Result showClient() {
        List list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject = lzcsjPackage.showPackage();
        list = lzcsjService.showClient();
        list.add(jsonObject);
        return Result.succ(list);
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Info info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<Lzcsj> pageInfo = lzcsjService.findAll(info.getPageNum(), info.getPageSize(), date1, date2);

        return Result.succ(pageInfo);

    }
    @RequestMapping("/infoShift")
    public Result infoShift(@RequestBody InfoShift info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<Lzcsj> pageInfo = lzcsjService.findShiftAll(info.getName(),info.getPageNum(), info.getPageSize(), date1,
                date2);

        return Result.succ(pageInfo);

    }
    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(date.getTime2(), dateTimeFormatter);
        List list = new ArrayList();
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject = lzcsjPackage.ClientPackage(date1, date2);
        list = lzcsjService.infoClient(date1, date2);
        list.add(jsonObject);

        log.println("lzcsjinfoClient");

        return Result.succ(list);

    }

    @RequestMapping("/add")
    public Result add(@RequestBody List<JSONObject> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {

            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date=LocalDate.parse(jsonObject.getString("date"),dateTimeFormatter);
            lzcsjService.add(jsonObject.getString("name"),jsonObject.getInteger("waitingToBeLoaded"),
                    jsonObject.getInteger("loopToCrossTheLine"),jsonObject.getInteger("bhCirculation"),
                    jsonObject.getInteger("actualCirculation"),date);
        }
        /*
    JSONObject jsondata=new JSONObject(new LinkedHashMap<>());
    jsondata=jsonObject.getJSONObject("data");
    JSONArray jsonArray=new JSONArray();
    jsonArray=jsondata.getJSONArray("message");
    int size=jsonArray.size();
    int i;
    ArrayList<JSONObject> arrayList=new ArrayList<>();
  for(i=0;i<size;i++){
      arrayList.add((JSONObject) JSONObject.toJSON(jsonArray.get(i)));
      lzcsjService.add(arrayList.get(i).getString("name"),arrayList.get(i).getInteger("waitingToBeLoaded"),
              arrayList.get(i).getInteger("loopToCrossTheLine"),arrayList.get(i).getInteger("bhCirculation"),
              arrayList.get(i).getInteger("actualCirculation"));
  }
  return "success";

         */
        return Result.succ("success");

    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody List<JSONObject> list) {

        int size = list.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            String Id = jsonObject.getString("id");
            Integer id = parseInt(Id, 10);
            lzcsjService.del(id);
        }
        return Result.succ("success");
    }

    @RequestMapping("change")
    public Result change(@RequestBody List<JSONObject> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {

            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date=LocalDate.parse(jsonObject.getString("date"),dateTimeFormatter);
            lzcsjService.change(jsonObject.getInteger("id"),jsonObject.getString("name"),jsonObject.getInteger(
                    "waitingToBeLoaded"),
                    jsonObject.getInteger("loopToCrossTheLine"),jsonObject.getInteger("bhCirculation"),
                    jsonObject.getInteger("actualCirculation"),date);
        }
        return Result.succ("success");
    }


}
