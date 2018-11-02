package com.danche.admin.service.appimpl;

import com.danche.admin.service.appservice.OrderService;
import com.danche.mapper.DancOrderMapper;
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
public class OrderServiceimpl implements OrderService {

    @Autowired
    private DancOrderMapper dancOrderMapper;

    @Override
    public TaotaoResult  userOrder(String username){
        DancOrderExample example1 = new DancOrderExample();
        example1.setOrderByClause("`id` DESC LIMIT 8");//没设置条数。
        //example1.setOrderByClause("`id` DESC LIMIT" +num); 可设定查询几条
        DancOrderExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andUseridEqualTo(username);
        List<DancOrder> list = dancOrderMapper.selectByExample(example1);
        /*DancOrder user = list.get(0);
        List resultList = new ArrayList<>();
        resultList.add(user);
        resultList.add(user);*/
        return TaotaoResult.ok(list);
    }
}
