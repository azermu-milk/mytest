package com.example.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Create by Administrator on 2019/12/30.
 */
@Repository
public interface UserMapper {
    User select(int id);

    User userLogin(@Param(value="username") String username, @Param(value="password") String password);

    int userRegist(User user);

}
