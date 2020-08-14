/**
 * 功能描述: <br>
 * 〈工资详情单service实现类$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/7/14$ 下午 03:53$
 */

package com.ansel.payroll.service.impl;

import com.ansel.payroll.mbg.mapper.PyPayrollDetailMapper;
import com.ansel.payroll.mbg.model.PyPayrollDetail;
import com.ansel.payroll.mbg.model.PyPayrollDetailExample;
import com.ansel.payroll.service.PayrollDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollDetailServiceImpl implements PayrollDetailService {

    @Autowired
    PyPayrollDetailMapper pyPayrollDetailMapper;

    @Override
    public int createPayrollDetail(PyPayrollDetail pyPayrollDetail) {
        return pyPayrollDetailMapper.insertSelective(pyPayrollDetail);
    }

    @Override
    public int updatePayrollDetail(Integer id, PyPayrollDetail pyPayrollDetail) {
        pyPayrollDetail.setId(id);
        return pyPayrollDetailMapper.updateByPrimaryKey(pyPayrollDetail);
    }

    @Override
    public int deletePayrollDetail(Integer payrollId) {
        PyPayrollDetailExample ppdExample = new PyPayrollDetailExample();
        PyPayrollDetailExample.Criteria criteria = ppdExample.createCriteria();
        criteria.andPayrollIdEqualTo(payrollId);
        return pyPayrollDetailMapper.deleteByExample(ppdExample);

    }

    @Override
    public List<PyPayrollDetail> listPayrollDetail(Integer payrollId) {
        PyPayrollDetailExample ppdExample = new PyPayrollDetailExample();
        PyPayrollDetailExample.Criteria criteria = ppdExample.createCriteria();
        criteria.andPayrollIdEqualTo(payrollId);
        return pyPayrollDetailMapper.selectByExample(ppdExample);
    }


}
