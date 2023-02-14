package com.sangeng.service;

import com.sangeng.domain.entity.Link;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;

/**
* @author cc
* @description 针对表【sg_link(友链)】的数据库操作Service
* @createDate 2023-01-29 11:33:42
*/
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}
