package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.DateAim;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzz.demo.entity.DateAim;

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
public interface DateAimService extends IService<DateAim> {
    DateAim show();

    List<DateAim> info(LocalDate date1, LocalDate date2);
    DateAim showClient();

    DateAim infoClient(LocalDate date1, LocalDate date2);

    void add(Integer lzcsj, LocalDate date);

    void del(Integer id);

    void change(Integer id,  Integer lzcsj,  LocalDate date);

    PageInfo<DateAim> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);

}
