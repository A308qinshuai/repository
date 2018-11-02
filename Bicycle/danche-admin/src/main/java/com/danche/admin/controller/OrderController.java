package com.danche.admin.controller;

import com.danche.admin.service.AdminOrderService;
import com.danche.pojogongju.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

	@Autowired
	private AdminOrderService orderService;

	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page) {
		EUDataGridResult result = orderService.getItemList(page);
		return result;
	}

	@RequestMapping("/out/list")
	@ResponseBody
	public EUDataGridResult getoutList(Integer page) {
		EUDataGridResult result = orderService.getOutList(page);
		return result;
	}

	@RequestMapping("/bike/list")
	@ResponseBody
	public EUDataGridResult getbikeList(Integer page) {
		EUDataGridResult result = orderService.getBikeList(page);
		return result;
	}

	@RequestMapping("/user/list")
	@ResponseBody
	public EUDataGridResult getUserList(Integer page){
		EUDataGridResult result = orderService.getUserList(page);
		return result;
	}

	@RequestMapping("/user/request")
	@ResponseBody
	public EUDataGridResult getUserRequest(Integer page){
		EUDataGridResult result = orderService.getRequestList(page);
		return result;
	}

}
