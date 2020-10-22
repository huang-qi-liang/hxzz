package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Quality2;
import com.hxzz.demo.entity.Quality3;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
public interface Quality3Service extends IService<Quality3> {
    List<Quality3> show();

    List<Quality3> showClient();

    List<Quality3> info(LocalDate date1, LocalDate date2);

    List<Quality3> infoClient(LocalDate date1, LocalDate date2);

    void add(String name, Integer DC, Integer DD, Integer XB, Integer XC, LocalDate date);

    void del(Integer id);

    void change(Integer id, String name, Integer DC, Integer DD, Integer XB, Integer XC, LocalDate date);

    PageInfo<Quality3> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);
}
