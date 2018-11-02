package com.danche.admin.service.appservice;

import com.danche.pojo.DancUsrRequest;
import com.danche.pojogongju.TaotaoResult;

/**
 * Created by liuzhen on 2018/3/16.
 */
public interface UserRequestservice {
    TaotaoResult userRequest(DancUsrRequest dancUsrRequest);
}
