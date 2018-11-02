package com.danche.mapper;

import com.danche.pojo.DancBikeOut;
import com.danche.pojo.DancBikeOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DancBikeOutMapper {
    int countByExample(DancBikeOutExample example);

    int deleteByExample(DancBikeOutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DancBikeOut record);

    int insertSelective(DancBikeOut record);

    List<DancBikeOut> selectByExample(DancBikeOutExample example);

    DancBikeOut selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DancBikeOut record, @Param("example") DancBikeOutExample example);

    int updateByExample(@Param("record") DancBikeOut record, @Param("example") DancBikeOutExample example);

    int updateByPrimaryKeySelective(DancBikeOut record);

    int updateByPrimaryKey(DancBikeOut record);
}