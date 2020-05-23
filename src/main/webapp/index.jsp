<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
//获得以斜线/ 开始，不以/ 结束的项目的路径
%>
<style type="text/css">
#myLogin {
	margin: 0 auto;
	width: 500px;
	height: 500px;
}
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
	<!-- 注册Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">注册</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="reg_email">邮箱地址</label> <input
								type="email" name="adminEmail" class="form-control" id="reg_email"
								placeholder="Email">
							<span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="reg_password_first">密码</label> <input
								type="password" name="adminPassword" class="form-control" id="reg_password_first"
								placeholder="Password">
							<span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="reg_password_repeat">重复密码</label> <input
								type="password" class="form-control" id="reg_password_repeat"
								placeholder="Password">
							<span class="help-block"></span>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="reg_btn">确定</button>
				</div>
			</div>
		</div>
	</div>

	<div id="myLogin">
		<div class="page-header">
			<h1>
				安监局综合管理系统 <small>登录</small>
			</h1>
		</div>
		<form class="form-horizontal" >
			<div class="form-group">
				<label for="log_email" class="col-sm-2 control-label">邮箱</label>
				<div class="col-sm-6">
					<input type="email" name="adminEmail" class="form-control" id="log_email"
						placeholder="Email">
					<span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="log_password" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-6">
					<input type="password" name="adminPassword" class="form-control" id="log_password"
						placeholder="Password">
					<span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-2">
					<button type="button" class="btn btn-default" id="log_btn">登录</button>
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-default"
						data-toggle="modal" data-target="#myModal">注册
					</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		//存储 密码一致情况状态
		var flag=false;
		
		//错误信息
		function show_validate_msg(ele,state,msg) {			
			if(state == "success"){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);	
			}else if(state == "error"){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		//邮箱校验
		var checkEmail = function (){
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(regEmail.test($(this).val())){
				show_validate_msg($(this),"success","");
			}else{
				show_validate_msg($(this),"error","邮箱格式不正确");				
			}										
		}
		//密码校验
		function chePwd(ele){
			var regPwd = /^[a-z0-9_-]{6,18}$/;
			if(regPwd.test($(ele).val())){
				show_validate_msg(ele,"success","");
			}else{
				show_validate_msg(ele,"error","密码格式不正确");				
			}
		}
		//注册模块校验 
		$("#reg_email").blur(checkEmail);
		$("#reg_password_first").blur(function () {
			chePwd("#reg_password_first");
 			if($("#reg_password_repeat").val() != $(this).val()) {
				show_validate_msg("#reg_password_repeat","error","密码输入不一致");
				flag = false;
			}else{
				show_validate_msg("#reg_password_repeat","success","密码输入一致");
				flag = true;
			}
		})
		$("#reg_password_repeat").blur(function () {
			chePwd("#reg_password_repeat");
 			if($("#reg_password_first").val() != $(this).val()) {
				show_validate_msg("#reg_password_repeat","error","密码输入不一致");
				flag = false;
			}else{
				show_validate_msg("#reg_password_repeat","success","密码输入一致");
				flag = true;
			}
		})
		//清空注册表单

		function reset_form(ele) {
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		$("#reg_btn").click(
				function() {
					//console.log($("#myModal form").serialize());
					//console.log(flag);
					if (flag) {
						$.ajax({
							url : "${APP_PATH}/adminreg",
							type : "post",
							data : $("#myModal form").serialize(),
							success : function name(result) {
								//console.log(result)
								if (result.code == 200) {
									show_validate_msg($("#reg_email"), "error",
											"该邮箱用户已存在");
									return false;
								} else {
									alert("注册成功");
									reset_form("#myModal form");
									$("#myModal").modal('hide');
								}
							}
						})
					}else{
						return false;
					}
				})
		//登录模块校验 
		$("#log_email").blur(checkEmail);
		$("#log_password").blur(function() {
			chePwd("#log_password");
		});
		$("#log_btn").click(
				function() {
					//console.log($("#myLogin form").serialize())
					//后台校验
					$.ajax({
						url : "${APP_PATH}/adminlog",
						type : "post",
						data : $("#myLogin form").serialize(),
						success : function(result) {
							//console.log(result)
							if (result.code == 200) {
								show_validate_msg($("#log_email"), "error",
										"邮箱或密码不正确");
								return false;
							} else if (result.code == 100) {
								window.location.href = "${APP_PATH}/main";
							}
						}
					})
				})
	</script>
</body>
</html>