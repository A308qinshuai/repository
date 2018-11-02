package com.danche.mapper;

import com.danche.pojo.DancImage;
import com.danche.pojo.DancImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DancImageMapper {
    int countByExample(DancImageExample example);

    int deleteByExample(DancImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DancImage record);

    int insertSelective(DancImage record);

    List<DancImage> selectByExample(DancImageExample example);

    DancImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DancImage record, @Param("example") DancImageExample example);

    int updateByExample(@Param("record") DancImage record, @Param("example") DancImageExample example);

    int updateByPrimaryKeySelective(DancImage record);

    int updateByPrimaryKey(DancImage record);
}