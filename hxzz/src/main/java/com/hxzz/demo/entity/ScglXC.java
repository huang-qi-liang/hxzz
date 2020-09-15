package com.hxzz.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hql
 * @since 2020-09-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ScglXC")
public class ScglXC implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("targetCapacity")
    private Integer targetCapacity;

    @TableField("actualCapacity")
    private Float actualCapacity;

    @TableField("targetEfficiency")
    private Float targetEfficiency;

    @TableField("actualEfficiency")
    private Float actualEfficiency;

    @TableField("workingHours")
    private Float workingHours;

    @TableField("theoreticalCapacity")
    private Float theoreticalCapacity;

    private Float beat;

    private LocalDate date;


}
