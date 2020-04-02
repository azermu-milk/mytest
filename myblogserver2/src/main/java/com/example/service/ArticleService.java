package com.example.service;

import com.example.bean.Article;
import com.example.mapper.ArticleMapper;
import com.example.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by Administrator on 2020/4/2.
 */
@Service
@Transactional
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    public List<Article> getArticleByState(int state, int page, int count, String keywords) {
        int uid = Util.getCurrentUser().getId();
        int start = (page - 1) * count;
        return articleMapper.getArticleByState(state, start, count, uid,keywords);
    }

    public int getArticleCountByState(int state, Integer uid, String keywords) {
        return articleMapper.getArticleCountByState(state, uid,keywords);
    }
}
