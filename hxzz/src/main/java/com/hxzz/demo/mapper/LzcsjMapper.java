package com.hxzz.demo.mapper;

import com.hxzz.demo.bean.LzcsjShow;
import com.hxzz.demo.bean.LzcsjSum;
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
List<Lzcsj> showMan();

List<LzcsjShow> getData(LocalDate date1,LocalDate date2);
   LzcsjSum Sum(LocalDate date);
   List<Lzcsj> getDataMan(LocalDate date1,LocalDate date2);
   List<LzcsjShow> SumData(LocalDate date1,LocalDate date2);
   /* Integer waitingToBeLoadedSum(LocalDate date);
    Integer loopToCrossTheLineSum(LocalDate date);
    Integer bhCirculationSum(LocalDate date);
    Integer actualCirculationSum(LocalDate date);
    Integer totalSum(LocalDate date);

    */
void add(String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
         Integer actualCirculation);
void del(Integer id);
void change(Integer id,String name,Integer waitingToBeLoaded,Integer loopToCrossTheLine,Integer bhCirculation,
            Integer actualCirculation);
}
