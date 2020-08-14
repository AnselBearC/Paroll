/**
 * 功能描述: <br>
 * 〈工资单$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/7/13$ 下午 04:52$
 */
package com.ansel.payroll.service;

import com.ansel.payroll.mbg.model.PyPayroll;

import java.util.List;

public interface PayrollService {
    List<PyPayroll> listAllPayroll();

    int createPayroll(PyPayroll pyPayroll);

    int updatePayroll(Integer id,PyPayroll pyPayroll);

    int deletePayroll(Integer id);

    List<PyPayroll> listPayroll(int pageNum, int pageSize,String payDate);

    Float totalSalary(String payDate);

    PyPayroll getPayroll (Integer id);
}
