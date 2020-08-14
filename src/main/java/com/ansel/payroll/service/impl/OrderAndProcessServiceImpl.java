/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/6/30$ 下午 03:04$
 */

package com.ansel.payroll.service.impl;

import com.ansel.payroll.dao.OrderAndProcessDao;
import com.ansel.payroll.mbg.mapper.PyOrderProcessRelationMapper;
import com.ansel.payroll.mbg.model.PyOrderProcessRelation;
import com.ansel.payroll.mbg.model.PyOrderProcessRelationExample;
import com.ansel.payroll.service.OrderAndProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAndProcessServiceImpl implements OrderAndProcessService {

    @Autowired
    private PyOrderProcessRelationMapper pyOrderProcessRelationMapper;

    @Autowired
    private OrderAndProcessDao orderAndProcessDao;

    //根据订单id来查询工序列表
    @Override
    public List<PyOrderProcessRelation> listOrderProcessRelation(Integer orderId) {

        return orderAndProcessDao.getOpRelationList(orderId);
    }

    @Override
    public int creatOrderProcessRelation(PyOrderProcessRelation pyOrderProcessRelation) {
        return pyOrderProcessRelationMapper.insertSelective(pyOrderProcessRelation);
    }

    @Override
    public int updateOrderProcessRelation(Integer id, PyOrderProcessRelation pyOrderProcessRelation) {
        pyOrderProcessRelation.setId(id);
        return pyOrderProcessRelationMapper.updateByPrimaryKey(pyOrderProcessRelation);
    }

    @Override
    public int deleteOrderProcessRelation(Integer id) {
        return pyOrderProcessRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteOrderProcessRelationByOrderId(Integer orderId){
        PyOrderProcessRelationExample prExample = new PyOrderProcessRelationExample();
        PyOrderProcessRelationExample.Criteria criteria = prExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return pyOrderProcessRelationMapper.deleteByExample(prExample);
    }
}
