package com.danche.admin.service.impl;


import com.danche.mapper.DancBikeMapper;
import com.danche.mapper.DancOrderMapper;
import com.danche.mapper.DancUsrMapper;
import com.danche.mapper.DancUsrRequestMapper;
import com.danche.pojo.*;
import com.danche.pojogongju.EUDataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by liuzhen on 2018/3/14.
 */
@Service
public class AdminOrderService implements com.danche.admin.service.AdminOrderService {

    @Autowired
    private DancOrderMapper dancOrderMapper;
    @Autowired
    private DancBikeMapper dancBikeMapper;
    @Autowired
    private DancUsrMapper dancUsrMapper;
    @Autowired
    private DancUsrRequestMapper dancUsrRequestMapper;

    @Override
    public EUDataGridResult getItemList(int page) {
        //查询商品列表
        DancOrderExample example = new DancOrderExample();
        //分页处理
        PageHelper.startPage(page,50);
        List<DancOrder> list = dancOrderMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DancOrder> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult getOutList(int page) {
        //查询商品列表
        DancOrderExample example = new DancOrderExample();
        DancOrderExample.Criteria criteria = example.createCriteria();
        criteria.andExpenseLessThan("-10.00");
        //分页处理
        PageHelper.startPage(page,50);
        List<DancOrder> list = dancOrderMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DancOrder> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult getBikeList(int page) {
        //查询商品列表
        DancBikeExample example = new DancBikeExample();
        PageHelper.startPage(page,50);
        List<DancBike> list = dancBikeMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DancBike> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    //用户列表显示
    @Override
    public EUDataGridResult getUserList(int page){
        DancUsrExample dancUsrExample = new DancUsrExample();
        PageHelper.startPage(page,50);
        List<DancUsr> list = dancUsrMapper.selectByExample(dancUsrExample);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DancUsr> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    //用户申请列表
    @Override
    public EUDataGridResult getRequestList(int page){
        DancUsrRequestExample dancUsrRequestExample = new DancUsrRequestExample();
        PageHelper.startPage(page,50);
        List<DancUsrRequest> list = dancUsrRequestMapper.selectByExample(dancUsrRequestExample);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<DancUsrRequest> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

}
