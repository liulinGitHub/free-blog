package com.blog.core.common.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @ClassName: BaseController
 * @description:
 * @author: 950103
 * @create: 2019-04-27 13:43
 */
public class BaseController {

    private Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>(2);
        rspData.put("records", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    protected Map<String, Object> selectByPageNumSize(QueryRequest request, Supplier<?> s) {
        if (StringUtils.isNotBlank(request.getSortField())) {
            PageHelper.startPage(request.getCurrent(), request.getSize(), request.getSortField() + " " + request.getSortType());
        } else {
            //如果没有传,就直接使用普通的分页(默认排序就写在sql中,不需要pagehelper干涉)
            PageHelper.startPage(request.getCurrent(), request.getSize());
        }
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        PageHelper.clearPage();
        return getDataTable(pageInfo);
    }
}
