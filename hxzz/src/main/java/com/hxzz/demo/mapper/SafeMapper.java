package com.hxzz.demo.mapper;

import com.hxzz.demo.entity.Safe;
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
 * @since 2020-09-27
 */
@Component
public interface SafeMapper extends BaseMapper<Safe> {
Safe show();
List<Safe> info(LocalDate daye1,LocalDate date2);
void del(Integer id);
void add(Integer green,Integer grey,Integer blue,Integer yellow,Integer red,LocalDate date);
void change(Integer id,Integer green,Integer grey,Integer blue,Integer yellow,Integer red,LocalDate date);
}
