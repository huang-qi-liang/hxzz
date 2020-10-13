package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.LzcsjShow;
import com.hxzz.demo.bean.LzcsjSum;
import com.hxzz.demo.entity.Lzcsj;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzz.demo.entity.Quality2;

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
public interface LzcsjService extends IService<Lzcsj> {
    List<Lzcsj> show();
    List<Lzcsj> showClient();
    Lzcsj showSum();
    List<Lzcsj> info(LocalDate date1,LocalDate date2);
    List<Lzcsj> infoClient(LocalDate date1,LocalDate date2);
    Lzcsj infoSum(LocalDate date1,LocalDate date2);

    void add(String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
             Integer actualCirculation,LocalDate date);
    void del(Integer id);
    void change(Integer id,String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
                Integer actualCirculation,LocalDate date);
    PageInfo<Lzcsj> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);

}
