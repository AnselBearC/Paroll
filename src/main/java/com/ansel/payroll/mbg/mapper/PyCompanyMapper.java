package com.ansel.payroll.mbg.mapper;

import com.ansel.payroll.mbg.model.PyCompany;
import com.ansel.payroll.mbg.model.PyCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyCompanyMapper {
    long countByExample(PyCompanyExample example);

    int deleteByExample(PyCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyCompany record);

    int insertSelective(PyCompany record);

    List<PyCompany> selectByExample(PyCompanyExample example);

    PyCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyCompany record, @Param("example") PyCompanyExample example);

    int updateByExample(@Param("record") PyCompany record, @Param("example") PyCompanyExample example);

    int updateByPrimaryKeySelective(PyCompany record);

    int updateByPrimaryKey(PyCompany record);
}