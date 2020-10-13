package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Quality;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzz.demo.entity.Quality3;

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
    List<Quality> show();
    List<Quality> showClient();
    Quality showSum();
    List<Quality> info(LocalDate date1,LocalDate date2);
    List<Quality> infoClient(LocalDate date1,LocalDate date2);
    Quality infoSum(LocalDate date1,LocalDate date2);
    List<Quality> month();
    void add(String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest,LocalDate date);
    void del(Integer id);
    void change(Integer id,String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest,LocalDate date);
    PageInfo<Quality> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);


}
