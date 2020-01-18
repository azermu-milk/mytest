package com.example.service;

import com.example.bean.Category;
import com.example.mapper.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Administrator on 2020/1/2.
 */
@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> list(){
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDao.findAll();
    }

    public Category get(int id){
        Category c = categoryDao.findById(id).orElse(null);
        return c;
    }
}
