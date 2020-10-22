package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.EnvironmentSafe;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hql
 * @since 2020-10-17
 */
public interface EnvironmentSafeService extends IService<EnvironmentSafe> {
    List<EnvironmentSafe> showClient(String date);

    List<EnvironmentSafe> show();

    List<EnvironmentSafe> info(LocalDate date1, LocalDate date2);

    EnvironmentSafe showSum();

    EnvironmentSafe infoSum(LocalDate date1, LocalDate date2);

    List<EnvironmentSafe> amount(LocalDate date1, LocalDate date2);

    void del(Integer id);

    void add(Integer grey, Integer red, Integer black, LocalDate date);

    void change(Integer id, Integer grey, Integer red, Integer black, LocalDate date);

    PageInfo<EnvironmentSafe> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);

}
