package com.example.mapper;

import com.example.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Create by Administrator on 2019/12/26.
 */
@Repository
public interface UserMapper {
    User sele(int id);
}
