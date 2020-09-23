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
 * @since 2020-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PersonX")
public class PersonX implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String region;

    @TableField("personalLeave")
    private Integer personalLeave;

    @TableField("sickLeave")
    private Integer sickLeave;

    @TableField("annualLeave")
    private Integer annualLeave;

    @TableField("nursingLeave")
    private Integer nursingLeave;

    @TableField("bereavementLeave")
    private Integer bereavementLeave;

    private Integer total;

    private LocalDate date;


}
