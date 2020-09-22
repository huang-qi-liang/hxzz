package com.hxzz.demo.mapper;

import com.hxzz.demo.bean.SgmwSelect;
import com.hxzz.demo.entity.ScglSelect;
import com.hxzz.demo.entity.ScglXD;
import com.hxzz.demo.entity.Sgmw;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hql
 * @since 2020-09-16
 */
@Component
public interface SgmwMapper extends BaseMapper<Sgmw> {
    Sgmw showaim();
    Sgmw showactual();
    void add(String name,Integer safe,Integer production,Integer lzc,Float quality,Integer personnel,Float energyConsumption,Float equipment);
    List<Sgmw> getAimData(LocalDate date1, LocalDate date2);
    List<Sgmw> getActualData(LocalDate date1, LocalDate date2);
    void del(LocalDate date);
    void change(String name,Integer safe,Integer production,Integer lzc,Float quality,Integer personnel,Float energyConsumption,Float equipment);

}
