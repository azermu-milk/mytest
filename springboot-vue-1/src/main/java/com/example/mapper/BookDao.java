package com.example.mapper;

import com.example.bean.Book;
import com.example.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create by Administrator on 2020/1/2.
 */
public interface BookDao extends JpaRepository<Book, Integer> {
    List<Book>  findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
