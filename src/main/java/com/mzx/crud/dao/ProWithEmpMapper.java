package com.mzx.crud.dao;

import com.mzx.crud.bean.ProWithEmpExample;
import com.mzx.crud.bean.ProWithEmpKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProWithEmpMapper {
    long countByExample(ProWithEmpExample example);

    int deleteByExample(ProWithEmpExample example);

    int deleteByPrimaryKey(ProWithEmpKey key);

    int insert(ProWithEmpKey record);

    int insertSelective(ProWithEmpKey record);

    List<ProWithEmpKey> selectByExample(ProWithEmpExample example);

    int updateByExampleSelective(@Param("record") ProWithEmpKey record, @Param("example") ProWithEmpExample example);

    int updateByExample(@Param("record") ProWithEmpKey record, @Param("example") ProWithEmpExample example);
}