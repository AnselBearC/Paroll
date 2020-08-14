/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/8/4$ 上午 10:37$
 */

package com.ansel.payroll.service.impl;

import com.ansel.payroll.mbg.mapper.PyCompanyMapper;
import com.ansel.payroll.mbg.model.PyCompany;
import com.ansel.payroll.mbg.model.PyCompanyExample;
import com.ansel.payroll.service.CompanyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    PyCompanyMapper pyCompanyMapper;

    @Override
    public List<PyCompany> listAllCompany() {
        return pyCompanyMapper.selectByExample(new PyCompanyExample());
    }

    @Override
    public int createCompany(PyCompany pyCompany) {
        return pyCompanyMapper.insertSelective(pyCompany);
    }

    @Override
    public int updateCompany(Integer id, PyCompany pyCompany) {
        pyCompany.setId(id);
        pyCompany.setCreateTime(null);
        return pyCompanyMapper.updateByPrimaryKey(pyCompany);
    }

    @Override
    public int deleteCompany(Integer id) {
        return pyCompanyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PyCompany> listCompany(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pyCompanyMapper.selectByExample(new PyCompanyExample());
    }
}
