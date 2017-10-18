package com.check.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TestFilter implements Filter {


	//FilterConfig�����ڷ���Filter��������Ϣ
	private FilterConfig config;
	//ʵ�ֳ�ʼ������
	public void init(FilterConfig config)
	{
	this.config = config; 
	}
	//ʵ�����ٷ���
	public void destroy()
	{
	this.config = null; 
	}
	//ִ�й��˵ĺ��ķ���
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain)throws IOException,ServletException
	{
	//---------����������ڶ��û�����ִ��Ԥ����---------
	//��ȡServletContext�������ڼ�¼��־
	ServletContext context = this.config.getServletContext(); 
	long before = System.currentTimeMillis();
	System.out.println("��ʼ����...");
	//������ת����HttpServletRequest����
	HttpServletRequest hrequest = (HttpServletRequest)request;
	//��¼��־
	context.log("Filter�Ѿ��ػ��û��������ַ�� " + hrequest.getServletPath());
	//Filterֻ����ʽ����������Ȼ���е�Ŀ�ĵ�ַ
	chain.doFilter(request, response); 
	//---------����������ڶԷ�������Ӧִ�к���---------
	long after = System.currentTimeMillis();
	//��¼��־
	context.log("���˽���");
	//�ٴμ�¼��־
	context.log("���󱻶�λ��" + hrequest.getRequestURI() + "������ʱ��Ϊ: " + (after - before)); 
	}
	}


