package com.every.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.every.ssm.po.User;
import com.every.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	/**
	 * 跳转到login.jsp页面
	 * @return
	 */
	@RequestMapping("tologin")
	public String toLogin(){
		return "login";
	}
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("login")
	public String login(User user,Model model){
		
		//调用业务逻辑登录
		User loginUser = userService.login(user);
		
		if (loginUser==null) {
			model.addAttribute("errormsg", "用户名或密码错误");
			return "login";
		}
		
		//回显登录对象
		model.addAttribute("user", loginUser);
		
		
		return "index";
	}
	
	

}
