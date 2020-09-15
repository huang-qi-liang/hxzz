package com.hxzz.demo.service;

import com.hxzz.demo.entity.ScglDC;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzz.demo.entity.ScglSelect;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hql
 * @since 2020-09-14
 */
public interface ScglDCService extends IService<ScglDC> {
    ScglSelect showIN();
    List<ScglDC> getDataIN(LocalDate date1, LocalDate date2);
    void addIN(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat);
    void delIN(LocalDate date);
    void changeIN(Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,Float beat, LocalDate date);
}
