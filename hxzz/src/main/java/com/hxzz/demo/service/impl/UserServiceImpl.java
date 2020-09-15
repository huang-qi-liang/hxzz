package com.hxzz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzz.demo.entity.User;
import com.hxzz.demo.mapper.UserMapper;
import com.hxzz.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-08-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
@Autowired
private UserMapper userMapper;
    @Override
    public User loginIN(String username, String password) {
        return userMapper.getInfo(username,password);
    }
  /* @Override

   public void addIN(String username,String password) {
        userMapper.add(username,password);
    }
    @Override
    public List<User>  getDataIN(String username){
        return  userMapper.getData(username);
    }
    @Override
    public void delIN(Long id){
          userMapper.del(id);

    }
@Override
    public  void  changeIN(Long id,String username,String password){
          userMapper.change(id,username,password);
}
*/


}
