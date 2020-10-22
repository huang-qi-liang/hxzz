package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.Quality4;
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
 * @since 2020-09-24
 */
@Component
public interface Quality4Mapper extends BaseMapper<Quality4> {
    Quality4 show();

    List<Quality4> getData(LocalDate date1, LocalDate date2);

    void add(Float target, Float actual, Float responsibility, Float InterceptionProblem, Float quantity, LocalDate date);

    void del(Integer id);

    void change(Integer id, Float target, Float actual, Float responsibility, Float InterceptionProblem, Float quantity, LocalDate date);


}
