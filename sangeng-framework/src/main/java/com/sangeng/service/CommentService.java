package com.sangeng.service;

import com.sangeng.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;

/**
* @author cc
* @description 针对表【sg_comment(评论表)】的数据库操作Service
* @createDate 2023-02-06 09:46:43
*/
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}
