<%@ page language="java" import="java.util.*,com.xp.pojo.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 用户信息列表</strong></div>
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>
      <th width="15%">用户姓名</th>
      <th width="10%">密码</th>
      <th width="10%">性别</th>
      <th width="10%">年龄</th>
      <th width="10%">出生日期</th>
      <th width="10%">操作</th>
    </tr>
    	
	  <c:forEach items="${lu}" var="u">
	    	<tr>
		      <td width="5%">${u.uid}</td>
		      <td width="15%">${u.uname}</td>
		      <td width="10%">${u.pwd}</td>
		      <td width="10%">${u.gender}</td>
		      <td width="10%">${u.age}</td>
		      <td width="10%">${u.dob}</td>
<<<<<<< HEAD
		     <td><div class="button-group"> <a class="button border-main" href="cateedit.html"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="data?method=delUserInfo&uid=${u.uid}" onclick="return del()"><span class="icon-trash-o"></span> 删除</a> </div></td>
=======
		     <td><div class="button-group">
		      <a class="button border-main" href="cateedit.html"><span class="icon-edit"></span> 修改</a> 
		      <a class="button border-red" href="data?method=delUserInfo&uid=${u.uid}" onclick="return del(1,2)">
		      <span class="icon-trash-o"></span> 删除</a> </div></td>
>>>>>>> 53c2f983cd4deee23335ca65d9375d8ca223778d
	    	</tr>
    	</c:forEach>
  </table>
</div>
<script type="text/javascript">
function del(){
	return confirm("您确定要删除吗?")		
		
	
}
</script>
</body>
</html>