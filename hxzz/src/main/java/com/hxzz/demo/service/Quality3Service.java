package com.hxzz.demo.service;

import com.hxzz.demo.entity.Quality3;
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
public interface Quality3Service extends IService<Quality3> {
    Quality3 showMissing();
    Quality3 showIntercept();
    List<Quality3> getMissingData(LocalDate date1, LocalDate date2);
    List<Quality3> getInterceptData(LocalDate date1,LocalDate date2);
    void add(String name,Integer DC,Integer DD,Integer XB,Integer XC);
    void del(Integer id);
    void change(Integer id,String name,Integer DC,Integer DD,Integer XB,Integer XC);
}
