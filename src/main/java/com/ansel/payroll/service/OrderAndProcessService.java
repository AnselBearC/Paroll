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
package com.ansel.payroll.service;

import com.ansel.payroll.mbg.model.PyOrderProcessRelation;

import java.util.List;

public interface OrderAndProcessService {

    List<PyOrderProcessRelation> listOrderProcessRelation(Integer orderId);

    int creatOrderProcessRelation(PyOrderProcessRelation pyOrderProcessRelation);

    int updateOrderProcessRelation(Integer id,PyOrderProcessRelation pyOrderProcessRelation);

    int deleteOrderProcessRelation(Integer id);
}
