package com.ansel.payroll.mbg.mapper;

import com.ansel.payroll.mbg.model.PyOrderForm;
import com.ansel.payroll.mbg.model.PyOrderFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyOrderFormMapper {
    long countByExample(PyOrderFormExample example);

    int deleteByExample(PyOrderFormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyOrderForm record);

    int insertSelective(PyOrderForm record);

    List<PyOrderForm> selectByExample(PyOrderFormExample example);

    PyOrderForm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyOrderForm record, @Param("example") PyOrderFormExample example);

    int updateByExample(@Param("record") PyOrderForm record, @Param("example") PyOrderFormExample example);

    int updateByPrimaryKeySelective(PyOrderForm record);

    int updateByPrimaryKey(PyOrderForm record);
}