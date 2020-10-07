package com.hxzz.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonDShow {
    private String region;


    private Integer personalLeave;


    private Integer sickLeave;


    private Integer annualLeave;


    private Integer nursingLeave;


    private Integer bereavementLeave;

    private Integer total;

    private LocalDate date;
}
