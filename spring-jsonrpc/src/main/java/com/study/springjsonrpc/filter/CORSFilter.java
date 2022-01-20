package com.study.springjsonrpc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {
	public void doFilter(ServletRequest servletRequest,
						 ServletResponse servletResponse,
						 FilterChain chain) throws IOException, ServletException {
		
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse resp = (HttpServletResponse) response;
//		
//		resp.setHeader("Access-Control-Allow-Origin", "*");
//		resp.setHeader("Access-Control-Allow-Credentials", "true");
//		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
//		resp.setHeader("Access-Control-Max-Age", "10");
//		resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//		
//		if ("OPTIONS".equals(req.getMethod())) {
//			resp.setStatus(HttpServletResponse.SC_OK);
//			return;
//		}
//		
//		chain.doFilter(req, response);
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		System.out.println("CORSFilter in");
		
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (request.getMethod().equals("OPTIONS")) {
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        chain.doFilter(request, servletResponse);
		
//		HttpServletResponse response = (HttpServletResponse) servletResponse;
//		
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		
//		chain.doFilter(servletRequest, response);
	}
	
	public void init(FilterConfig filterConfig) {}
	
	public void destroy() {}
}

