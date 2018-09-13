package com.wlz.demo.service;

import com.wlz.demo.domain.User;
import java.util.List;

/**
 * 用户service
 * @author wlz
 * @date 9/10/18 15:51
 */
public interface UserService extends BaseService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 创建用户
     * @param userName
     * @param phone
     * @return
     */
    User createUser(String userName, String phone);

    /**
     * 更新用户
     * @param id
     * @param userName
     * @param phone
     * @return
     */
    User updateUser(Long id, String userName, String phone);
}
