package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.Quality2;
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
public interface Quality2Mapper extends BaseMapper<Quality2> {
    List<Quality2> show();

    List<Quality2> showClient();

    Quality2 showSum();

    List<Quality2> info(LocalDate date1, LocalDate date2);

    List<Quality2> infoClient(LocalDate date1, LocalDate date2);

    Quality2 infoSum(LocalDate date1, LocalDate date2);


    void add(String productionLine, Integer breakpoint, Integer paa, Integer ptr, Integer craft, Integer tools,
             String shift, LocalDate date);

    void del(Integer id);

    void change(Integer id, String productionLine, Integer breakpoint, Integer paa, Integer ptr, Integer craft,
                Integer tools,String shift, LocalDate date);
}
