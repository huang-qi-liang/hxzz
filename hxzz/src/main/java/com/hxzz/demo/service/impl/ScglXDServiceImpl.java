package com.hxzz.demo.service.impl;


import com.hxzz.demo.entity.ScglXD;

import com.hxzz.demo.mapper.ScglXDMapper;
import com.hxzz.demo.service.ScglXDService;
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
 * @since 2020-09-14
 */
@Service
public class ScglXDServiceImpl extends ServiceImpl<ScglXDMapper, ScglXD> implements ScglXDService {
    @Autowired
    private ScglXDMapper scglXDMapper;
    @Override
    public List<ScglXD> getDataIN(LocalDate date1, LocalDate date2){


        return scglXDMapper.getData(date1,date2);


    }
    public ScglXD showIN(){
        return scglXDMapper.show();
    }
    public   void addIN(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat){
        scglXDMapper.add( targetCapacity,  actualCapacity,  targetEfficiency,  workingHours, beat);
    }
    public  void delIN(Integer id){
        scglXDMapper.del(id);
    }
    public void changeIN(Integer id,Integer targetCapacity, Float actualCapacity, Float targetEfficiency,
                         Float workingHours,
                         Float beat){
        scglXDMapper.change(id, targetCapacity,  actualCapacity,  targetEfficiency,  workingHours, beat);
    }
}
