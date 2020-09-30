package com.hxzz.demo.service;

import com.hxzz.demo.entity.Lzcsj;
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
public interface LzcsjService extends IService<Lzcsj> {
   List<Lzcsj> show(LocalDate date);
    List<Lzcsj> getData(LocalDate date1, LocalDate date2);
    void add(String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
             Integer actualCirculation);
    void del(Integer id);
    void change(Integer id,String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
                Integer actualCirculation);

}
