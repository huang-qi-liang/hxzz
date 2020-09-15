package com.hxzz.demo.service.impl;
import com.hxzz.demo.entity.ScglSelect;
import com.hxzz.demo.entity.ScglXC;
import com.hxzz.demo.mapper.ScglXCMapper;
import com.hxzz.demo.service.ScglXCService;
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
public class ScglXCServiceImpl extends ServiceImpl<ScglXCMapper, ScglXC> implements ScglXCService {
    @Autowired
    private ScglXCMapper scglXCMapper;
    @Override
    public List<ScglXC> getDataIN(LocalDate date1, LocalDate date2){


        return scglXCMapper.getData(date1,date2);


    }
    public ScglSelect showIN(){
        return scglXCMapper.show();
    }
    public   void addIN(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat){
        scglXCMapper.add( targetCapacity,  actualCapacity,  targetEfficiency,  workingHours, beat);
    }
    public  void delIN(LocalDate date){
        scglXCMapper.del(date);
    }
    public void changeIN(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat, LocalDate date){
        scglXCMapper.change( targetCapacity,  actualCapacity,  targetEfficiency,  workingHours, beat,  date);
    }
}
