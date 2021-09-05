package com.lll.DAO;

import com.lll.entity.Salaries;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * 工资表DAO层 测试类
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ISalariesDAOTest
{
    @Autowired
    private ISalariesDAO salariesDAO;

    /**
     * 新增员工工资
     */
    @Test
    public void saveTest()
    {
        Salaries salaries = new Salaries();
        salaries.setEmpId("1");
        salaries.setEmpName("程辉");
        salaries.setSalBase(new BigDecimal(10000));
        salaries.setSalBonus(new BigDecimal(5000));
        salaries.setSalBonusDescribes("年终奖");
        salaries.setSalFine(new BigDecimal(0));
        salaries.setSalFineDescribes("无");
        salaries.setSalBenefits(new BigDecimal(2000));
        salaries.setSalFinal(new BigDecimal(17000));
        salaries.setSalRemarks("暂无");

        Salaries salariesSave = salariesDAO.save(salaries);
        Assert.assertNotNull(salariesSave);
    }

}