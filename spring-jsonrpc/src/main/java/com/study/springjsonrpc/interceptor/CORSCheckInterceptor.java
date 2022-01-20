package com.study.springjsonrpc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CORSCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response,
							 Object handler) throws Exception{
		
		if ("OPTIONS".equals(request.getMethod())) {
			return true;
		}
		
		response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
	    response.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS, POST, PUT, DELETE");
	    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	    response.setHeader("Access-Control-Max-Age", "3600");
		
	    return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
						   HttpServletResponse response,
						   Object handler,
						   ModelAndView mav) throws Exception{
		super.postHandle(request, response, handler, mav);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
								HttpServletResponse response,
								Object handler,Exception ex) throws Exception{
		super.afterCompletion(request, response, handler, ex);
	}
}
