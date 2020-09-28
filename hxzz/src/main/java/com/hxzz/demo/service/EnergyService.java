package com.hxzz.demo.service;

import com.hxzz.demo.entity.Energy;
import com.baomidou.mybatisplus.extension.service.IService;

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
   Energy show();

    List<Energy> getData(LocalDate date1, LocalDate date2);

    void add( String name, Float standardsWater,Float water,Float standardsElectricity,Float electricity,Float standardsGas,Float gas);
    void del(Integer id);
    void change( Integer id,String name, Float standardsWater,Float water,Float standardsElectricity,Float electricity,
                 Float standardsGas,Float gas);

}
