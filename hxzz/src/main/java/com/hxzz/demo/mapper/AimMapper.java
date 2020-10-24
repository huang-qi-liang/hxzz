package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.Aim;
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
 * @since 2020-10-14
 */
@Component
public interface AimMapper extends BaseMapper<Aim> {

    Aim show();

    List<Aim> info(LocalDate date1, LocalDate date2);
    Aim showClient();

    List<Aim> infoClient(LocalDate date1, LocalDate date2);

    void add(Integer security, Integer lzcsj, Float quality, Float equipment, LocalDate date);

    void del(Long id);

    void change(Long id, Integer security, Integer lzcsj, Float quality, Float equipment, LocalDate date);

}
