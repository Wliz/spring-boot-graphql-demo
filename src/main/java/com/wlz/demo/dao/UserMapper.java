package com.wlz.demo.dao;

import com.wlz.demo.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findId(Long id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 保存选择的用户（指定id）
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据主键更新用户
     * @param user
     * @return
     */
    int updateByPrimaryKeySelective(User user);
}
