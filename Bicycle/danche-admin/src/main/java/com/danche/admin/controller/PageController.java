package com.danche.admin.controller;

import com.danche.admin.service.UserService;
import com.danche.pojogongju.TaotaoResult;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PageController {

	@Autowired
	private UserService userSerivce;
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

	//用户登陆
	@RequestMapping(value = "/page/login",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult adminLogin(String n, String p, HttpServletRequest request, HttpServletResponse response) {
		try {
			TaotaoResult result = userSerivce.userLogin(n, p,request,response);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtils.getStackTrace(e));

		}

	}

	@RequestMapping("/page/outlogin")
	public void outLogin(HttpServletRequest request,HttpServletResponse response) {
		try {
			userSerivce.outUser(request, response);
			response.sendRedirect("/login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
