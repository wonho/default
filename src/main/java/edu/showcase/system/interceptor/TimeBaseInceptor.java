package edu.showcase.system.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeBaseInceptor extends HandlerInterceptorAdapter {

	 private static final int HOUR_OF_DAY = 0;
	 
	 private int openingTime;
	 private int closingTime;
	 
	 public void setOpeningTime(int openingTime) {
		 this.openingTime = openingTime;
	 }
	 
	 public void setClosingTime(int closingTime) {
		 this.closingTime = closingTime;
	 }
	 
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
	 Object handler) throws Exception {
		 Calendar cal = Calendar.getInstance();
		 int hour = cal.get(HOUR_OF_DAY);
		 
		 if (openingTime <= hour && hour < closingTime) {
			 return true;
		 }
		 
		 response.sendRedirect("http://host.com/outsideOfficeHours.html");
		 
		 return false;
	 }	
}
