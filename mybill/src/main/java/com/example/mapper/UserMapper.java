package com.example.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> listAll();

    User getUserByName(@Param(value = "username") String username);
}
