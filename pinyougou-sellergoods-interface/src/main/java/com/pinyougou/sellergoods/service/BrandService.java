package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * 品牌服务层接口
 */
public interface BrandService {
    /**
     * 返回全部列表
     *
     * @return 返回全部列表
     */
    List<TbBrand> findAll();

    String test2();

    PageResult findPage(int pageNum, int pageSize);
}
