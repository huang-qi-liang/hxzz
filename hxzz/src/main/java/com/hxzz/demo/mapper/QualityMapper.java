package com.hxzz.demo.mapper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hxzz.demo.entity.Quality;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzz.demo.entity.Quality;
import com.hxzz.demo.entity.Quality;
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
    List<Quality> show();
    List<Quality> showClient();
    Quality showSum();
    List<Quality> info(LocalDate date1,LocalDate date2);
    List<Quality> infoClient(LocalDate date1,LocalDate date2);
    Quality infoSum(LocalDate date1,LocalDate date2);
    List<Quality> month();
void add(String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest);
void del(Integer id);
void change(Integer id,String name,Float offLine,Float dLine,Float lingYu,Float careLine,Float roadTest);


}
