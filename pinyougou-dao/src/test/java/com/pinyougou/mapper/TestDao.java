package com.pinyougou.mapper;

import com.pinyougou.pojo.TbBrand;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*.xml")
public class TestDao {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testDao(){
        System.out.println(sqlSessionFactory);
        SqlSession session = sqlSessionFactory.openSession();
        TbBrandMapper brandMapper = session.getMapper(TbBrandMapper.class);
        List<TbBrand> tbBrands = brandMapper.selectByExample(null);
        /*for (int i = 0; i < tbBrands.size(); i++) {
            TbBrand brand = tbBrands.get(i);
            System.out.println(brand);
        }*/
        for (TbBrand brand:tbBrands) {
            System.out.println(brand);
        }
    }
    @Test
    public void testDao2(){
        System.out.println(sqlSessionFactory);
        SqlSession session = sqlSessionFactory.openSession();
        TbSpecificationMapper specificationMapper = session.getMapper(TbSpecificationMapper.class);
        List<Map> maps = specificationMapper.selectOptionList();
        ListIterator<Map> iterator = maps.listIterator();
        while (iterator.hasNext()){
            Map next = iterator.next();
            System.out.println(next);
        }
    }


}
