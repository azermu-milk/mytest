package com.example.mapper;

import com.example.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by Administrator on 2020/1/2.
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {
}
