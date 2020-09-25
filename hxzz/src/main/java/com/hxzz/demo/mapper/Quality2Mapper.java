package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.Quality2;
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
public interface Quality2Mapper extends BaseMapper<Quality2> {
Quality2 showA();
    Quality2 showB();
    Quality2 showC();
    Quality2 showD();
List<Quality2> getDataA(LocalDate date1,LocalDate date2);
    List<Quality2> getDataB(LocalDate date1,LocalDate date2);
    List<Quality2> getDataC(LocalDate date1,LocalDate date2);
    List<Quality2> getDataD(LocalDate date1,LocalDate date2);
void add(String productionLine,Integer breakpoint,Integer paa,Integer ptr,Integer craft,Integer tools);
void del(Integer id);
void change(Integer id,String productionLine,Integer breakpoint,Integer paa,  Integer ptr,Integer craft,Integer tools);
}
