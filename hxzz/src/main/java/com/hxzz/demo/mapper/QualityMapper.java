package com.hxzz.demo.mapper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hxzz.demo.entity.Quality;
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
public interface QualityMapper extends BaseMapper<Quality> {
Quality show(LocalDate date);
List<Quality> getData(LocalDate date1,LocalDate date2);
void add(String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest);
void del(Integer id);
void change(Integer id,String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest);


}
