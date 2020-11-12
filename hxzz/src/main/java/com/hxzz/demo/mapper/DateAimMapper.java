package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.DateAim;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzz.demo.entity.DateAim;
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
public interface DateAimMapper extends BaseMapper<DateAim> {
    DateAim show();

    List<DateAim> info(LocalDate date1, LocalDate date2);
    DateAim showClient();

    DateAim infoClient(LocalDate date1, LocalDate date2);

    void add( Integer lzcsj, LocalDate date);

    void del(Integer id);

    void change(Integer id, Integer lzcsj,  LocalDate date);

}
