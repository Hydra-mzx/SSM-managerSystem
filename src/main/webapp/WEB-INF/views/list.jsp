<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
//获得以斜线/ 开始，不以/ 结束的项目的路径
%>
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${APP_PATH}/static/js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 表格 -->
		<div class="row">
			<table class="table table-hover">
				<tr>
					<th>#</th>
					<th>empName</th>
					<th>gender</th>
					<th>email</th>
					<th>deptName</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageInfo.list}" var="emp">
					<tr>
						<th>${emp.empId}</th>
						<th>${emp.empName}</th>
						<th>${emp.gender =="M"?"男":"女" }</th>
						<th>${emp.email}</th>
						<th>${emp.department.deptName}</th>
						<th>
							<button class="btn btn-primary btn-sm">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								编辑
							</button>
							<button class="btn btn-danger btn-sm">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								删除
							</button>
						</th>
					</tr>
				</c:forEach>
			</table>
		</div>
		<!-- 分页信息栏 -->
		<div class="row">
			<!-- 分页条 -->
			<div class="col-md-6">
				当前-${pageInfo.pageNum }-页，总 ${pageInfo.pages } 页,总 ${pageInfo.total } 条记录
			</div>
			<!-- 分页信息 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<li><a href="${APP_PATH }/emps?pn=1">首页</a></li>
						<c:if test="${pageInfo.hasPreviousPage }">
						<li><a href="${APP_PATH }/emps?pn=${pageInfo.pageNum-1 }" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>							
						</c:if>
						<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">							
							<c:if test="${page_Num == pageInfo.pageNum }">
								<li class="active"><a href="#">${page_Num }</a></li>
							</c:if>
							<c:if test="${page_Num != pageInfo.pageNum }">
								<li><a href="${APP_PATH }/emps?pn=${page_Num }">${page_Num }</a></li>
							</c:if>							
						</c:forEach>
						<c:if test="${pageInfo.hasNextPage }">
						<li><a href="${APP_PATH }/emps?pn=${pageInfo.pageNum+1 }" aria-label="Previous"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>							
						</c:if>
						<li><a href="${APP_PATH }/emps?pn=${pageInfo.pages }">末页</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
<!--上传文件-->
function fileupload(){
	    var formData = new FormData($("#form2")[0]);
	    $.ajax({
	            url:'${APP_PATH}/upload2',
	            type:'post',
	            data:formData,
	            //必须false才会自动加上正确的Content-Type
	            contentType: false,
	            //必须false才会避开jQuery对 formdata 的默认处理
	            //XMLHttpRequest会对 formdata 进行正确的处理
	            processData: false,
	            success:function(data){
	                alert(data);
	            },
	            error:function(data){
	                alert(data);
	                alert("后台发生异常");
	            },
	            cache:false,
	            async:true
	        }); 
	}
</script>
</html>