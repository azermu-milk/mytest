package com.example.mapper;

import com.example.bean.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by Administrator on 2020/1/17.
 */
public interface AdminRoleDAO extends JpaRepository<AdminRole, Integer> {
    AdminRole findById(int id);
}
