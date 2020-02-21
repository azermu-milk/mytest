package com.example.mapper;

import com.example.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> listAll();

    User getUserByName(String username);

    int updateUser(User user);

    User getUserById(int id);

    int deleteUserById(int id);

    int addUser(User user);
}
