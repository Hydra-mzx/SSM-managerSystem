<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>首页</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	//获得以斜线/ 开始，不以/ 结束的项目的路径
	if(session.getAttribute("user") == null) {
%>
		<script type="text/javascript" language="javascript">
			alert("您还没有登录，请登录...");
			window.document.location.href="${APP_PATH}/";
		</script>	
<%
	}
    //String M = session.getAttribute("user").toString(); //从session里把a拿出来，并赋值给M
    //System.out.println(M);
%>
<style type="text/css">
</style>
<script type="text/javascript"
	src="${APP_PATH}/static/js/jquery-2.1.4.min.js"></script>
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="modal fade" id="setModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改密码</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="reg_email">邮箱地址</label> <input
								type="email" name="adminEmail" class="form-control" id="set_email"
								placeholder="Email" value="${user.getAdminEmail()}" readonly>
							<span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="new_password">新密码</label> <input
								type="password" name="adminPassword" class="form-control" id="set_password"
								placeholder="Password">
							<span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="reg_password_repeat">重复密码</label> <input
								type="password" class="form-control" id="set_password_repeat"
								placeholder="Password">
							<span class="help-block"></span>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="setting_btn">确定</button>
				</div>
			</div>
		</div>
	</div>
	<div class="row col-sm-offset-2">
  		<h1>安监局综合管理系统</h1>
		<ul class="nav nav-pills" style="float:left">
			<li role="presentation" class="active"><a href="#">首页</a></li>
			<li role="presentation"><a href="${APP_PATH}/personnelMa">人事管理</a></li>
			<li role="presentation"><a href="${APP_PATH}/meetingMa">办公管理</a></li>
			<li role="presentation"><a href="${APP_PATH}/projectMa">项目管理</a></li>
		</ul>
		<div class="col-sm-offset-8">
			<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#setModal">
				<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
				设置
			</button>
			<button type="button" class="btn btn-default btn-sm" id="logout_btn">
				<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
				退出
			</button>
		</div>
	</div>
	<div class="row"><hr></div>
	<div class="container  col-sm-offset-2">
		<div class="row">
			<h2>
					Hello ,<small>${ user.getAdminEmail() }</small>
			</h2>
		</div>

	</div>
	<script type="text/javascript">
		$("#logout_btn").click(function() {
			$.ajax({
				url : "${APP_PATH}/logout",
				type : "get",
				success : function(result) {
					if (result.code == 100) {
						window.location.href = "${APP_PATH}/";
					} else if (result.code == 200) {
						alert("退出失败 ");
					}
				}
			})
		});
		$("#setting_btn").attr("pass", "no");
		//验证密码重复性 
		$("#set_password").blur(function() {
			chePwd("#set_password");
			if ($("#set_password_repeat").val() != $(this).val()) {
				show_validate_msg("#set_password_repeat", "error", "密码输入不一致");
				$("#setting_btn").attr("pass", "no");
			} else {
				show_validate_msg("#set_password_repeat", "success", "密码输入一致");
				$("#setting_btn").attr("pass", "yes");
			}
		});
		$("#set_password_repeat").blur(function() {
			chePwd("#set_password_repeat");
			if ($("#set_password").val() != $(this).val()) {
				show_validate_msg("#set_password_repeat", "error", "密码输入不一致")
				$("#setting_btn").attr("pass", "no");
			} else {
				show_validate_msg("#set_password_repeat", "success", "密码输入一致");
				$("#setting_btn").attr("pass", "yes");
			}
		});
		$("#setting_btn").click(function() {
			//console.log($(this).attr("pass"));
			if ($(this).attr("pass") == "yes") {
				$.ajax({
					url : "${APP_PATH}/setting",
					type : "post",
					data : $("#setModal form").serialize(),
					success : function(result) {
						if (result.code == 100) {
							alert("修改成功");
							reset_form("#setModal form");
							$("#setModal").modal('hide');
							window.document.location.href="${APP_PATH}/";
						} else if (result.code == 200) {
							alert("修改失败 ");
						}
					}
				})
			} else {
				return false;
			}
		})
	</script>
	<script type="text/javascript"
		src="${APP_PATH}/static/js/common.js"></script>
</body>
</html>