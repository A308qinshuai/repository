package com.danche.mapper;

import com.danche.pojo.DancAdminUsr;
import com.danche.pojo.DancAdminUsrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DancAdminUsrMapper {
    int countByExample(DancAdminUsrExample example);

    int deleteByExample(DancAdminUsrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DancAdminUsr record);

    int insertSelective(DancAdminUsr record);

    List<DancAdminUsr> selectByExample(DancAdminUsrExample example);

    DancAdminUsr selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DancAdminUsr record, @Param("example") DancAdminUsrExample example);

    int updateByExample(@Param("record") DancAdminUsr record, @Param("example") DancAdminUsrExample example);

    int updateByPrimaryKeySelective(DancAdminUsr record);

    int updateByPrimaryKey(DancAdminUsr record);
}