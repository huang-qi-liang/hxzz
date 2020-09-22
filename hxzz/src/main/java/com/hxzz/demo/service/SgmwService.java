package com.hxzz.demo.service;

import com.hxzz.demo.bean.SgmwSelect;
import com.hxzz.demo.entity.Sgmw;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hql
 * @since 2020-09-16
 */
public interface SgmwService extends IService<Sgmw> {
    Sgmw showaimIN();
    Sgmw showactualIN();
    void addIN(String name,Integer safe,Integer production,Integer lzc,Float quality,Integer personnel,Float energyConsumption,Float equipment);
    List<Sgmw> getAimDataIN(LocalDate date1, LocalDate date2);
    List<Sgmw> getActualDataIN(LocalDate date1, LocalDate date2);
    void delIN(LocalDate date);
    void changeIN(String name,Integer safe,Integer production,Integer lzc,Float quality,Integer personnel,Float energyConsumption,Float equipment);

}
