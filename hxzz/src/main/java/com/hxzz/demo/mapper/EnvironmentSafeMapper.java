package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.EnvironmentSafe;
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
 * @since 2020-10-17
 */
@Component
public interface EnvironmentSafeMapper extends BaseMapper<EnvironmentSafe> {
    List<EnvironmentSafe> showClient(String date);

    List<EnvironmentSafe> show();

    List<EnvironmentSafe> info(LocalDate date1, LocalDate date2);

    EnvironmentSafe showSum();

    EnvironmentSafe infoSum(LocalDate date1, LocalDate date2);

    List<EnvironmentSafe> amount(LocalDate date1, LocalDate date2);

    void del(Integer id);

    void add(Integer grey, Integer red, Integer black, LocalDate date);

    void change(Integer id, Integer grey, Integer red, Integer black, LocalDate date);
}
