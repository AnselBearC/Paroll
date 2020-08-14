/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/8/4$ 上午 10:16$
 */
package com.ansel.payroll.service;

import com.ansel.payroll.mbg.model.PyCompany;

import java.util.List;

public interface CompanyService {
    List<PyCompany> listAllCompany();

    int createCompany(PyCompany pyCompany);

    int updateCompany(Integer id ,PyCompany pyCompany);

    int deleteCompany(Integer id);

    List<PyCompany> listCompany(int pageNum, int pageSize);
}
