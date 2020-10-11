package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Quality2;
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
public interface Quality2Service extends IService<Quality2> {
    List<Quality2> show();
    List<Quality2> showClient();
    Quality2 showSum();
    List<Quality2> info(LocalDate date1,LocalDate date2);
    List<Quality2> infoClient(LocalDate date1,LocalDate date2);
    Quality2 infoSum(LocalDate date1,LocalDate date2);
    void add(String productionLine,Integer breakpoint,Integer paa,Integer ptr,Integer craft,Integer tools);
    void del(Integer id);
    void change(Integer id,String productionLine,Integer breakpoint,Integer paa,  Integer ptr,Integer craft,Integer tools);
    PageInfo<Quality2> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);

}
