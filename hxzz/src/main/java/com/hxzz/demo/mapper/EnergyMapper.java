package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.Energy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzz.demo.entity.Energy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
@Component
public interface EnergyMapper extends BaseMapper<Energy> {
    List<Energy> show();

    Energy showClient();

    Energy showSum();

    Energy infoSum(LocalDate date1, LocalDate date2);

    List<Energy> info(LocalDate date1, LocalDate date2);

    Energy infoClient(LocalDate date1, LocalDate date2);

    void add(String name, Float standardsWater, Float water, Float standardsElectricity, Float electricity,
             Float standardsGas, Float gas, LocalDate date);

    void del(Integer id);

    void change(Integer id, String name, Float standardsWater, Float water, Float standardsElectricity, Float electricity,
                Float standardsGas, Float gas, LocalDate date);

}
