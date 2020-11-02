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
    /**
     * 返回分页列表
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

	/**
	 * 增加
	*/
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

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
    public PageResult findPage(TbBrand brand, int pageNum,int pageSize);
}
