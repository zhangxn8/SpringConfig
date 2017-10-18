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
	        	//通知浏览器不要缓存
	            response.setHeader("Content-type", "text/html;charset=UTF-8");  
				response.setHeader("Expires", "-1");
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Pragma", "-1");
				
			//	response.getWriter().write(  
			  //              "恭喜您登录成功，将在3秒后跳转到首页，如果没有跳转，请点击<a href=''>超链接</a>");  
				int height=33;
				int width=90;
				//得到一个内存图像BufferedImage
				BufferedImage img=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				//得到一个画笔
				Graphics g=img.getGraphics();
				//画边框drawRect绘制指定矩形的边框。
				g.drawRect(0, 0, width, height);
				//填充颜色
				g.setColor(Color.gray);
				g.fillRect(1, 1, width-2, height-2);
				//画干扰线
				g.setColor(Color.BLACK);
				Random r=new Random();
				for(int i=0;i<20;i++)
				g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
				//生成随机数字
				g.setColor(Color.BLUE);
				g.setFont(new Font("微软雅黑", Font.BOLD|Font.ITALIC, 20));//BOLD加粗，ITALIC斜体
				int d=15;
				StringBuffer sb=new StringBuffer();//可变字符串的利用
				for(int j=0;j<4;j++){
					String code=r.nextInt(10)+"";
					sb.append(code);
					g.drawString(code+"", d, 20);
					d+=20;
				}
				//将验证码输入到session中，用来验证
				request.getSession().setAttribute("code", sb.toString());
				//输出打web页面
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
			System.out.println("验证成功");
		}
		response.setHeader("refresh", "5;URL=inter");
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		PrintWriter out=response.getWriter();
		out.write("恭喜你测试成功：5秒之后跳转刷新");
	}
	@RequestMapping(value="test")
	public void test(HttpServletRequest request,HttpServletResponse response) throws IOException{
		  response.setContentType("text/html; charset=utf-8");
		//response.sendRedirect("www.baidu.com");
		  response.setStatus(302);
		  response.setHeader("location","redirect"); 
     /*   PrintWriter out=response.getWriter();
		out.write("congratunation you have success <br>");
		out.write("成功");*/
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
	   out.write("测试拦截器");
	}
}
