package com.hxzz.demo.service.impl;

import com.hxzz.demo.bean.SgmwSelect;
import com.hxzz.demo.entity.Sgmw;
import com.hxzz.demo.mapper.SgmwMapper;
import com.hxzz.demo.service.SgmwService;
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
 * @since 2020-09-16
 */
@Service
public class SgmwServiceImpl extends ServiceImpl<SgmwMapper, Sgmw> implements SgmwService {
@Autowired
SgmwMapper sgmwMapper;
@Override
    public SgmwSelect showIN(){
    return sgmwMapper.show();
}
@Override
   public void addIN(String name,Integer safe,Integer production,Integer lzc,Float quality,Integer personnel,String energyConsumption,Float equipment){
    sgmwMapper.add(name,safe,production,lzc,quality,personnel,energyConsumption,equipment);
   }
    public  List<SgmwSelect> getDataIN(LocalDate date1, LocalDate date2){
    return  sgmwMapper.getData(date1,date2);
    }
   public void delIN(LocalDate date){
    sgmwMapper.del(date);
   }
   public void changeIN(String name,Integer safe,Integer production,Integer lzc,Float quality,Integer personnel,String energyConsumption,Float equipment){
    sgmwMapper.change(name,safe,production,lzc,quality,personnel,energyConsumption,equipment);
   }


}
