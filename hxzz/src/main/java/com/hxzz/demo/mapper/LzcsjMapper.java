package com.hxzz.demo.mapper;

import com.hxzz.demo.bean.LzcsjShow;
import com.hxzz.demo.bean.LzcsjSum;
import com.hxzz.demo.bean.PersonDShow;
import com.hxzz.demo.entity.Lzcsj;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzz.demo.entity.PersonD;
import com.hxzz.demo.entity.Lzcsj;
import com.hxzz.demo.entity.Safe;
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
public interface LzcsjMapper extends BaseMapper<Lzcsj> {
    List<Lzcsj> show();

    List<Lzcsj> showClient();

    Lzcsj showSum();

    List<Lzcsj> info(LocalDate date1, LocalDate date2);
    List<Lzcsj> infoShift(String name,LocalDate date1, LocalDate date2);

    List<Lzcsj> infoClient(LocalDate date1, LocalDate date2);


    Lzcsj infoSum(LocalDate date1, LocalDate date2);

    List<Lzcsj> amount(LocalDate date1, LocalDate date2);

    /* Integer waitingToBeLoadedSum(LocalDate date);
     Integer loopToCrossTheLineSum(LocalDate date);
     Integer bhCirculationSum(LocalDate date);
     Integer actualCirculationSum(LocalDate date);
     Integer totalSum(LocalDate date);

     */
    void add(String name, Integer waitingToBeLoaded, Integer loopToCrossTheLine, Integer bhCirculation,
             Integer actualCirculation, LocalDate date);

    void del(Integer id);

    void change(Integer id, String name, Integer waitingToBeLoaded, Integer loopToCrossTheLine, Integer bhCirculation,
                Integer actualCirculation, LocalDate date);
}
