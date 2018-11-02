package com.danche.admin.service.appservice;

import com.danche.pojogongju.TaotaoResult;

/**
 * Created by liuzhen on 2018/3/16.
 */
public interface UseryueService {
    TaotaoResult userYue(String username);
    TaotaoResult user(String username,String qianming,String jiaxiang,String name,String data);
}
