package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.ScglXC;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hql
 * @since 2020-09-14
 */@Component
public interface ScglXCMapper extends BaseMapper<ScglXC> {
    ScglXC show();
    void add(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat);
    List<ScglXC> getData(LocalDate date1, LocalDate date2);
    void del(Integer id);
    void change(Integer id,Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,
                Float beat);
}
