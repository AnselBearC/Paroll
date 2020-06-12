/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/6/12$ 上午 09:59$
 */

package com.ansel.payroll.service;

import com.ansel.payroll.mbg.model.PyOrderForm;

import java.util.List;

public interface OrderFormService {
    List<PyOrderForm> listAllOrderForm();

    int creatOrderForm(PyOrderForm pyOrderForm);

    int updateOrderForm(Integer id,PyOrderForm pyOrderForm);

    int deleteOrderForm(Integer id);

    List<PyOrderForm> listOrderForm(int pageNum,int pageSize);

    long totalOrderForm();


    PyOrderForm getOrderForm(Integer id);
}
