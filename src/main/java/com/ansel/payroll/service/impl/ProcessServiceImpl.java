/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/6/9$ 下午 04:05$
 */

package com.ansel.payroll.service.impl;

import com.ansel.payroll.mbg.mapper.PyProcessMapper;
import com.ansel.payroll.mbg.model.PyProcess;
import com.ansel.payroll.mbg.model.PyProcessExample;
import com.ansel.payroll.service.ProcessService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    PyProcessMapper pyProcessMapper;

    @Override
    public List<PyProcess> listAllProcess() {
        return pyProcessMapper.selectByExample(new PyProcessExample());
    }

    @Override
    public int createProcess(PyProcess pyProcess) {
        return pyProcessMapper.insertSelective(pyProcess);
    }

    @Override
    public int updateProcess(Integer id, PyProcess pyProcess) {
        pyProcess.setId(id);
        return pyProcessMapper.updateByPrimaryKey(pyProcess);
    }

    @Override
    public int deleteProcess(Integer id) {
        return pyProcessMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PyProcess> listProcess(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pyProcessMapper.selectByExample(new PyProcessExample());
    }

    @Override
    public PyProcess getProcess(Integer id) {
        return pyProcessMapper.selectByPrimaryKey(id);
    }
}
