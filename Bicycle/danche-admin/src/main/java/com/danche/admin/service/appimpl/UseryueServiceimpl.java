package com.danche.admin.service.appimpl;

import com.danche.admin.service.appservice.OrderService;
import com.danche.admin.service.appservice.UseryueService;
import com.danche.mapper.DancOrderMapper;
import com.danche.mapper.DancUsrMapper;
import com.danche.pojo.DancOrder;
import com.danche.pojo.DancOrderExample;
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
public class UseryueServiceimpl implements UseryueService {

    @Autowired
    private DancUsrMapper dancUsrMapper;

    @Override
    public TaotaoResult  userYue(String username){
        DancUsrExample example = new DancUsrExample();
        DancUsrExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(username);
        List<DancUsr> list = dancUsrMapper.selectByExample(example);
        DancUsr user = list.get(0);
        return TaotaoResult.ok(user.getBalans());
    }

    @Override
    public TaotaoResult user(String username,String qianming,String jiaxiang,String name,String data){
        try {
        DancUsr user =new DancUsr();
        user.setName(name);
        user.setQianming(qianming);
        DancUsrExample example = new DancUsrExample();
        DancUsrExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(username);
        dancUsrMapper.updateByExampleSelective(user,example);
        return TaotaoResult.ok();
        }catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "网络错误,请稍后再试");
        }
    }
}
