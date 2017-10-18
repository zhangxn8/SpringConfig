package com.check.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyRequestContextListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("Request���ٳɹ�"+sre.getServletRequest());
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Request�����ɹ�"+sre.getServletRequest());
		
	}

	

}
