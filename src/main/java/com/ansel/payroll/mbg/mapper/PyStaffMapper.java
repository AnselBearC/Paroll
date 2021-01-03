package com.ansel.payroll.mbg.mapper;

import com.ansel.payroll.mbg.model.PyStaff;
import com.ansel.payroll.mbg.model.PyStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyStaffMapper {
    long countByExample(PyStaffExample example);

    int deleteByExample(PyStaffExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyStaff record);

    int insertSelective(PyStaff record);

    List<PyStaff> selectByExample(PyStaffExample example);

    PyStaff selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyStaff record, @Param("example") PyStaffExample example);

    int updateByExample(@Param("record") PyStaff record, @Param("example") PyStaffExample example);

    int updateByPrimaryKeySelective(PyStaff record);

    int updateByPrimaryKey(PyStaff record);
}