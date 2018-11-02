package com.danche.mapper;

import com.danche.pojo.DancUsrBack;
import com.danche.pojo.DancUsrBackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DancUsrBackMapper {
    int countByExample(DancUsrBackExample example);

    int deleteByExample(DancUsrBackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DancUsrBack record);

    int insertSelective(DancUsrBack record);

    List<DancUsrBack> selectByExample(DancUsrBackExample example);

    DancUsrBack selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DancUsrBack record, @Param("example") DancUsrBackExample example);

    int updateByExample(@Param("record") DancUsrBack record, @Param("example") DancUsrBackExample example);

    int updateByPrimaryKeySelective(DancUsrBack record);

    int updateByPrimaryKey(DancUsrBack record);
}