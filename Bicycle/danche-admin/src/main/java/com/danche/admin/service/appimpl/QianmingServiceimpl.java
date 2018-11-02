package com.danche.admin.service.appimpl;

import com.danche.admin.service.appservice.QianmingService;
import com.danche.mapper.DancUsrMapper;
import com.danche.pojo.DancUsr;
import com.danche.pojo.DancUsrExample;
import com.danche.pojogongju.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhen on 2018/3/16.
 */
@Service
public class QianmingServiceimpl implements QianmingService {

    @Autowired
    private DancUsrMapper dancUsrMapper;

    @Override
    public TaotaoResult  qianming(String username){
        DancUsrExample example = new DancUsrExample();
        DancUsrExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(username);
        List<DancUsr> list = dancUsrMapper.selectByExample(example);
        DancUsr user = list.get(0);
        List resultList = new ArrayList<>();
        resultList.add(user.getName());
        resultList.add(user.getQianming());
        return TaotaoResult.ok(resultList);
    }
}
