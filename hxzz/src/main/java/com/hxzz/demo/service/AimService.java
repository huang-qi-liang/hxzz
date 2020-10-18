package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Aim;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzz.demo.entity.Energy;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hql
 * @since 2020-10-14
 */
public interface AimService extends IService<Aim> {
    Aim show();

    List<Aim> info(LocalDate date1, LocalDate date2);
    void add(Integer security,Integer lzcsj,Float quality,Float equipment,LocalDate date);
    void del(Long id);
    void change( Long id,Integer security,Integer lzcsj,Float quality,Float equipment,LocalDate date);
    PageInfo<Aim> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);
}
