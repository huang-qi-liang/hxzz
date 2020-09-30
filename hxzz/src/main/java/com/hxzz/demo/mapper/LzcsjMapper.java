package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.Lzcsj;
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
 * @since 2020-09-24
 */
@Component
public interface LzcsjMapper extends BaseMapper<Lzcsj> {
List<Lzcsj> show(LocalDate date);
List<Lzcsj> getData(LocalDate date1,LocalDate date2);
void add(String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
         Integer actualCirculation);
void del(Integer id);
void change(Integer id,String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
            Integer actualCirculation);
}
