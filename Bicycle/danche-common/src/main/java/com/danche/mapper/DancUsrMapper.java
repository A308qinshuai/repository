package com.danche.mapper;

import com.danche.pojo.DancUsr;
import com.danche.pojo.DancUsrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DancUsrMapper {
    int countByExample(DancUsrExample example);

    int deleteByExample(DancUsrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DancUsr record);

    int insertSelective(DancUsr record);

    List<DancUsr> selectByExample(DancUsrExample example);

    DancUsr selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DancUsr record, @Param("example") DancUsrExample example);

    int updateByExample(@Param("record") DancUsr record, @Param("example") DancUsrExample example);

    int updateByPrimaryKeySelective(DancUsr record);

    int updateByPrimaryKey(DancUsr record);
}