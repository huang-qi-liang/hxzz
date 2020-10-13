package com.hxzz.demo.service.impl;

import com.hxzz.demo.entity.Quality4;
import com.hxzz.demo.mapper.Quality4Mapper;
import com.hxzz.demo.service.Quality4Service;
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
public class Quality4ServiceImpl extends ServiceImpl<Quality4Mapper, Quality4> implements Quality4Service {
    @Autowired
    Quality4Mapper quality4Mapper;
    @Override
  public   Quality4 show(){return quality4Mapper.show();}
   public List<Quality4> getData(LocalDate date1, LocalDate date2){return quality4Mapper.getData(date1,date2);}
   public void add(Float target,Float actual,Float responsibility,Float InterceptionProblem,Float quantity,LocalDate date){
        quality4Mapper.add(target, actual, responsibility, InterceptionProblem, quantity,date);
   }
   public void del(Integer id){quality4Mapper.del(id);}
   public void change(Integer id,Float target,Float actual,Float responsibility,Float InterceptionProblem,
                      Float quantity,LocalDate date){
        quality4Mapper.change(id, target, actual, responsibility, InterceptionProblem, quantity,date);
   }
}
