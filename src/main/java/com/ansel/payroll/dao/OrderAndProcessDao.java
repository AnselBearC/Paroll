/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/7/3$ 下午 03:35$
 */
package com.ansel.payroll.dao;

import com.ansel.payroll.mbg.model.PyOrderProcessRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderAndProcessDao {
    /**
     * 获取订单工序表及名称
     */
    List<PyOrderProcessRelation> getOpRelationList(@Param("orderId") Integer orderId);
}
