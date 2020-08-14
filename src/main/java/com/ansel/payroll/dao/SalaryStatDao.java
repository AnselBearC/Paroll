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

import org.apache.ibatis.annotations.Param;

public interface SalaryStatDao {
    /**
     * 获取当月薪资总和
     */
    Float getSalaryTotal(@Param("payDate") String payDate);
}
