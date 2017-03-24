package com.every.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.every.ssm.mapper.UserMapper;
import com.every.ssm.po.User;
import com.every.ssm.po.UserExample;
import com.every.ssm.po.UserExample.Criteria;
import com.every.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private  UserMapper userMapper;
	
	/**
	 * 登录用户
	 */
	@Override
	public User login(User user) {
		//构建条件
		UserExample example=new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPasswordEqualTo(user.getPassword());
		//查询用户对象
		List<User> listUser = userMapper.selectByExample(example);
		
		if (listUser==null|| listUser.size()==0) {
			return null;
		}
		
		return listUser.get(0);
	}

	/**
	 * 查询所有的用户列表
	 */
	@Override
	public List<User> findAll() {
		UserExample example=new UserExample();
		return userMapper.selectByExample(example);
	}

}
