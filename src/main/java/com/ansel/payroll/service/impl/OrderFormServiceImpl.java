/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/6/12$ 上午 10:02$
 */

package com.ansel.payroll.service.impl;

import com.ansel.payroll.mbg.mapper.PyOrderFormMapper;
import com.ansel.payroll.mbg.model.PyOrderForm;
import com.ansel.payroll.mbg.model.PyOrderFormExample;
import com.ansel.payroll.service.OrderFormService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFormServiceImpl implements OrderFormService {

    @Autowired
    PyOrderFormMapper pyOrderFormMapper;

    @Override
    public List<PyOrderForm> listAllOrderForm() {
        PyOrderFormExample ofExample = new PyOrderFormExample();
        ofExample.setOrderByClause("id desc");
        return pyOrderFormMapper.selectByExample(ofExample);
    }

    @Override
    public int creatOrderForm(PyOrderForm pyOrderForm) {
        return pyOrderFormMapper.insertSelective(pyOrderForm);
    }


    @Override
    public int updateOrderForm(Integer id, PyOrderForm pyOrderForm) {
        pyOrderForm.setId(id);
        return pyOrderFormMapper.updateByPrimaryKey(pyOrderForm);
    }

    @Override
    public int deleteOrderForm(Integer id) {
        return pyOrderFormMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PyOrderForm> listOrderForm(int pageNum, int pageSize) {
        PyOrderFormExample ofExample = new PyOrderFormExample();
        ofExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return pyOrderFormMapper.selectByExample(ofExample);
    }
    @Override
    public List<PyOrderForm> OrderFormBySearch(int pageNum, int pageSize,String company,String styleNumber,String styleDescription,int isComplete) {
        PyOrderFormExample ofExample = new PyOrderFormExample();
        PyOrderFormExample.Criteria criteria = ofExample.createCriteria();
        criteria.andCompanyLike("%"+company+"%");
        criteria.andStyleNumberLike("%"+styleNumber+"%");
        criteria.andStyleDescriptionLike("%"+styleDescription+"%");
        if (isComplete!=-1) {
            criteria.andIsCompleteEqualTo(isComplete);
        }
        ofExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return pyOrderFormMapper.selectByExample(ofExample);
    }

    @Override
    public long totalOrderForm() {
        return pyOrderFormMapper.countByExample(new PyOrderFormExample());
    }

    @Override
    public PyOrderForm getOrderForm(Integer id) {
        return pyOrderFormMapper.selectByPrimaryKey(id);
    }
}
