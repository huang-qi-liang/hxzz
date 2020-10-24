package com.hxzz.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Date;
import com.hxzz.demo.bean.EquipmentDate;
import com.hxzz.demo.bean.Info;
import com.hxzz.demo.common.lang.Result;
import com.hxzz.demo.entity.Equipmentstatus;
import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.result.EquipmentPackage;
import com.hxzz.demo.service.EquipmentstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hql
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/Equipmentstatus")
public class EquipmentstatusController {
    @Autowired
    EquipmentstatusService equipmentstatusService;
    @Autowired
    EquipmentPackage equipmentPackage;

    @RequestMapping("/show")
    public Result show() {
        List list = new ArrayList<>();
        list = equipmentstatusService.show();
        return Result.succ(list);
    }

    @RequestMapping("/showClient")
    public Result showClient() {
        List list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());

        list = equipmentstatusService.showClient();
        list.add(jsonObject);
        return Result.succ(list);
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Info info) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(info.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(info.getTime2(), dateTimeFormatter);

        PageInfo<Equipmentstatus> pageInfo = equipmentstatusService.findAll(info.getPageNum(), info.getPageSize(), date1, date2);

        return Result.succ(pageInfo);

    }

    @RequestMapping("/infoClient")
    public Result infoClient(@RequestBody Date date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.getTime1(), dateTimeFormatter);

        LocalDate date2 = LocalDate.parse(date.getTime2(), dateTimeFormatter);
        List list = new ArrayList();

        list = equipmentstatusService.infoClient(date1, date2);
        list.add(list);


        return Result.succ(list);

    }

    @RequestMapping("/lineTotal")
    public Result lineTotal(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = equipmentPackage.lineTotal(date.getTime());

        return Result.succ(list);

    }

    @RequestMapping("/lineA")
    public Result lineA(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = equipmentPackage.line(date.getTime(), "A线");

        return Result.succ(list);

    }

    @RequestMapping("/lineB")
    public Result lineB(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = equipmentPackage.line(date.getTime(), "B线");
        return Result.succ(list);

    }

    @RequestMapping("/lineC")
    public Result lineC(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = equipmentPackage.line(date.getTime(), "C线");
        return Result.succ(list);

    }

    @RequestMapping("/lineD")
    public Result lineD(@RequestBody EquipmentDate date) {

        List list = new ArrayList();
        list = equipmentPackage.line(date.getTime(), "D线");
        return Result.succ(list);

    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody List<JSONObject> list) {

        int size = list.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            String Id = jsonObject.getString("id");
            Integer id = parseInt(Id, 10);
            equipmentstatusService.del(id);
        }
        return Result.succ("success");
    }

    @RequestMapping("/add")
    public Result add(@RequestBody List<JSONObject> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {

            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date=LocalDate.parse(jsonObject.getString("date"),dateTimeFormatter);
            equipmentstatusService.add(jsonObject.getString("name"),jsonObject.getFloat("failureTime"),
                    jsonObject.getFloat("officeTime"),date);
        }
        return Result.succ("success");
    }

    @RequestMapping("/change")
    public Result change(@RequestBody List<JSONObject> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {

            JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
            jsonObject = list.get(i);
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date=LocalDate.parse(jsonObject.getString("date"),dateTimeFormatter);
            equipmentstatusService.change(jsonObject.getInteger("id"),jsonObject.getString("name"),jsonObject.getFloat(
                    "failureTime"),
                    jsonObject.getFloat("officeTime"),date);
        }
        return Result.succ("success");
    }

}
