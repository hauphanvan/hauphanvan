package com.pack.hauphanvan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PromoInterceptor extends HandlerInterceptorAdapter{
	private String promoCode;
	private String successRedirect;
	private String failRedirect;
	
	/**
	 * @param promoCode the promoCode to set
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	/**
	 * @param successRedirect the successRedirect to set
	 */
	public void setSuccessRedirect(String successRedirect) {
		this.successRedirect = successRedirect;
	}

	/**
	 * @param failRedirect the failRedirect to set
	 */
	public void setFailRedirect(String failRedirect) {
		this.failRedirect = failRedirect;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("hello");
		String inputPromo = request.getParameter("promo");
		String requestUrl = request.getContextPath();
		if(inputPromo.equals(promoCode)) {
			response.sendRedirect(requestUrl + successRedirect);
		}else {
			response.sendRedirect(requestUrl + failRedirect);
		}
		return false;
	}
}
