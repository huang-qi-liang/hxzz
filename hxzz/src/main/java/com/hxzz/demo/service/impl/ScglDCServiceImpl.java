package com.hxzz.demo.service.impl;

import com.hxzz.demo.entity.ScglDC;
import com.hxzz.demo.entity.ScglSelect;
import com.hxzz.demo.mapper.ScglDCMapper;
import com.hxzz.demo.service.ScglDCService;
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
public class ScglDCServiceImpl extends ServiceImpl<ScglDCMapper, ScglDC> implements ScglDCService {
@Autowired
    private ScglDCMapper scglDCMapper;
@Override
public  List<ScglDC> getDataIN(LocalDate date1, LocalDate date2){


    return scglDCMapper.getData(date1,date2);


    }
    public ScglDC showIN(){
    return scglDCMapper.show();
    }
  public   void addIN(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat){
    scglDCMapper.add( targetCapacity,  actualCapacity,  targetEfficiency,  workingHours, beat);
    }
    public  void delIN(LocalDate date){
    scglDCMapper.del(date);
    }
    public void changeIN(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat, LocalDate date){
    scglDCMapper.change( targetCapacity,  actualCapacity,  targetEfficiency,  workingHours, beat,  date);
    }
}
