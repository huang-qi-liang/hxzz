package com.hxzz.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class SgmwSelect {
    private Integer safe;

    private Integer production;

    private Integer lzc;

    private Float quality;

    private Integer personnel;


    private String energyConsumption;

    private Float equipment;
}
