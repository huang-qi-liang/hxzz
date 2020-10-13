package com.hxzz.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ScglShow {
    private String name;


    private Integer targetCapacity;


    private Float actualCapacity;


    private Float targetEfficiency;
    private Integer counts;

    private Float actualEfficiency;


    private Float workingHours;


    private Float theoreticalCapacity;

    private Float beat;

    private LocalDate date;
}
