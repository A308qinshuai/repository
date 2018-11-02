package com.danche.admin.service.appimpl;

import com.danche.admin.service.appservice.BikeService;
import com.danche.mapper.DancBikeMapper;
import com.danche.mapper.DancOrderMapper;
import com.danche.mapper.DancUsrMapper;
import com.danche.mapper.DancUsrRequestMapper;
import com.danche.pojo.*;
import com.danche.pojogongju.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liuzhen on 2018/3/16.
 */
@Service
public class BikeServiceimpl implements BikeService {

    @Autowired
    private DancBikeMapper dancBikeMapper;
    @Autowired
    private DancOrderMapper dancOrderMapper;
    @Autowired
    private DancUsrMapper dancUsrMapper;

    @Override
    public TaotaoResult  bikeps(String id,String username){
        try {
            DancBikeExample example = new DancBikeExample();
            DancBikeExample.Criteria criteria = example.createCriteria();
            criteria.andBikeidEqualTo(id);
            List<DancBike> list = dancBikeMapper.selectByExample(example);
            if (null == list || list.size() == 0) {
                return TaotaoResult.build(400, "请检查车辆编号");
            }
            DancOrder order = new DancOrder();
            order.setBikeid(id);
            order.setUserid(username);
            Date date = new Date();
            order.setCreated(date);
            dancOrderMapper.insert(order);
            DancBike password = list.get(0);
            List resultList = new ArrayList<>();
            resultList.add(password.getPsword());
            resultList.add(order.getId());
            return TaotaoResult.ok(resultList);
        }catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "网络错误,请稍后再试");
        }
    }

    @Override
    public TaotaoResult  bikedate(Integer id , String user){
        try {
            //根据user查询此用户之前得余额
            DancUsrExample dancUsrExample = new DancUsrExample();
            DancUsrExample.Criteria criteria1 = dancUsrExample.createCriteria();
            criteria1.andUserEqualTo(user);
            List<DancUsr> list =dancUsrMapper.selectByExample(dancUsrExample);
            DancUsr user1 =list.get(0);
            Double balans = Double.parseDouble(user1.getBalans());
            //根据订单查询i的订单之前得创建时间，并更新结束时间单次费用,结束时间，订单状态等
            DancOrder updated = dancOrderMapper.selectByPrimaryKey(id);
            Date created = updated.getCreated();
            Date date = new Date();
            double between =  (created.getTime() - date.getTime())/1000;
            double shijian = between/60;
            double expense=   shijian * 0.02;
            String format = new DecimalFormat("#0.00").format(expense);
            DancOrder dancOrder = new DancOrder();
            dancOrder.setStatus("1");
            dancOrder.setUpdated(date);
            dancOrder.setExpense(format);
            DancOrderExample example = new DancOrderExample();
            DancOrderExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            dancOrderMapper.updateByExampleSelective(dancOrder,example);
            //把user表中余额更新，之前得余额加上此次得订单费用
            Double balans1= balans+expense;
            String balans2 = new DecimalFormat("#0.00").format(balans1);
            DancUsr usr = new DancUsr();
            usr.setBalans(balans2);
            dancUsrMapper.updateByExampleSelective(usr,dancUsrExample);
            return TaotaoResult.ok(format);
        }catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "网络错误,请稍后再试");
        }
    }

    @Override
    public TaotaoResult orderpay(Integer id){
        try {
        DancOrder updated = dancOrderMapper.selectByPrimaryKey(id);
        Date created = updated.getCreated();
        Date date = new Date();
        double between =  (created.getTime() - date.getTime())/1000;
        double shijian = between/60;
        double expense=   shijian * 0.02;
        String format = new DecimalFormat("#0.00").format(expense);
        return TaotaoResult.ok(format);
        }catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "网络错误,请稍后再试");
        }
    }

    @Override
    public TaotaoResult paysucces(Integer id){
        try {
            DancOrder updated = dancOrderMapper.selectByPrimaryKey(id);
            Date created = updated.getCreated();
            Date date = new Date();
            double between =  (created.getTime() - date.getTime())/1000;
            double shijian = between/60;
            double expense=  (shijian * 0.02)-0.04;
            String format = new DecimalFormat("#0.00").format(expense);
            DancOrder dancOrder = new DancOrder();
            dancOrder.setStatus("1");
            dancOrder.setUpdated(date);
            dancOrder.setExpense(format);
            DancOrderExample example = new DancOrderExample();
            DancOrderExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            dancOrderMapper.updateByExampleSelective(dancOrder,example);
            return TaotaoResult.ok();
        }catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "网络错误,请稍后再试");
        }
    }

    @Override
    public TaotaoResult paysucces1(String user){
        DancUsrExample dancUsrExample = new DancUsrExample();
        DancUsrExample.Criteria criteria1 = dancUsrExample.createCriteria();
        criteria1.andUserEqualTo(user);
        DancUsr usr = new DancUsr();
        usr.setBalans("0");
        dancUsrMapper.updateByExampleSelective(usr,dancUsrExample);
        return TaotaoResult.ok();
    }
}
