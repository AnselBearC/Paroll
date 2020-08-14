/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/8/13$ 上午 09:14$
 */

package com.ansel.payroll;

import com.ansel.payroll.service.PayrollService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SalaryTotalTest extends DemoApplicationTests {

    @Autowired
    private PayrollService payrollService;

    @Test
    public void testGetSalaryTotal() {
        float salary = payrollService.totalSalary("2020年08月");
        System.out.println("获取到的总薪资为:"+salary);
    }

}
