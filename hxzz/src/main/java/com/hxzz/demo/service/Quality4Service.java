package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.entity.Quality4;
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
public interface Quality4Service extends IService<Quality4> {
    Quality4 show();
    List<Quality4> getData(LocalDate date1, LocalDate date2);
    void add(Float target,Float actual,Float responsibility,Float InterceptionProblem,Float quantity);
    void del(Integer id);
    void change(Integer id,Float target,Float actual,Float responsibility,Float InterceptionProblem,Float quantity);

}
