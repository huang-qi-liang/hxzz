package com.hxzz.demo.service;

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
    Quality2 showA();
    Quality2 showB();
    Quality2 showC();
    Quality2 showD();
    List<Quality2> getDataA(LocalDate date1, LocalDate date2);
    List<Quality2> getDataB(LocalDate date1,LocalDate date2);
    List<Quality2> getDataC(LocalDate date1,LocalDate date2);
    List<Quality2> getDataD(LocalDate date1,LocalDate date2);
    void add(String productionLine,Integer breakpoint,Integer paa,Integer ptr,Integer craft,Integer tools);
    void del(Integer id);
    void change(Integer id,String productionLine,Integer breakpoint,Integer paa,  Integer ptr,Integer craft,Integer tools);


}
