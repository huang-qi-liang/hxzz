package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.entity.Safe;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hql
 * @since 2020-09-27
 */
public interface SafeService extends IService<Safe> {
    List<Safe> showClient(String date);

    List<Safe> show();

    List<Safe> info(LocalDate date1, LocalDate date2);

    Safe showSum();

    Safe infoSum(LocalDate date1, LocalDate date2);

    List<Safe> amount(LocalDate date1, LocalDate date2);

    void del(Integer id);

    void add(Integer grey, Integer blue, Integer yellow, Integer red, LocalDate date);

    void change(Integer id, Integer grey, Integer blue, Integer yellow, Integer red, LocalDate date);

    PageInfo<Safe> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);
}
