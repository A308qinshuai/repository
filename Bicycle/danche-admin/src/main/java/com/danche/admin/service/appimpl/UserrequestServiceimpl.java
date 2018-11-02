package com.danche.admin.service.appimpl;

import com.danche.admin.service.appservice.UserRequestservice;
import com.danche.admin.service.appservice.UseryueService;
import com.danche.mapper.DancUsrMapper;
import com.danche.mapper.DancUsrRequestMapper;
import com.danche.pojo.DancUsr;
import com.danche.pojo.DancUsrExample;
import com.danche.pojo.DancUsrRequest;
import com.danche.pojo.DancUsrRequestExample;
import com.danche.pojogongju.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by liuzhen on 2018/3/16.
 */
@Service
public class UserrequestServiceimpl implements UserRequestservice {

    @Autowired
    private DancUsrRequestMapper dancUsrRequestMapper;

    @Override
    public TaotaoResult  userRequest(DancUsrRequest dancUsrRequest){
        try {
            dancUsrRequest.setStatus("0");
            Date date = new Date();
            dancUsrRequest.setCreated(date);
            dancUsrRequest.setUpdated(date);
            dancUsrRequestMapper.insert(dancUsrRequest);
            return TaotaoResult.ok();
        }catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "提交失败");
        }



    }
}
