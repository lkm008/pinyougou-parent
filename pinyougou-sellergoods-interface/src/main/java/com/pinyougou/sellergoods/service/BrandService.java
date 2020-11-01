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

    public void add(TbBrand brand);

    /**
     * 修改
     */
    public void update(TbBrand brand);
    /**
     * 根据 ID 获取实体
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);
    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long [] ids);
}
