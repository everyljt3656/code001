package com.every.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.every.ssm.po.Cust;
import com.every.ssm.po.User;
import com.every.ssm.service.CustomerService;
import com.every.ssm.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired 
	private CustomerService customerService;
	@Autowired 
	private UserService userService;
	
	/**
	 * 跳转到center.jsp页面
	 * @return
	 */
	@RequestMapping("tocenter")
	public String toCenter(Cust cust,Model model){
		//根据条件查询所有客户列表
		List<Cust> custList = customerService.findCustomerListByQueryVo(cust);
		//调用业务逻辑查询所有用户
		List<User> userList = userService.findAll();
		
		//回显
		model.addAttribute("custList", custList);
		model.addAttribute("userList", userList);
		model.addAttribute("custName", cust.getCustName());
		model.addAttribute("custType", cust.getCustType());
		
		
		return "center";
	}
	
	
	/**
	 * 删除客户
	 * @return
	 */
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Integer id){
		
		customerService.deleteById(id);
		
		return "forward:/customer/tocenter";
	}
	
	/**
	 * 删除客户
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public Cust add(Cust cust){
		
		customerService.save(cust);
		
		return cust;
		
	}
	

}
