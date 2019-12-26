<%@ page language="java" import="java.util.*,com.xp.pojo.*" pageEncoding="utf-8"%>

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
    	<%
   		//获取作用域中的用户数据
   		ArrayList<User> lu=(ArrayList<User>)request.getAttribute("lu");
    	//遍历
    	for(int i=0;i<lu.size();i++){
	    %>
	     <tr>
	      <td width="5%"><%=lu.get(i).getUid() %></td>
	      <td width="15%"><%=lu.get(i).getUname() %></td>
	      <td width="10%"><%=lu.get(i).getPwd() %></td>
	      <td width="10%"><%=lu.get(i).getGender() %></td>
	      <td width="10%"><%=lu.get(i).getAge()%></td>
	      <td width="10%"><%=lu.get(i).getDob()%></td>
	     <td>
	     	<div class="button-group"> 
	     		<a class="button border-main" href="cateedit.html" style="padding:3px;margin:2px"><span class="icon-edit"></span> 修改</a> 
	     		<a class="button border-red" href="javascript:void(0)" onclick="return del(1,2)"style="padding:3px;margin:2px"><span class="icon-trash-o"></span> 删除</a> 
	     	</div>
	     </td>
    	</tr>
	  <%}%>
  </table>
</div>
<script type="text/javascript">
function del(id,mid){
	if(confirm("您确定要删除吗?")){			
		
	}
}
</script>
</body>
</html>