package com.every.ssm.mapper;

import com.every.ssm.po.Cust;
import com.every.ssm.po.CustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustMapper {
    int countByExample(CustExample example);

    int deleteByExample(CustExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Cust record);

    int insertSelective(Cust record);

    List<Cust> selectByExample(CustExample example);

    Cust selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Cust record, @Param("example") CustExample example);

    int updateByExample(@Param("record") Cust record, @Param("example") CustExample example);

    int updateByPrimaryKeySelective(Cust record);

    int updateByPrimaryKey(Cust record);
    
    List<Cust> selectCustListByQueryVo(Cust cust);//根据条件查询客户列表
    
    
}