package com.konvi.service.Impl;

import com.konvi.entity.Salaries;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 工资表ServiceImpl测试类
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SalariesServiceImplTest
{
    @Autowired
    private SalariesServiceImpl salariesService;

    @Test
    public void findById()
    {
        Salaries salaries = salariesService.findById("1");
        Assert.assertNotEquals("1",salaries.getEmpId());
    }

    @Test
    public void findAll()
    {
        PageRequest request = PageRequest.of(1,2);
        Page<Salaries> salariesPage = salariesService.findAll(request);
        Assert.assertNotEquals(0,salariesPage.getTotalElements());
    }

    @Test
    public void create()
    {

    }

    @Test
    public void deleteById()
    {
        salariesService.deleteById("2");
    }
}