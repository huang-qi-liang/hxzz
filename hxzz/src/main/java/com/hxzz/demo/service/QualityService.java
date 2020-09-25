package com.hxzz.demo.service;

import com.hxzz.demo.entity.Quality;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
public interface QualityService extends IService<Quality> {
    Quality show(LocalDate date);
    List<Quality> getData(LocalDate date1, LocalDate date2);
    void add(String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest);
    void del(Integer id);
    void change(Integer id,String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest);


}
