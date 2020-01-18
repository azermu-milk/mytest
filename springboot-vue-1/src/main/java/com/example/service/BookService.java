package com.example.service;

import com.example.bean.Book;
import com.example.bean.Category;
import com.example.mapper.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Administrator on 2020/1/2.
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryService categoryService;

    public List<Book> list(){
        return bookDao.findAll();
    }

    public void addOrUpdate(Book book){
        bookDao.save(book);
    }

    public void deleteById(int id){
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int cid){
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }
}
