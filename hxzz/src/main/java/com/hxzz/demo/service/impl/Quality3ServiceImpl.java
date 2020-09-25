package com.hxzz.demo.service.impl;

import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.mapper.Quality3Mapper;
import com.hxzz.demo.service.Quality3Service;
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
public class Quality3ServiceImpl extends ServiceImpl<Quality3Mapper, Quality3> implements Quality3Service {
    @Autowired
    Quality3Mapper quality3Mapper;
 public    Quality3 showMissing(){return quality3Mapper.showMissing();}
  public   Quality3 showIntercept(){return quality3Mapper.showIntercept();}
  public   List<Quality3> getMissingData(LocalDate date1, LocalDate date2){return quality3Mapper.getMissingData(date1
          ,date2);}
  public   List<Quality3> getInterceptData(LocalDate date1,LocalDate date2){return quality3Mapper.getInterceptData(date1,date2);}
  public   void add(String name,Integer DC,Integer DD,Integer XB,Integer XC){quality3Mapper.add(name, DC, DD, XB, XC);}
   public void del(Integer id){quality3Mapper.del(id);}
   public void change(Integer id,String name,Integer DC,Integer DD,Integer XB,Integer XC){quality3Mapper.change(id, name, DC, DD, XB, XC);}
}
