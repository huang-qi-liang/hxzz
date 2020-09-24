package com.hxzz.demo.service.impl;

import com.hxzz.demo.entity.Energy;
import com.hxzz.demo.mapper.EnergyMapper;
import com.hxzz.demo.service.EnergyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
@Service
public class EnergyServiceImpl extends ServiceImpl<EnergyMapper, Energy> implements EnergyService {
@Autowired
    EnergyMapper energyMapper;
@Override
public Energy showWater(){
    return energyMapper.showWater();
}
  public   Energy showElectricity(){
    return energyMapper.showElectricity();
  }
   public Energy showGas(){
    return energyMapper.showGas();
   }
   public List<Energy> getWaterData(LocalDate date1, LocalDate date2){
    return energyMapper.getWaterData(date1,date2);
   }
  public   List<Energy> getElectricityData(LocalDate date1,LocalDate date2){
    return energyMapper.getElectricityData(date1,date2);
  }
    public List<Energy> getGasData(LocalDate date1,LocalDate date2){
    return energyMapper.getGasData(date1,date2);
    }
    public void add( String name, Float standardsWater,Float water,Float standardsElectricity,Float electricity,
               Float standardsGas,Float gas){
    energyMapper.add( name,  standardsWater, water, standardsElectricity, electricity,
             standardsGas, gas);
    }
    public void del(Integer id){
    energyMapper.del(id);
    }
    public void change( Integer id,String name, Float standardsWater,Float water,Float standardsElectricity,
                   Float electricity,
                 Float standardsGas,Float gas){
    energyMapper.change(id,name,  standardsWater, water, standardsElectricity, electricity,
            standardsGas, gas);
    }
}
