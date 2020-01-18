package com.example.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Create by Administrator on 2019/12/31.
 */
@Repository
public interface UserMapper {
    User select(int id);

    User getUser(@Param(value="username") String username, @Param(value="password") String password);

    int userRegist(User user);

    User getUserByName(@Param(value="username") String username);

    int addUser(User user);
}
