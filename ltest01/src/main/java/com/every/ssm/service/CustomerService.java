package com.every.ssm.service;

import java.util.List;

import com.every.ssm.po.Cust;

public interface CustomerService {

	List<Cust> findCustomerListByQueryVo(Cust cust);//根据条件查询所有客户列表

	void deleteById(Integer id);//删除客户

	void save(Cust cust);//添加客户

}
