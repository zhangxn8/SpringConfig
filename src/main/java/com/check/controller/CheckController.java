package com.check.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.check.demo.User;

@Controller
@RequestMapping(value="/check")
public class CheckController {
  
	
	@RequestMapping(value="Image")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	        	//֪ͨ�������Ҫ����
	            response.setHeader("Content-type", "text/html;charset=UTF-8");  
				response.setHeader("Expires", "-1");
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Pragma", "-1");
				
			//	response.getWriter().write(  
			  //              "��ϲ����¼�ɹ�������3�����ת����ҳ�����û����ת������<a href=''>������</a>");  
				int height=33;
				int width=90;
				//�õ�һ���ڴ�ͼ��BufferedImage
				BufferedImage img=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				//�õ�һ������
				Graphics g=img.getGraphics();
				//���߿�drawRect����ָ�����εı߿�
				g.drawRect(0, 0, width, height);
				//�����ɫ
				g.setColor(Color.gray);
				g.fillRect(1, 1, width-2, height-2);
				//��������
				g.setColor(Color.BLACK);
				Random r=new Random();
				for(int i=0;i<20;i++)
				g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
				//�����������
				g.setColor(Color.BLUE);
				g.setFont(new Font("΢���ź�", Font.BOLD|Font.ITALIC, 20));//BOLD�Ӵ֣�ITALICб��
				int d=15;
				StringBuffer sb=new StringBuffer();//�ɱ��ַ���������
				for(int j=0;j<4;j++){
					String code=r.nextInt(10)+"";
					sb.append(code);
					g.drawString(code+"", d, 20);
					d+=20;
				}
				//����֤�����뵽session�У�������֤
				request.getSession().setAttribute("code", sb.toString());
				//�����webҳ��
				ImageIO.write(img, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	@RequestMapping(value="demo")
	public void demo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String checkCode=(String) request.getSession().getAttribute("code");
		String inputCode=(String) request.getParameter("code");
		System.out.println(inputCode);
		System.out.println(checkCode);
		if(inputCode.equals(checkCode)){
			System.out.println("��֤�ɹ�");
		}
		response.setHeader("refresh", "5;URL=inter");
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		PrintWriter out=response.getWriter();
		out.write("��ϲ����Գɹ���5��֮����תˢ��");
	}
	@RequestMapping(value="test")
	public void test(HttpServletRequest request,HttpServletResponse response) throws IOException{
		  response.setContentType("text/html; charset=utf-8");
		//response.sendRedirect("www.baidu.com");
		  response.setStatus(302);
		  response.setHeader("location","redirect"); 
     /*   PrintWriter out=response.getWriter();
		out.write("congratunation you have success <br>");
		out.write("�ɹ�");*/
	}
	@RequestMapping(value="redirect")
	public void redirect(HttpServletResponse response,HttpServletRequest resquest) throws IOException{
		PrintWriter out=response.getWriter();
		out.write("Hello World");
		User user=new User();
		user.setName("zxn");
		response.getWriter().print(user);
		//out.write(user);
	}
	@RequestMapping(value="inter")
	public void interceptor(HttpServletRequest request,HttpServletResponse response) throws IOException{
	   response.setContentType("text/html; charset=utf-8");
	   PrintWriter out=response.getWriter();
	   out.write("����������");
	}
}
