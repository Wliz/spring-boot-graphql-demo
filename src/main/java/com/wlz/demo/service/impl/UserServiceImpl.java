package com.wlz.demo.service.impl;

import com.wlz.demo.dao.UserMapper;
import com.wlz.demo.domain.User;
import com.wlz.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wlz
 * @date 9/10/18 16:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAll();
    }

    @Override
    public User createUser(String userName, String phone) {
        User user = new User();
        user.setUsername(userName);
        user.setPhone(phone);
        Long userId = Long.valueOf(userMapper.insert(user));

        return userMapper.findId(userId);
    }

    @Override
    public User updateUser(Long id, String userName, String phone) {
        User user = new User();
        user.setId(id);
        user.setUsername(userName);
        user.setPhone(phone);
        Integer userId = userMapper.updateByPrimaryKeySelective(user);
        return userMapper.findId(Long.valueOf(userId));
    }
}
