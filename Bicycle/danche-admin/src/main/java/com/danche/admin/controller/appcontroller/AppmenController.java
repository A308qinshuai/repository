
package com.danche.admin.controller.appcontroller;

import com.danche.admin.service.appservice.OrderService;
import com.danche.admin.service.appservice.QianmingService;
import com.danche.admin.service.appservice.UserRequestservice;
import com.danche.admin.service.appservice.UseryueService;
import com.danche.pojo.DancUsrRequest;
import com.danche.pojogongju.TaotaoResult;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/app")
public class AppmenController {
    @Autowired
    private QianmingService qianmingService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UseryueService useryueService;
    @Autowired
    private UserRequestservice userRequestservice;

    //签名功能，接收用户名，返回签名和昵称
    @RequestMapping(value = "/qianming",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult userQianming(String username){
        try {
            TaotaoResult result = qianmingService.qianming(username);
            return result;
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtils.getStackTrace(e));
        }
    }

    //查询订单接口，接收使用人，返回订单详情
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult userOrder(String username){
        try {
            TaotaoResult result = orderService.userOrder(username);
            return result;
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtils.getStackTrace(e));
        }
    }

    //查看余额，接收用户，返回余额
    @RequestMapping(value = "/balans",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult userBalans(String username){
        try {
            TaotaoResult result = useryueService.userYue(username);
            return result;
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtils.getStackTrace(e));
        }
    }

    //用户加入，接受用户信息，返回ok
    @RequestMapping(value = "/request",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult userRequest(String user,String phone, String adress,String school){
        DancUsrRequest request = new DancUsrRequest();
        request.setUser(user);
        request.setPhone(phone);
        request.setAdress(adress);
        request.setData(school);
        TaotaoResult result = userRequestservice.userRequest(request);
        return result;
    }

    //用户修改个人资料，传入信息，返回ok
    @RequestMapping(value = "/ziliao",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult userZiliao(String username,String qianming,String jiaxiang,String name,String data){
        TaotaoResult result = useryueService.user(username,qianming,jiaxiang,name,data);
        return result;
    }
    }


