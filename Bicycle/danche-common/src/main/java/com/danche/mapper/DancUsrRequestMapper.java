package com.danche.mapper;

import com.danche.pojo.DancUsrRequest;
import com.danche.pojo.DancUsrRequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DancUsrRequestMapper {
    int countByExample(DancUsrRequestExample example);

    int deleteByExample(DancUsrRequestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DancUsrRequest record);

    int insertSelective(DancUsrRequest record);

    List<DancUsrRequest> selectByExample(DancUsrRequestExample example);

    DancUsrRequest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DancUsrRequest record, @Param("example") DancUsrRequestExample example);

    int updateByExample(@Param("record") DancUsrRequest record, @Param("example") DancUsrRequestExample example);

    int updateByPrimaryKeySelective(DancUsrRequest record);

    int updateByPrimaryKey(DancUsrRequest record);
}