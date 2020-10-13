package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Energy;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzz.demo.entity.Energy;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
public interface EnergyService extends IService<Energy> {
    List<Energy> show();
    Energy showClient();

    List<Energy> info(LocalDate date1,LocalDate date2);
    Energy infoClient(LocalDate date1,LocalDate date2);
    void add( String name, Float standardsWater,Float water,Float standardsElectricity,Float electricity,Float standardsGas,Float gas,LocalDate date);
    void del(Integer id);
    void change( Integer id,String name, Float standardsWater,Float water,Float standardsElectricity,Float electricity,
                 Float standardsGas,Float gas,LocalDate date);
    PageInfo<Energy> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);

}
