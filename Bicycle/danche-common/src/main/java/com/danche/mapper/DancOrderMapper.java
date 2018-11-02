package com.danche.mapper;

import com.danche.pojo.DancOrder;
import com.danche.pojo.DancOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DancOrderMapper {
    int countByExample(DancOrderExample example);

    int deleteByExample(DancOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DancOrder record);

    int insertSelective(DancOrder record);

    List<DancOrder> selectByExample(DancOrderExample example);

    DancOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DancOrder record, @Param("example") DancOrderExample example);

    int updateByExample(@Param("record") DancOrder record, @Param("example") DancOrderExample example);

    int updateByPrimaryKeySelective(DancOrder record);

    int updateByPrimaryKey(DancOrder record);
}