package com.hxzz.demo.service;

import com.github.pagehelper.PageInfo;
import com.hxzz.demo.bean.View;
import com.hxzz.demo.entity.Quality;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzz.demo.entity.Quality3;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
public interface QualityService extends IService<Quality> {
    List<Quality> show();

    List<Quality> showClient();

    Quality showSum();

    List<Quality> info(LocalDate date1, LocalDate date2);

    List<Quality> infoClient(LocalDate date1, LocalDate date2);

    Quality infoSum(LocalDate date1, LocalDate date2);

    List<Quality> month();
    List<View> each(Integer date, String name);

    View eachYear(Integer date, String name);

    List<View> total(Integer date);

    View totalYear(Integer date);

    void del(Integer id);

    void add(String name, Float offLine, Float acoffLine, Float dLine, Float acdLine, Float lingYu, Float aclingYu,
             Float careLine, Float accareLine, Float roadTest, Float acroadTest,String shift,
             LocalDate date);

    void change(Integer id, String name, Float offLine, Float acoffLine, Float dLine, Float acdLine, Float lingYu, Float aclingYu,
                Float careLine, Float accareLine, Float roadTest, Float acroadTest,String shift,
                LocalDate date);

    PageInfo<Quality> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2);


}
