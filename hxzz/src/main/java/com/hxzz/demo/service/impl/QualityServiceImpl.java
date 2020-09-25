package com.hxzz.demo.service.impl;

import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.mapper.QualityMapper;
import com.hxzz.demo.service.QualityService;
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
public class QualityServiceImpl extends ServiceImpl<QualityMapper, Quality> implements QualityService {
    @Autowired
    QualityMapper qualityMapper;
    @Override
  public   Quality show(LocalDate date){return qualityMapper.show(date);}
  public   List<Quality> getData(LocalDate date1, LocalDate date2){return qualityMapper.getData(date1,date2);}
  public   void add(String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest){
        qualityMapper.add( name, offLine, dLine, lingYu, careLine, roadTest);
  }
   public void del(Integer id){
        qualityMapper.del(id);
   }
  public   void change(Integer id,String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest){
        qualityMapper.change( id, name, offLine, dLine, lingYu, careLine, roadTest);
  }

}
