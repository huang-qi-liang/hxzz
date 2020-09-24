package com.hxzz.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Lzcsj")
public class Lzcsj implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    @TableField("waitingToBeLoaded")
    private Integer waitingToBeLoaded;

    @TableField("loopToCrossTheLine")
    private Integer loopToCrossTheLine;

    @TableField("bhCirculation")
    private Integer bhCirculation;

    @TableField("actualCirculation")
    private Integer actualCirculation;

    private Integer total;


}
