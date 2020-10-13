package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.entity.Quality3;
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
public interface Quality3Mapper extends BaseMapper<Quality3> {
    List<Quality3> show();
    List<Quality3> showClient();

    List<Quality3> info(LocalDate date1,LocalDate date2);
    List<Quality3> infoClient(LocalDate date1,LocalDate date2);

void add(String name,Integer DC,Integer DD,Integer XB,Integer XC,LocalDate date);
void del(Integer id);
void change(Integer id,String name,Integer DC,Integer DD,Integer XB,Integer XC,LocalDate date);
}
