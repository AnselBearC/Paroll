/**
 * 功能描述: <br>
 * 〈工资单service的实现类$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/7/13$ 下午 05:05$
 */

package com.ansel.payroll.service.impl;

import com.ansel.payroll.dao.SalaryStatDao;
import com.ansel.payroll.mbg.mapper.PyPayrollMapper;
import com.ansel.payroll.mbg.model.PyPayroll;
import com.ansel.payroll.mbg.model.PyPayrollExample;
import com.ansel.payroll.service.PayrollService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    PyPayrollMapper pyPayrollMapper;
    @Autowired
    SalaryStatDao salaryStatDao;

    @Override
    public List<PyPayroll> listAllPayroll() {
        return pyPayrollMapper.selectByExample(new PyPayrollExample());
    }

    @Override
    public int createPayroll(PyPayroll pyPayroll) {
        return pyPayrollMapper.insertSelective(pyPayroll);
    }

    @Override
    public int updatePayroll(Integer id,PyPayroll pyPayroll) {
        pyPayroll.setId(id);
        pyPayroll.setCreateTime(null);
        return pyPayrollMapper.updateByPrimaryKey(pyPayroll);
    }

    @Override
    public int deletePayroll(Integer id) {
        return pyPayrollMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PyPayroll> listPayroll(int pageNum, int pageSize,String payDate) {
        if (payDate.length()==0) {
            PageHelper.startPage(pageNum, pageSize);
            return pyPayrollMapper.selectByExample(new PyPayrollExample());
        }else {
            PyPayrollExample ppExa = new PyPayrollExample();
            PyPayrollExample.Criteria criteria = ppExa.createCriteria();
            criteria.andPayDateEqualTo(payDate);
            PageHelper.startPage(pageNum, pageSize);
            return pyPayrollMapper.selectByExample(ppExa);
        }
    }

    @Override
    public Float totalSalary(String payDate) {
        return salaryStatDao.getSalaryTotal(payDate);
    }

    @Override
    public PyPayroll getPayroll(Integer id) {
        return pyPayrollMapper.selectByPrimaryKey(id);
    }
}
