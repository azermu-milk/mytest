package com.example.controller.admin;

import com.example.bean.Article;
import com.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by Administrator on 2020/4/2.
 */
@RestController
public class ArticleAdminController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/article/all")
    public Map<String, Object> getArticleByStateByAdmin(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "count", defaultValue = "6") int count, String keywords){
        List<Article> articles = articleService.getArticleByState(-2, page, count, keywords);

        Map map = new HashMap();

        map.put("articles", articles);
        map.put("totalCount", articleService.getArticleCountByState(1, null, keywords));

        return map;
    }
}
