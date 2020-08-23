package com.blog.core.category.dao;

import com.blog.core.category.dto.ManageCategoryIdDTO;
import com.blog.core.category.entity.ManageCategory;
import com.blog.core.category.vo.ManageCategoryVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: ManageCategoryMapper
 * @description:
 * @author: 950103
 * @create: 2019-11-22 17:55
 * @Version: 1.0
 */
@Repository("manageCategoryMapper")
public interface ManageCategoryMapper {

    /**
     * 分页查询文章分类信息
     *
     * @return
     */
    List<ManageCategoryVO> selectManageCategoryByPage();

    /**
     * 根据文章分类id查询
     *
     * @param categoryId
     * @return
     */
    ManageCategoryVO selectManageCategoryByCategoryId(String categoryId);

    /**
     * 添加文章分类信息
     *
     * @param manageCategory
     */
    void insertManageCategory(ManageCategory manageCategory);

    /**
     * 修改文章分类信息
     *
     * @param manageCategory
     */
    void updateManageCategory(ManageCategory manageCategory);

    /**
     * @Author ll
     * @Description 启用分类信息
     * @Date 2020/2/9 21:42
     * @Param [list]
     * @return void
     **/
    void enableManageCategoryByCategoryId(List<String> list);

    /**
     * @Author ll
     * @Description 停用分类信息
     * @Date 2020/2/9 21:42
     * @Param [list]
     * @return void
     **/
    void disableManageCategoryByCategoryId(List<String> list);
}
