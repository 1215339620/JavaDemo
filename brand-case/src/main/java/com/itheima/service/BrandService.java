package com.itheima.service;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 删除
     * @param brand
     */
    void delete(Brand brand);
    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);

    void deleteById(@Param("Id") int id);
}
