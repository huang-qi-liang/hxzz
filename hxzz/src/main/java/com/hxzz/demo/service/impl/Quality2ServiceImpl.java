package com.hxzz.demo.service.impl;

import com.hxzz.demo.entity.Quality2;
import com.hxzz.demo.mapper.Quality2Mapper;
import com.hxzz.demo.service.Quality2Service;
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
public class Quality2ServiceImpl extends ServiceImpl<Quality2Mapper, Quality2> implements Quality2Service {
    @Autowired
    Quality2Mapper quality2Mapper;
    @Override
   public Quality2 showA(){return quality2Mapper.showA();}
   public Quality2 showB(){return quality2Mapper.showB();}
   public Quality2 showC(){return quality2Mapper.showC();}
   public Quality2 showD(){return quality2Mapper.showD();}
   public List<Quality2> getDataA(LocalDate date1, LocalDate date2){return quality2Mapper.getDataA(date1,date2);}
   public List<Quality2> getDataB(LocalDate date1,LocalDate date2){return  quality2Mapper.getDataB(date1,date2);}
   public List<Quality2> getDataC(LocalDate date1,LocalDate date2){return quality2Mapper.getDataC(date1,date2);}
   public List<Quality2> getDataD(LocalDate date1,LocalDate date2){return quality2Mapper.getDataD(date1,date2);}
   public void add(String productionLine,Integer breakpoint,Integer paa,Integer ptr,Integer craft,Integer tools){
        quality2Mapper.add(productionLine,breakpoint,paa,ptr,craft,tools);
   }
   public void del(Integer id){quality2Mapper.del(id);}
   public void change(Integer id,String productionLine,Integer breakpoint,Integer paa,  Integer ptr,Integer craft,
                 Integer tools){quality2Mapper.change(id,productionLine,breakpoint,paa,ptr,craft,tools);

   }


}
