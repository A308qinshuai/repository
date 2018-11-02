package com.danche.mapper;

import com.danche.pojo.DancBike;
import com.danche.pojo.DancBikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DancBikeMapper {
    int countByExample(DancBikeExample example);

    int deleteByExample(DancBikeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DancBike record);

    int insertSelective(DancBike record);

    List<DancBike> selectByExample(DancBikeExample example);

    DancBike selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DancBike record, @Param("example") DancBikeExample example);

    int updateByExample(@Param("record") DancBike record, @Param("example") DancBikeExample example);

    int updateByPrimaryKeySelective(DancBike record);

    int updateByPrimaryKey(DancBike record);
}