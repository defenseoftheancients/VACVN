package com.vacvn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(asyncSupported = true, urlPatterns = {"/api/*"})
public class CORSInterceptor implements Filter {

	private static final String[] allowedOrigins = { "http://localhost:3000", "http://localhost:5500",
			"http://localhost:8080/vacvn/", "http://127.0.0.1:3000", "http://127.0.0.1:5500",
			"http://127.0.0.1:5501", "https://localhost:8443" };

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String requestOrigin = request.getHeader("Origin");
		StringBuffer requestUrl = request.getRequestURL();
		System.out.println(requestOrigin + "->" + requestUrl);
		
		if (requestOrigin != null && isAllowedOrigin(requestOrigin)) {
			// Authorize the origin, all headers, and all methods
			((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", requestOrigin);
			((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "*");
			((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods",
					"GET, OPTIONS, HEAD, PUT, POST, DELETE");

			

			// CORS handshake (pre-flight request)
			if (request.getMethod().equals("OPTIONS")) {
				response.setStatus(HttpServletResponse.SC_ACCEPTED);
				return;
			}
			
		}
//		else {
//			response.sendError(HttpServletResponse.SC_FORBIDDEN);
//		}
		filterChain.doFilter(request, servletResponse);
	}

	private boolean isAllowedOrigin(String origin) {
		for (String allowedOrigin : allowedOrigins) {
			if (allowedOrigin.contains(origin))
				return true;
		}
		return false;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}