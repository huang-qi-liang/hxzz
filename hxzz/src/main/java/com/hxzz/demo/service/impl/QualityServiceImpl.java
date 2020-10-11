package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.entity.Quality3;
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
    public  List<Quality> show(){return qualityMapper.show();}
    public List<Quality> showClient(){return  qualityMapper.showClient();}
    public Quality showSum(){return  qualityMapper.showSum();}
    public List<Quality> info(LocalDate date1,LocalDate date2){return  qualityMapper.info(date1,date2);}
    public List<Quality> infoClient(LocalDate date1,LocalDate date2){return qualityMapper.infoClient(date1,date2);}
    public Quality infoSum(LocalDate date1,LocalDate date2){return  qualityMapper.infoSum(date1,date2);}
  public   void add(String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest){
        qualityMapper.add( name, offLine, dLine, lingYu, careLine, roadTest);

  }
   public List<Quality> month(){return  qualityMapper.month();}
   public void del(Integer id){
        qualityMapper.del(id);
   }
  public   void change(Integer id,String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest){
        qualityMapper.change( id, name, offLine, dLine, lingYu, careLine, roadTest);
  }
    public PageInfo<Quality> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2){
        PageHelper.startPage(pageNum,pageSize);
        List<Quality> list=qualityMapper.info(date1,date2);
        PageInfo<Quality> pageInfo=new PageInfo<Quality>(list);
        return pageInfo;
    }

}
