package com.pack.hauphanvan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ProcessTimeInterceptor implements HandlerInterceptor{
	private static final Logger LOGGER = Logger.getLogger(ProcessTimeInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long processTime = System.currentTimeMillis() - (Long) request.getAttribute("startTime");
		String path = request.getRequestURL().toString() + (request.getQueryString() == null ? "" : request.getQueryString());
		
		LOGGER.info(String.format("%s millisecond taken to process request %s", processTime, path));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
