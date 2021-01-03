package com.ansel.payroll.mbg.mapper;

import com.ansel.payroll.mbg.model.PyPayroll;
import com.ansel.payroll.mbg.model.PyPayrollExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyPayrollMapper {
    long countByExample(PyPayrollExample example);

    int deleteByExample(PyPayrollExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyPayroll record);

    int insertSelective(PyPayroll record);

    List<PyPayroll> selectByExample(PyPayrollExample example);

    PyPayroll selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyPayroll record, @Param("example") PyPayrollExample example);

    int updateByExample(@Param("record") PyPayroll record, @Param("example") PyPayrollExample example);

    int updateByPrimaryKeySelective(PyPayroll record);

    int updateByPrimaryKey(PyPayroll record);
}