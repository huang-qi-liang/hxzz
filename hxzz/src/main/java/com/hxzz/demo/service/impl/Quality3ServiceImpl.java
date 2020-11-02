package com.hxzz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzz.demo.entity.Quality2;
import com.hxzz.demo.entity.Quality3;
import com.hxzz.demo.mapper.Quality3Mapper;
import com.hxzz.demo.service.Quality3Service;
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
public class Quality3ServiceImpl extends ServiceImpl<Quality3Mapper, Quality3> implements Quality3Service {
    @Autowired
    Quality3Mapper quality3Mapper;

    public List<Quality3> show() {
        return quality3Mapper.show();
    }

    public List<Quality3> showClient() {
        return quality3Mapper.showClient();
    }

    public List<Quality3> info(LocalDate date1, LocalDate date2) {
        return quality3Mapper.info(date1, date2);
    }

    public List<Quality3> infoClient(LocalDate date1, LocalDate date2) {
        return quality3Mapper.infoClient(date1, date2);
    }

    public void add(String name, Integer DC, Integer DD, Integer XB, Integer XC,String shift, LocalDate date) {
        quality3Mapper.add(name,
                DC, DD, XB, XC,shift, date);
    }

    public void del(Integer id) {
        quality3Mapper.del(id);
    }

    public void change(Integer id, String name, Integer DC, Integer DD, Integer XB, Integer XC,String shift,
                       LocalDate date) {
        quality3Mapper.change(id, name, DC, DD, XB, XC, shift,date);
    }

    public PageInfo<Quality3> findAll(Integer pageNum, Integer pageSize, LocalDate date1, LocalDate date2) {
        PageHelper.startPage(pageNum, pageSize);
        List<Quality3> list = quality3Mapper.info(date1, date2);
        PageInfo<Quality3> pageInfo = new PageInfo<Quality3>(list);
        return pageInfo;
    }

}
