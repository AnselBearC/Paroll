/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/6/9$ 下午 03:59$
 */

package com.ansel.payroll.service;

import com.ansel.payroll.mbg.model.PyProcess;

import java.util.List;

public interface ProcessService {
    List<PyProcess> listAllProcess();

    int createProcess(PyProcess pyProcess);

    int updateProcess(Integer id,PyProcess pyProcess);

    int deleteProcess(Integer id);

    List<PyProcess> listProcess(int pageNum, int pageSize);

    PyProcess getProcess(Integer id);
}
