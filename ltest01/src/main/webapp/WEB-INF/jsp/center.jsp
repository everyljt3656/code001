<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title></title>
    <link href="${pageContext.request.contextPath}/bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/Common.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/Index2.css" rel="stylesheet" />
     <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
     <script src="${pageContext.request.contextPath}/bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/Index2.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="row-fluid">
            <h4>数据列表</h4>
            <div>
            	<form action="">
            		 <div class="uinArea" id="uinArea">
						客户名称：
                	 <input type="text" id="cust_username" value="${custName }" name="custName" class="inputstyle"/>
                		客户类型：
               		<input type="text" id="cust_type" value="${custType }" name="custType" class="inputstyle"/>
               		<input type="submit" value="查询" style="width:60px;" class="button_blue"/>
                </div>
            	</form>
            </div>
            <div class="add"><a class="btn btn-success" onclick="openadd();">新增</a></div>
            <div class="w">
                <div class="span12">
                    <table class="table table-condensed table-bordered table-hover tab">
                        <thead>
                            <tr>
                                <th>客户名称</th>
                                <th>客户类型</th>
                                <th>客户电话</th>
                                <th>客户地址</th>
                                <th>所属用户角色</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody id="tbody">
                        	<c:forEach items="${custList }" var="cust">
	                        	 <tr>
	                                <th>${cust.custName }</th>
	                                <th>${cust.custType }</th>
	                                <th>${cust.custPhone }</th>
	                                <th>${cust.custAddress }</th>
	                                <th>${cust.nickname }</th>
	                                
	                                <th><a id="delCust" href="javascript:void(0)" onclick="delById(${cust.cid})">删除</a></th>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div id="page" class="tr"></div>
                </div>
            </div>

            <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">添加客户</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                    	<div align="center">
                    		<span id="adderror" style="color: red"></span><br>
                    	</div>
                        
                        <div class="control-group" >
                            <label class="control-label" for="custName">客户名称</label>
                            <div class="controls">
                                <input type="text" id="custName" placeholder="客户名称"/>
                                
                            </div>
                        </div>
                        <div class="control-group" >
                            <label class="control-label" for="custType">客户类型</label>
                            <div class="controls">
                                <input type="text" id="custType" placeholder="客户类型"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="custPhone">客户电话</label>
                            <div class="controls">
                                <input type="text" id="custPhone" placeholder="客户电话"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="custAddress">客户地址</label>
                            <div class="controls">
                                <input type="text" id="custAddress" placeholder="客户地址"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="nickname">所属用户角色</label>
                            <div class="controls">
                               <!--  <input type="text" id="English" placeholder="所属用户角色"/> -->
                                <select name="nickname" id="nickname">
                                		<option style="text-align: center;" value="">-----请选择------</option>
                                	<c:forEach items="${userList }" var="user">
                                		<option style="text-align: center;" value="${user.uid }">${user.username }</option>
                                	</c:forEach>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                    <button class="btn btn-primary" id="add" onclick="add();">保存</button>
                </div>
            </div>
        </div>
    </div>
   
</body>
</html>