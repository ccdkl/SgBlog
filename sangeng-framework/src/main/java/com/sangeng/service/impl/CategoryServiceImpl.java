package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.constants.SystemConstants;
import com.sangeng.domain.Article;
import com.sangeng.domain.Category;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.vo.CategoryVo;
import com.sangeng.service.ArticleService;
import com.sangeng.service.CategoryService;
import com.sangeng.mapper.CategoryMapper;
import com.sangeng.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {

    @Lazy
    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {

         LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper();




         articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
         List<Article> articleList = articleService.list(articleWrapper);

         Set<Long> categoryIds = articleList.stream()
                .map(article -> article.getCategoryId())
                        .collect(Collectors.toSet());

         List<Category> categories = listByIds(categoryIds);
         categories=categories.stream()
                .filter(category ->
                 SystemConstants.STATUS_NORMAL.equals(category.getStatus())).collect(Collectors.toList());
                        //封装vo
                 List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);

            return ResponseResult.okResult(categoryVos);
    }

}




