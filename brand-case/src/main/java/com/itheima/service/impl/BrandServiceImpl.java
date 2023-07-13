package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Brand> selectAll() {
        //调用BrandMapper。selectAll()

        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取Brandmapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取Brandmapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.add(brand);
        //5.提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
    }

    @Override
    public void delete(Brand brand) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取Brandmapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.delete(brand);
        //5.提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取Brandmapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.deleteByIds(ids);
        //5.提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
    }

    @Override
    public void deleteById(int id) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取Brandmapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
