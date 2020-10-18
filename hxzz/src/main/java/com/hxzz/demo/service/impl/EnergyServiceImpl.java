package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Energy;
import com.hxzz.demo.entity.Energy;
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
public List<Energy> show(){return energyMapper.show();}
    public Energy showClient(){return energyMapper.showClient();}
    public Energy showSum(){return  energyMapper.showSum();}
   public Energy infoSum(LocalDate date1,LocalDate date2){return energyMapper.infoSum(date1,date2);}

    public List<Energy> info(LocalDate date1,LocalDate date2){return energyMapper.info(date1,date2);}
    public Energy infoClient(LocalDate date1,LocalDate date2){return energyMapper.infoClient(date1,date2);}
    public void add( String name, Float standardsWater,Float water,Float standardsElectricity,Float electricity,
               Float standardsGas,Float gas,LocalDate date){
    energyMapper.add( name,  standardsWater, water, standardsElectricity, electricity,
             standardsGas, gas, date);
    }
    public void del(Integer id){
    energyMapper.del(id);
    }
    public void change( Integer id,String name, Float standardsWater,Float water,Float standardsElectricity,
                   Float electricity,
                 Float standardsGas,Float gas,LocalDate date){
    energyMapper.change(id,name,  standardsWater, water, standardsElectricity, electricity,
            standardsGas, gas,date);
    }
    public PageInfo<Energy> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2){
        PageHelper.startPage(pageNum,pageSize);
        List<Energy> list=energyMapper.info(date1,date2);
        PageInfo<Energy> pageInfo=new PageInfo<Energy>(list);
        return pageInfo;
    }
}
