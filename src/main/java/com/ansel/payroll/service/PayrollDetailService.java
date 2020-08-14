/**
 * 功能描述: <br>
 * 〈工资单详情service$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/7/14$ 下午 03:36$
 */
package com.ansel.payroll.service;

import com.ansel.payroll.mbg.model.PyPayrollDetail;

import java.util.List;

public interface PayrollDetailService {

    int createPayrollDetail(PyPayrollDetail pyPayrollDetail) ;

    int updatePayrollDetail(Integer id,PyPayrollDetail pyPayrollDetail);

    int deletePayrollDetail(Integer payrollId);

    List<PyPayrollDetail> listPayrollDetail(Integer payrollId);
}
