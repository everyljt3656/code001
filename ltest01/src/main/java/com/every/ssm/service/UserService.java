package com.every.ssm.service;

import java.util.List;

import com.every.ssm.po.User;

public interface UserService {

	User login(User user);//登录用户

	List<User> findAll();//查询所有用户列表

}
