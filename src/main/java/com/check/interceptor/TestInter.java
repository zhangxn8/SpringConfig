package com.check.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInter implements HandlerInterceptor{
    
	 
	/** 
     * preHandle�����ǽ��д����������õģ�����˼�壬�÷�������Controller����֮ǰ���е��ã�SpringMVC�е�Interceptor����������ʽ�ģ�����ͬʱ���� 
     * ���Interceptor��Ȼ��SpringMVC�����������ǰ��˳��һ����һ����ִ�У��������е�Interceptor�е�preHandle���������� 
     * Controller��������֮ǰ���á�SpringMVC������Interceptor��ʽ�ṹҲ�ǿ��Խ����жϵģ������жϷ�ʽ����preHandle�ķ� 
     * ��ֵΪfalse����preHandle�ķ���ֵΪfalse��ʱ����������ͽ����ˡ� 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		System.out.println(System.currentTimeMillis());
		System.out.println(request.getContextPath());
		System.out.println("�ɹ������������preHandler");		
		return true;
	}
    
	/** 
     * �������ֻ���ڵ�ǰ���Interceptor��preHandle��������ֵΪtrue��ʱ��Ż�ִ�С�postHandle�ǽ��д����������õģ�����ִ��ʱ�����ڴ��������д���֮ 
     * ��Ҳ������Controller�ķ�������֮��ִ�У�����������DispatcherServlet������ͼ����Ⱦ֮ǰִ�У�Ҳ����˵���������������Զ�ModelAndView���в� 
     * ���������������ʽ�ṹ���������ʵķ������෴�ģ�Ҳ����˵��������Interceptor�������÷������������ã����Struts2�������������ִ�й����е��� 
     * ֻ��Struts2�����intercept������Ҫ�ֶ��ĵ���ActionInvocation��invoke������Struts2�е���ActionInvocation��invoke�������ǵ�����һ��Interceptor 
     * �����ǵ���action��Ȼ��Ҫ��Interceptor֮ǰ���õ����ݶ�д�ڵ���invoke֮ǰ��Ҫ��Interceptor֮����õ����ݶ�д�ڵ���invoke����֮�� 
     */  
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(System.currentTimeMillis());
		System.out.println(request.getContextPath());	
		System.out.println("�ɹ�����������postHandler");
	}
    

    /** 
     * �÷���Ҳ����Ҫ��ǰ��Ӧ��Interceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С��÷������������������֮��Ҳ����DispatcherServlet��Ⱦ����ͼִ�У� 
     * �����������Ҫ����������������Դ�ģ���Ȼ�������Ҳֻ���ڵ�ǰ���Interceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С� 
     */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println(System.currentTimeMillis());
		System.out.println(request.getContextPath());
		System.out.println("�ɹ�����������afterHandler");		
	}
 
}
