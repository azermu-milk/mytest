package com.example.mapper;

import com.example.bean.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by Administrator on 2020/4/2.
 */
@Mapper
public interface ArticleMapper {
    List<Article> getArticleByState(int state, int start, int count, int uid, String keywords);

    int getArticleCountByState(int state, Integer uid, String keywords);
}
