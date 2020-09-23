package com.hxzz.demo.service.impl;


import com.hxzz.demo.entity.ScglDD;

import com.hxzz.demo.mapper.ScglDDMapper;
import com.hxzz.demo.service.ScglDDService;
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
public class ScglDDServiceImpl extends ServiceImpl<ScglDDMapper, ScglDD> implements ScglDDService {
    @Autowired
    private ScglDDMapper scglDDMapper;
    @Override
    public List<ScglDD> getDataIN(LocalDate date1, LocalDate date2){


        return scglDDMapper.getData(date1,date2);


    }
    @Override
    public ScglDD showIN(){
       return scglDDMapper.show();
    }
    public   void addIN(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat){
        scglDDMapper.add( targetCapacity,  actualCapacity,  targetEfficiency,  workingHours, beat);
    }
    public  void delIN(Integer id){
        scglDDMapper.del(id);
    }
    public void changeIN(Integer id,Integer targetCapacity, Float actualCapacity, Float targetEfficiency,
                         Float workingHours,
                         Float beat){
        scglDDMapper.change(id, targetCapacity,  actualCapacity,  targetEfficiency,  workingHours, beat);
    }
}
