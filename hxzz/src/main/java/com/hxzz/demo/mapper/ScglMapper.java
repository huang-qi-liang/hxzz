package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.Scgl;
import com.hxzz.demo.entity.Scgl;
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
 * @since 2020-10-12
 */
@Component
public interface ScglMapper extends BaseMapper<Scgl> {
    List<Scgl> show();
    List<Scgl> showClient();
    Scgl showSum();
    List<Scgl> info(LocalDate date1, LocalDate date2);
    List<Scgl> infoClient(LocalDate date1,LocalDate date2);
    Scgl infoSum(LocalDate date1,LocalDate date2);
    void add(String name,Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,
             Float beat);
    void del(Integer id);
    void change(Integer id,String name,Integer targetCapacity, Float actualCapacity, Float targetEfficiency, Float workingHours,
                Float beat);
}
