package com.hxzz.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzz.demo.entity.User;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Mapper 接口
 * </p>
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    User getInfo(String username, String password);

}
