package com.hxzz.demo.mapper;

import com.hxzz.demo.bean.ScglShow;
import com.hxzz.demo.entity.Scgl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hql
 * @since 2020-10-12
 */
@Component
public interface ScglMapper extends BaseMapper<Scgl> {
    List<Scgl> show();

    List<ScglShow> showClient();

    ScglShow showSum();

    List<Scgl> info(LocalDate date1, LocalDate date2);

    List<ScglShow> infoClient(LocalDate date1, LocalDate date2);

    ScglShow infoSum(LocalDate date1, LocalDate date2);

    void add(String name, Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,
             Float beat, LocalDate date);

    void del(Integer id);

    void change(Integer id, String name, Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,
                Float beat, LocalDate date);
}
