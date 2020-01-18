package com.example.mapper;

import com.example.bean.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create by Administrator on 2020/1/17.
 */
public interface AdminMenuDAO extends JpaRepository<AdminMenu, Integer> {
    AdminMenu findById(int id);
    List<AdminMenu> findAllByParentId(int parentId);
}
