package com.danche.admin.service;

import com.danche.pojogongju.TaotaoResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuzhen on 2018/3/14.
 */
public interface UserService {

    TaotaoResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);
    TaotaoResult outUser(HttpServletRequest request,HttpServletResponse response);
}
