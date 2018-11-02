package com.danche.mapper;

import com.danche.pojo.DancPayment;
import com.danche.pojo.DancPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DancPaymentMapper {
    int countByExample(DancPaymentExample example);

    int deleteByExample(DancPaymentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DancPayment record);

    int insertSelective(DancPayment record);

    List<DancPayment> selectByExample(DancPaymentExample example);

    DancPayment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DancPayment record, @Param("example") DancPaymentExample example);

    int updateByExample(@Param("record") DancPayment record, @Param("example") DancPaymentExample example);

    int updateByPrimaryKeySelective(DancPayment record);

    int updateByPrimaryKey(DancPayment record);
}