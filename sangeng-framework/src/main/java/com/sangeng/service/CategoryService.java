package com.sangeng.service;

import com.sangeng.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;

/**
 *
 */
public interface CategoryService extends IService<Category> {

     ResponseResult getCategoryList();
}

