package com.danche.admin.service.appservice;

import com.danche.pojogongju.TaotaoResult;

/**
 * Created by liuzhen on 2018/3/17.
 */
public interface BikeService {
    TaotaoResult bikeps(String id,String username);
    TaotaoResult bikedate(Integer id,String user);
    TaotaoResult orderpay(Integer id);
    TaotaoResult paysucces(Integer id);
    TaotaoResult paysucces1(String user);
}
