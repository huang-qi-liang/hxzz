package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.LzcsjShow;
import com.hxzz.demo.bean.LzcsjSum;
import com.hxzz.demo.entity.Lzcsj;
import com.hxzz.demo.entity.Lzcsj;
import com.hxzz.demo.entity.Quality2;
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
    public  List<Lzcsj> show(){return lzcsjMapper.show();}
    public List<Lzcsj> showClient(){return  lzcsjMapper.showClient();}
    public Lzcsj showSum(){return  lzcsjMapper.showSum();}
    public List<Lzcsj> info(LocalDate date1,LocalDate date2){return  lzcsjMapper.info(date1,date2);}
    public List<Lzcsj> infoClient(LocalDate date1,LocalDate date2){return lzcsjMapper.infoClient(date1,date2);}
    public Lzcsj infoSum(LocalDate date1,LocalDate date2){return  lzcsjMapper.infoSum(date1,date2);}
    public    void add(String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
             Integer actualCirculation){lzcsjMapper.add(name, waitingToBeLoaded, loopToCrossTheLine, bhCirculation, actualCirculation);}
   public void del(Integer id){lzcsjMapper.del(id);}
   public void change(Integer id,String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
                Integer actualCirculation){lzcsjMapper.change(id, name, waitingToBeLoaded, loopToCrossTheLine, bhCirculation, actualCirculation);}
    public PageInfo<Lzcsj> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2){
        PageHelper.startPage(pageNum,pageSize);
        List<Lzcsj> list=lzcsjMapper.info(date1,date2);
        PageInfo<Lzcsj> pageInfo=new PageInfo<Lzcsj>(list);
        return pageInfo;
    }


}
