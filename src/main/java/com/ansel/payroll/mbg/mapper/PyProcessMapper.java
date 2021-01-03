package com.ansel.payroll.mbg.mapper;

import com.ansel.payroll.mbg.model.PyProcess;
import com.ansel.payroll.mbg.model.PyProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyProcessMapper {
    long countByExample(PyProcessExample example);

    int deleteByExample(PyProcessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyProcess record);

    int insertSelective(PyProcess record);

    List<PyProcess> selectByExample(PyProcessExample example);

    PyProcess selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyProcess record, @Param("example") PyProcessExample example);

    int updateByExample(@Param("record") PyProcess record, @Param("example") PyProcessExample example);

    int updateByPrimaryKeySelective(PyProcess record);

    int updateByPrimaryKey(PyProcess record);
}