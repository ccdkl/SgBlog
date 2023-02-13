package com.sangeng.Controller;

import com.sangeng.domain.Comment;
import com.sangeng.domain.ResponseResult;
import com.sangeng.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cc
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/commentList")
    public ResponseResult commentList(Long articleId,Integer pageNum,Integer pageSize){
    return commentService.commentList(articleId,pageNum,pageSize);
    }

    public  ResponseResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
}
