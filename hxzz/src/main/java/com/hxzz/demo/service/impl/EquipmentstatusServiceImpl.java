package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Equipment;
import com.hxzz.demo.entity.Equipmentstatus;
import com.hxzz.demo.entity.Equipmentstatus;
import com.hxzz.demo.mapper.EquipmentstatusMapper;
import com.hxzz.demo.service.EquipmentstatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hql
 * @since 2020-10-14
 */
@Service
public class EquipmentstatusServiceImpl extends ServiceImpl<EquipmentstatusMapper, Equipmentstatus> implements EquipmentstatusService {
    @Autowired
    EquipmentstatusMapper equipmentstatusMapper;

    public List<Equipmentstatus> show() {
        return equipmentstatusMapper.show();
    }

    public List<Equipmentstatus> showClient() {
        return equipmentstatusMapper.showClient();
    }

    public List<Equipmentstatus> info(LocalDate date1, LocalDate date2) {
        return equipmentstatusMapper.info(date1, date2);
    }

    public List<Equipmentstatus> infoClient(LocalDate date1, LocalDate date2) {
        return equipmentstatusMapper.infoClient(date1, date2);
    }

    public Equipmentstatus showSum() {
        return equipmentstatusMapper.showSum();
    }

    public Equipmentstatus infoSum(LocalDate date1, LocalDate date2) {
        return equipmentstatusMapper.infoSum(date1, date2);
    }

    //图表数据
    public List<Equipment> each(Integer date, String name) {
        return equipmentstatusMapper.each(date, name);
    }

    public Equipment eachYear(Integer date, String name) {
        return equipmentstatusMapper.eachYear(date, name);
    }

    public List<Equipment> total(Integer date) {
        return equipmentstatusMapper.total(date);
    }

    public Equipment totalYear(Integer date) {
        return equipmentstatusMapper.totalYear(date);
    }

    //增删改方法
    public void add(String name, Float failureTime, Float officeTime, LocalDate date) {
        equipmentstatusMapper.add(name, failureTime, officeTime, date);
    }

    public void del(Integer id) {
        equipmentstatusMapper.del(id);
    }

    public void change(Integer id, String name, Float failureTime, Float officeTime, LocalDate date) {
        equipmentstatusMapper.change(id, name, failureTime, officeTime, date);
    }

    public PageInfo<Equipmentstatus> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2) {
        PageHelper.startPage(pageNum, pageSize);
        List<Equipmentstatus> list = equipmentstatusMapper.info(date1, date2);
        PageInfo<Equipmentstatus> pageInfo = new PageInfo<Equipmentstatus>(list);
        return pageInfo;
    }
}
