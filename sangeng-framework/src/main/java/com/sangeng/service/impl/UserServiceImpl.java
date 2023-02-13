package com.sangeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.domain.User;
import com.sangeng.service.UserService;
import com.sangeng.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author cc
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2023-02-06 11:56:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




