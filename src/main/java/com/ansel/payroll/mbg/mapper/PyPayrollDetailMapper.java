package com.ansel.payroll.mbg.mapper;

import com.ansel.payroll.mbg.model.PyPayrollDetail;
import com.ansel.payroll.mbg.model.PyPayrollDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyPayrollDetailMapper {
    long countByExample(PyPayrollDetailExample example);

    int deleteByExample(PyPayrollDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyPayrollDetail record);

    int insertSelective(PyPayrollDetail record);

    List<PyPayrollDetail> selectByExample(PyPayrollDetailExample example);

    PyPayrollDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyPayrollDetail record, @Param("example") PyPayrollDetailExample example);

    int updateByExample(@Param("record") PyPayrollDetail record, @Param("example") PyPayrollDetailExample example);

    int updateByPrimaryKeySelective(PyPayrollDetail record);

    int updateByPrimaryKey(PyPayrollDetail record);
}