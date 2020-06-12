/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/5/27$ 下午 02:42$
 */

package com.ansel.payroll.service;

import com.ansel.payroll.mbg.model.PyStaff;

import java.util.List;

public interface StaffService {

    List<PyStaff> listAllStaff();

    int creatStaff(PyStaff pyStaff);

    int updateStaff(Integer id,PyStaff pyStaff);

    int deleteStaff(Integer id);

    List<PyStaff> listStaff(int pageNum,int pageSize);

    long totalStaff();

    List<PyStaff> staffByName (int pageNum,int pageSize,String name);

    PyStaff getStaff(Integer id);
}
