package com.hxzz.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class LzcsjSum {
    private Integer waitingToBeLoaded;


    private Integer loopToCrossTheLine;


    private Integer bhCirculation;


    private Integer actualCirculation;

    private Integer total;
}
