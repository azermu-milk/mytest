package com.example.mapper;

import com.example.bean.AdminUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create by Administrator on 2020/1/17.
 */
public interface AdminUserRoleDAO extends JpaRepository<AdminUserRole, Integer> {
    List<AdminUserRole> findAllByUid(int uid);
    void deleteAllByUid(int uid);
}
