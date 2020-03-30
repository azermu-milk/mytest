package com.example.mapper;

import com.example.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    User findUserById(int id);

    List<User> listAllUser();
}
