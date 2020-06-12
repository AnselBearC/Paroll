/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/5/27$ 下午 02:41$
 */

package com.ansel.payroll.service.impl;

import com.ansel.payroll.mbg.mapper.PyStaffMapper;
import com.ansel.payroll.mbg.model.PyStaff;
import com.ansel.payroll.mbg.model.PyStaffExample;
import com.ansel.payroll.service.StaffService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private PyStaffMapper pyStaffMapper;

    @Override
    public List<PyStaff> listAllStaff() {
        return pyStaffMapper.selectByExample(new PyStaffExample());
    }

    @Override
    public int creatStaff(PyStaff pyStaff) {
        return pyStaffMapper.insertSelective(pyStaff);
    }

    @Override
    public int updateStaff(Integer id, PyStaff pyStaff) {
        pyStaff.setId(id);
        return pyStaffMapper.updateByPrimaryKey(pyStaff);
    }

    @Override
    public int deleteStaff(Integer id) {

        return pyStaffMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PyStaff> listStaff(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pyStaffMapper.selectByExample(new PyStaffExample());
    }
    @Override
    public long totalStaff(){
        return pyStaffMapper.countByExample(new PyStaffExample());
    }

    @Override
    public List<PyStaff> staffByName(int pageNum, int pageSize,String name) {
        PyStaffExample psExample = new PyStaffExample();
        PyStaffExample.Criteria criteria = psExample.createCriteria();
        PageHelper.startPage(pageNum,pageSize);
        criteria.andNameLike("%"+name+"%");
        return pyStaffMapper.selectByExample(psExample);
    }

    @Override
    public PyStaff getStaff(Integer id) {
        return pyStaffMapper.selectByPrimaryKey(id);
    }
}
