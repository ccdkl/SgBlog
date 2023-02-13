package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.constants.SystemConstants;
import com.sangeng.domain.Article;
import com.sangeng.domain.Link;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.vo.LinkVo;
import com.sangeng.service.LinkService;
import com.sangeng.mapper.LinkMapper;
import com.sangeng.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sangeng.constants.SystemConstants.LINK_STATUS_NORMAL;

/**
* @author cc
* @description 针对表【sg_link(友链)】的数据库操作Service实现
* @createDate 2023-01-29 11:33:42
*/
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link>
    implements LinkService{

    @Override
    public ResponseResult getAllLink() {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper();
        //查询所有审核通过的
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        //转换成vo
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links,LinkVo.class);
        //返回
      return ResponseResult.okResult(linkVos);
    }
}




