package com.danche.admin.service.impl;

import com.danche.admin.service.UserService;
import com.danche.mapper.DancAdminUsrMapper;
import com.danche.pojo.DancAdminUsr;
import com.danche.pojo.DancAdminUsrExample;
import com.danche.pojogongju.TaotaoResult;
import com.danche.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by liuzhen on 2018/3/14.
 */
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private DancAdminUsrMapper adminUsrMapper;


    @Override
    public TaotaoResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response){
        //设置查询条件

        DancAdminUsrExample.Criter DancAdminUsrExample example = new DancAdminUsrExample();ia criteria = example.createCriteria();
        criteria.andUserEqualTo(username);
        List<DancAdminUsr> list = adminUsrMapper.selectByExample(example);

        //如果未查到此用户
        if(null== list || list.size()==0){
            return TaotaoResult.build(400, "您的用户名或密码错误1");
        }
        DancAdminUsr user= list.get(0);
        if (!password.equals(user.getPsword())) {
            return TaotaoResult.build(400, "您的用户名或密码错误2");
        }
        CookieUtils.setCookie(request, response, "DC_TOKEN", user.getUser());
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult outUser(HttpServletRequest request,HttpServletResponse response) {
        //删除cookie
        CookieUtils.deleteCookie(request, response, "DC_TOKEN");
        return TaotaoResult.ok();
    }



}
