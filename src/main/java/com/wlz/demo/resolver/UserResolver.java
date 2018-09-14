package com.wlz.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.wlz.demo.domain.User;
import com.wlz.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wlz
 * @date 9/10/18 17:35
 */
//@Component implements GraphQLQueryResolver, GraphQLMutationResolver
public class UserResolver {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUsers() {
        return userService.findAllUsers();
    }

//    /**
//     * 创建用户
//     * @param userName
//     * @param phone
//     * @return
//     */
//    User createUser(String userName, String phone) {
//        return userService.createUser(userName, phone);
//    }

    /**
     * 更新用户
     * @param id
     * @param userName
     * @param phone
     * @return
     */
    User updateUser(Long id, String userName, String phone) {
        return userService.updateUser(id, userName, phone);
    }

}
