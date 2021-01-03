package com.ansel.payroll.mbg.mapper;

import com.ansel.payroll.mbg.model.PyOrderProcessRelation;
import com.ansel.payroll.mbg.model.PyOrderProcessRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyOrderProcessRelationMapper {
    long countByExample(PyOrderProcessRelationExample example);

    int deleteByExample(PyOrderProcessRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PyOrderProcessRelation record);

    int insertSelective(PyOrderProcessRelation record);

    List<PyOrderProcessRelation> selectByExample(PyOrderProcessRelationExample example);

    PyOrderProcessRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PyOrderProcessRelation record, @Param("example") PyOrderProcessRelationExample example);

    int updateByExample(@Param("record") PyOrderProcessRelation record, @Param("example") PyOrderProcessRelationExample example);

    int updateByPrimaryKeySelective(PyOrderProcessRelation record);

    int updateByPrimaryKey(PyOrderProcessRelation record);
}