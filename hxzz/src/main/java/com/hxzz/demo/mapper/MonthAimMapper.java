package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.MonthAim;
import com.hxzz.demo.entity.MonthAim;
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
 * @since 2020-11-12
 */
@Component
public interface MonthAimMapper extends BaseMapper<MonthAim> {
    MonthAim show();

    List<MonthAim> info(LocalDate date1, LocalDate date2);
    MonthAim showClient();

    List<MonthAim> infoClient(LocalDate date1, LocalDate date2);
    MonthAim aimInfo(LocalDate date1, LocalDate date2);
    void add(Integer security, Integer lzcsj, Float quality, Float equipment, LocalDate date);

    void del(Integer id);

    void change(Integer id, Integer security, Integer lzcsj, Float quality, Float equipment, LocalDate date);
}
