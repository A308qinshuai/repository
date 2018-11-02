package com.danche.mapper;

import com.danche.pojo.DancVnumber;
import com.danche.pojo.DancVnumberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DancVnumberMapper {
    int countByExample(DancVnumberExample example);

    int deleteByExample(DancVnumberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DancVnumber record);

    int insertSelective(DancVnumber record);

    List<DancVnumber> selectByExample(DancVnumberExample example);

    DancVnumber selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DancVnumber record, @Param("example") DancVnumberExample example);

    int updateByExample(@Param("record") DancVnumber record, @Param("example") DancVnumberExample example);

    int updateByPrimaryKeySelective(DancVnumber record);

    int updateByPrimaryKey(DancVnumber record);
}