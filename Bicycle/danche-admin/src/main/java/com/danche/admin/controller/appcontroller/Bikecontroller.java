package com.danche.admin.controller.appcontroller;


import com.danche.admin.service.appservice.BikeService;
import com.danche.pojogongju.TaotaoResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Bikecontroller {

	@Autowired
	private BikeService bikeService;


//开始使用单车，车辆编号，使用人，返回订单编号和车辆密钥
	@RequestMapping(value = "/bike/shiyong",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult adminLogin(String id,String username) {
		try {
			TaotaoResult result = bikeService.bikeps(id,username);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(400, "请检查车辆编号");

		}

	}


	//结束使用，订单编号，使用人，返回单词价格
	@RequestMapping(value = "/bike/date",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult bikedate(Integer id,String user) {
		try {
			TaotaoResult result = bikeService.bikedate(id,user);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(400, "意外错误");

		}
	}

	@RequestMapping(value = "/bike/orderpay",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult bikeorder(Integer id) {
		try {
			TaotaoResult result = bikeService.orderpay(id);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(400, "意外错误");
		}
	}

	@RequestMapping(value = "/bike/paysucces",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult paysucces(Integer id) {
		try {
			TaotaoResult result = bikeService.paysucces(id);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(400, "意外错误");
		}
	}

	@RequestMapping(value = "/bike/paysucces1",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult paysucces(String user) {
		try {
			TaotaoResult result = bikeService.paysucces1(user);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(400, "意外错误");
		}
	}
}
