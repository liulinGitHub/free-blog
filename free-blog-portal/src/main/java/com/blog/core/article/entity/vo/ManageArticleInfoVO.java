package com.blog.core.article.entity.vo;

import com.blog.core.articlecategory.entity.vo.PortalCategoryVO;
import com.blog.core.system.user.entity.vo.PortalUserVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: free-blog
 * @description: 查看文章信息返回对象
 * @author: liulin
 * @create: 2019-05-04 15:15
 */
@Data
public class ManageArticleInfoVO {

    @ApiModelProperty(name = "文章信息" )
    private ManageArticleVO articleVO;

    @ApiModelProperty(name = "文章分类信息" )
    private PortalCategoryVO portalCategoryVO;

    @ApiModelProperty(name = "文章作者用户信息" )
    private PortalUserVO portalUserVO;
}
