package com.check.listener;

import java.text.MessageFormat;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener{

	  @Override
	    public void attributeAdded(ServletContextAttributeEvent scab) {
	        String str =MessageFormat.format(
	                "ServletContext����������������:{0}������ֵ��:{1}"
	                ,scab.getName()
	                ,scab.getValue());
	        System.out.println(str);
	    }

	    @Override
	    public void attributeRemoved(ServletContextAttributeEvent scab) {
	        String str =MessageFormat.format(
	                "ServletContext�������ɾ������:{0}������ֵ��:{1}"
	                ,scab.getName()
	                ,scab.getValue());
	        System.out.println(str);
	    }

	    @Override
	    public void attributeReplaced(ServletContextAttributeEvent scab) {
	        String str =MessageFormat.format(
	                "ServletContext��������滻������:{0}��ֵ"
	                ,scab.getName());
	        System.out.println(str);
	    }

}
