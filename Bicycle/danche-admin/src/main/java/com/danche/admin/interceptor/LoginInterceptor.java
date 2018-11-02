package com.danche.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danche.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Value("${REST_BASE_URL}")
	public  String REST_BASE_URL;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//在Handler执行之前处理
		//判断用户是否等登陆
		//从cookie中取token
		String token = CookieUtils.getCookieValue(request, "DC_TOKEN");
		if (token == null) {
			response.sendRedirect("/login");
			/*System.out.print(REST_BASE_URL);*/
			//返回false
			return false;
		}

		//若取到信息   放行
		//返回值决定handler是否执行。
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// handler执行之后，返回ModelAndView之前

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 返回ModelAndView之后
		//响应用户之后

	}

}
