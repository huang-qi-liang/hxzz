package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.entity.Scgl;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hql
 * @since 2020-10-12
 */
public interface ScglService extends IService<Scgl> {
    List<Scgl> show();
    List<Scgl> showClient();
    Scgl showSum();
    List<Scgl> info(LocalDate date1, LocalDate date2);
    List<Scgl> infoClient(LocalDate date1,LocalDate date2);
    Scgl infoSum(LocalDate date1,LocalDate date2);
    void add(String name,Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,
             Float beat);
    void del(Integer id);
    void change(Integer id,String name,Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,
                Float beat);
    PageInfo<Scgl> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);

}