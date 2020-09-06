package com.blog.core.category.dao;

import com.blog.core.category.vo.PortalCategoryVO;
import com.blog.core.common.enums.CategoryTypeEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: PortalCategoryMapper
 * @description: 分类Mapper
 * @author: 950103
 * @create: 2019-10-09 17:16
 * @Version: 1.0
 */
@Repository("portalCategoryMapper")
public interface PortalCategoryMapper {

    /**
     * 根据分类类型查询分类
     *
     * @param categoryTypeEnum
     * @return
     */
    List<PortalCategoryVO> selectCategoryByCategoryType(@Param("categoryTypeEnum") CategoryTypeEnum categoryTypeEnum);

    /**
     * 根据文章id查询所属分类
     *
     * @param articleId
     * @return
     */
    List<PortalCategoryVO> selectCategoryByArticleId(Integer articleId);
}
