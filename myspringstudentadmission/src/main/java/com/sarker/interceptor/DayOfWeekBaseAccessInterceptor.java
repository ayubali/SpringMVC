package com.sarker.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

public class DayOfWeekBaseAccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		System.out
				.println("in com.sarker.interceptor.DayOfWeekBaseAccessInterceptor: day of week: "
						+ dayOfWeek);
		if (dayOfWeek == 1) {
			response.getWriter()
					.write("This website is closed on Sunday, Please try accessing it on any other week day!");
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out
				.println("HandlerOnterceptorAdapter:  Spring MVC called  postHandle method for "
						+ request.getRequestURI().toString());
		// super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// // TODO Auto-generated method stub
		// super.afterCompletion(request, response, handler, ex);

		System.out
				.println("HandlerOnterceptorAdapter:  Spring MVC called afterCompletion method for "
						+ request.getRequestURI().toString());
	}
}
