package com.check.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionContextListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("创建成功"+se.getSession());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("销毁成功"+se.getSession());
		
	}


	

}
