package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.MonthAim;
import com.hxzz.demo.entity.MonthAim;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hql
 * @since 2020-11-12
 */
public interface MonthAimService extends IService<MonthAim> {
    MonthAim show();

    List<MonthAim> info(LocalDate date1, LocalDate date2);
    MonthAim showClient();

    List<MonthAim> infoClient(LocalDate date1, LocalDate date2);
    MonthAim aimInfo(LocalDate date1, LocalDate date2);
    void add(Integer security, Integer lzcsj, Float quality, Float equipment, LocalDate date);

    void del(Integer id);

    void change(Integer id, Integer security, Integer lzcsj, Float quality, Float equipment, LocalDate date);

    PageInfo<MonthAim> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);
}
