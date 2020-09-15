package com.hxzz.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzz.demo.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author
 * @since 2020-08-31
 */

public interface UserService extends IService<User> {
    User loginIN(String username, String password);
     /*void addIN(String username, String password);
    List<User> getDataIN(String username);
    void delIN(Long id);
    void changeIN(Long id, String username, String password);*/
}

