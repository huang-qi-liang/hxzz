package com.hxzz.demo.service.impl;

import com.hxzz.demo.bean.LzcsjShow;
import com.hxzz.demo.bean.LzcsjSum;
import com.hxzz.demo.entity.Lzcsj;
import com.hxzz.demo.mapper.LzcsjMapper;
import com.hxzz.demo.service.LzcsjService;
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
public class LzcsjServiceImpl extends ServiceImpl<LzcsjMapper, Lzcsj> implements LzcsjService {
    @Autowired
    LzcsjMapper lzcsjMapper;
   public List<Lzcsj> show(LocalDate date){return lzcsjMapper.show(date);}
   public List<Lzcsj> showMan(){return lzcsjMapper.showMan();}
   public List<LzcsjShow> getData(LocalDate date1, LocalDate date2){return lzcsjMapper.getData(date1,date2);}
   public List<Lzcsj> getDataMan(LocalDate date1,LocalDate date2){return lzcsjMapper.getDataMan(date1,date2);}
    public List<LzcsjShow> SumData(LocalDate date1,LocalDate date2){return lzcsjMapper.SumData(date1,date2);}
    public LzcsjSum Sum(LocalDate date){return lzcsjMapper.Sum(date);}
    public    void add(String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
             Integer actualCirculation){lzcsjMapper.add(name, waitingToBeLoaded, loopToCrossTheLine, bhCirculation, actualCirculation);}
   public void del(Integer id){lzcsjMapper.del(id);}
   public void change(Integer id,String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
                Integer actualCirculation){lzcsjMapper.change(id, name, waitingToBeLoaded, loopToCrossTheLine, bhCirculation, actualCirculation);}

}
