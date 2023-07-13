package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加
     * @param brand
     */
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 删除
//     * @param brand
     */
    void delete(Brand brand);

    @Delete("delete from tb_brand where id = #{Id}")
    void deleteById(@Param("Id") int id);
    /**
     * 批量删除
     * @param ids
     */

    void deleteByIds(@Param("ids") int[] ids);
}
