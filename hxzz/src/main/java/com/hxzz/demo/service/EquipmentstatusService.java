package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.Equipment;
import com.hxzz.demo.entity.Equipmentstatus;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzz.demo.entity.Lzcsj;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hql
 * @since 2020-10-14
 */
public interface EquipmentstatusService extends IService<Equipmentstatus> {
    List<Equipmentstatus> show();

    List<Equipmentstatus> showClient();

    Equipmentstatus showSum();

    List<Equipmentstatus> info(LocalDate date1, LocalDate date2);

    List<Equipmentstatus> infoClient(LocalDate date1, LocalDate date2);

    Equipmentstatus infoSum(LocalDate date1, LocalDate date2);

    /* Integer waitingToBeLoadedSum(LocalDate date);
     Integer loopToCrossTheLineSum(LocalDate date);
     Integer bhCirculationSum(LocalDate date);
     Integer actualCirculationSum(LocalDate date);
     Integer totalSum(LocalDate date);

     */
    List<Equipment> each(Integer date, String name);

    Equipment eachYear(Integer date, String name);

    List<Equipment> total(Integer date);

    Equipment totalYear(Integer date);

    void add(String name, Float failureTime, Float officeTime, LocalDate date);

    void del(Integer id);

    void change(Integer id, String name, Float failureTime, Float officeTime, LocalDate date);

    PageInfo<Equipmentstatus> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);
}
