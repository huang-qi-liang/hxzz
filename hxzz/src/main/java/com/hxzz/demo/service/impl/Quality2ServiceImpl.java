package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.PersonX;
import com.hxzz.demo.entity.Quality2;
import com.hxzz.demo.mapper.Quality2Mapper;
import com.hxzz.demo.service.Quality2Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hql
 * @since 2020-09-24
 */
@Service
public class Quality2ServiceImpl extends ServiceImpl<Quality2Mapper, Quality2> implements Quality2Service {
    @Autowired
    Quality2Mapper quality2Mapper;

    @Override
    public List<Quality2> show() {
        return quality2Mapper.show();
    }

    public List<Quality2> showClient() {
        return quality2Mapper.showClient();
    }

    public Quality2 showSum() {
        return quality2Mapper.showSum();
    }

    public List<Quality2> info(LocalDate date1, LocalDate date2) {
        return quality2Mapper.info(date1, date2);
    }

    public List<Quality2> infoClient(LocalDate date1, LocalDate date2) {
        return quality2Mapper.infoClient(date1, date2);
    }

    public Quality2 infoSum(LocalDate date1, LocalDate date2) {
        return quality2Mapper.infoSum(date1, date2);
    }

    public void add(String productionLine, Integer breakpoint, Integer paa, Integer ptr, Integer craft, Integer tools
            ,String shift, LocalDate date) {
        quality2Mapper.add(productionLine, breakpoint, paa, ptr, craft, tools,shift, date);
    }

    public void del(Integer id) {
        quality2Mapper.del(id);
    }

    public void change(Integer id, String productionLine, Integer breakpoint, Integer paa, Integer ptr, Integer craft,
                       Integer tools,String shift, LocalDate date) {
        quality2Mapper.change(id, productionLine, breakpoint, paa, ptr, craft, tools
                ,shift, date);

    }

    public PageInfo<Quality2> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2) {
        PageHelper.startPage(pageNum, pageSize);
        List<Quality2> list = quality2Mapper.info(date1, date2);
        PageInfo<Quality2> pageInfo = new PageInfo<Quality2>(list);
        return pageInfo;
    }

}
