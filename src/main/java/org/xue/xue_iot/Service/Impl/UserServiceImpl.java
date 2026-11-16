package org.xue.xue_iot.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xue.xue_iot.Mapper.UserMapper;
import org.xue.xue_iot.Service.UserService;
import org.xue.xue_iot.pojo.User;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void register(String username, String password, String email) {
        userMapper.register(username, password, email);
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }
}
