package com.example.mapper;

import com.example.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Create by Administrator on 2020/3/31.
 */
@Mapper
public interface RolesMapper {

    int addRoles(@Param("roles") String[] roles, @Param("uid") Long uid);

    List<Role> getRolesByUid(int uid);

}
