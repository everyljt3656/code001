package com.every.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.every.ssm.mapper.CustMapper;
import com.every.ssm.po.Cust;
import com.every.ssm.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustMapper custMapper;
	
	/**
	 * 根据条件查询所有客户列表
	 */
	@Override
	public List<Cust> findCustomerListByQueryVo(Cust cust) {
		return custMapper.selectCustListByQueryVo(cust);
	}

	/**
	 * 删除客户
	 */
	@Override
	public void deleteById(Integer id) {
		custMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 添加客户
	 */
	@Override
	public void save(Cust cust) {
		custMapper.insert(cust);
	}

}
