<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>人事管理</title>
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
%>
<style type="text/css">
#container {
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
							<label for="reg_email">邮箱地址</label> <input type="email"
								name="adminEmail" class="form-control" id="set_email"
								placeholder="Email" value="${user.getAdminEmail()}" readonly>
							<span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="new_password">新密码</label> <input type="password"
								name="adminPassword" class="form-control" id="set_password"
								placeholder="Password"> <span class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="reg_password_repeat">重复密码</label> <input
								type="password" class="form-control" id="set_password_repeat"
								placeholder="Password"> <span class="help-block"></span>
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
	<div class="col-sm-offset-2">
  		<h1>安监局综合管理系统</h1>
		<ul class="nav nav-pills" style="float:left">
			<li role="presentation"><a href="${APP_PATH}/main">首页</a></li>
			<li role="presentation" class="active"><a href="#">人事管理</a></li>
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
	<!-- 修改 模态框 -->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">员工修改</h4>
				</div>
				<div class="modal-body">
					<!-- 表单 -->
					<form class="form-horizontal">
						<div class="form-group">
							<label for="empName_update_input" class="col-sm-2 control-label">员工姓名</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="empName_update_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="email_update_input" class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input type="text" name="email" class="form-control" id="email_update_input"
									placeholder="email@xxx.com">
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="gender_add_input" class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">
								<label class="radio-inline"> 
								<input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked">
									男 </label> 
								<label class="radio-inline"> 
								<input type="radio" name="gender" id="gender2_update_input" value="F">
									女 </label>
							</div>
						</div>
						<div class="form-group">
							<label for="email_add_input" class="col-sm-2 control-label">部门</label>
							<div class="col-sm-4">
								<select class="form-control" name="dId">
									<!-- 部门数据从数据库获取，提交id -->
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 新增 模态框 -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">员工添加</h4>
				</div>
				<div class="modal-body">
					<!-- 表单 -->
					<form class="form-horizontal">
						<div class="form-group">
							<label for="empName_add_input" class="col-sm-2 control-label">员工名</label>
							<div class="col-sm-10">
								<input type="text" name="empName" class="form-control" id="empName_add_input"
									placeholder="用户名可以是2-5位中文或6-16位英文和数字组合">
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="email_add_input" class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input type="text" name="email" class="form-control" id="email_add_input"
									placeholder="email@xxx.com">
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="gender_add_input" class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">
								<label class="radio-inline"> 
								<input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked">
									男 </label> 
								<label class="radio-inline"> 
								<input type="radio" name="gender" id="gender2_add_input" value="F">
									女 </label>
							</div>
						</div>
						<div class="form-group">
							<label for="email_add_input" class="col-sm-2 control-label">部门名</label>
							<div class="col-sm-4">
								<select class="form-control" name="dId">
									<!-- 部门数据从数据库获取，提交id -->
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>
	<div class="row"><hr></div>
	<div class="container">
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				<button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
			</div>
		</div>
		<!-- 表格 -->
		<div class="row">
			<table class="table table-hover" id="emps_table">
				<thead>
					<tr>						
						<th>
							<input type="checkbox" id="check_all"/>
						</th>
						<th>#</th>
						<th>员工名</th>
						<th>性别</th>
						<th>邮箱</th>
						<th>部门</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		<!-- 分页信息栏 -->
		<div class="row">
			<!-- 分页条 -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页信息 -->
			<div class="col-md-6" id="page_nav_area"></div>
		</div>
	</div>
	<script type="text/javascript">
		//退出网页 	
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
		})
		//修改密码  
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
						} else if (result.code == 200) {
							alert("修改失败 ");
						}
					}
				})
			} else {
				return false;
			}
		})
		var totalRecord, currentPage;
		$(function() {
			to_Page(1);
		});
		function to_Page(pn) {
			$.ajax({
				url : "${APP_PATH}/emps",
				data : "pn=" + pn,
				type : "get",
				success : function(result) {
					//console.log(res);
					build_emps_table(result);
					build_page_info(result);
					build_page_nav(result);
				}
			});
		}
		function build_emps_table(result) {
			$("#emps_table tbody").empty();
			var emps = result.extend.PageInfo.list;
			$
					.each(
							emps,
							function(index, item) {
								var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
								var empIdTd = $("<td></td>").append(item.empId);
								var empNameTd = $("<td></td>").append(
										item.empName);
								var genderTd = $("<td></td>").append(
										item.gender == 'M' ? "男" : "女");
								var emailTd = $("<td></td>").append(item.email);
								var deptNameTd = $("<td></td>").append(
										item.department.deptName);
								//<button class="">
								//<span class="" aria-hidden="true"></span>
								//编辑
								//</button>
								var editBtn = $("<button></button>")
										.addClass(
												"btn btn-primary btn-sm edit_btn")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-pencil"))
										.append("编辑");
								editBtn.attr("edit-id", item.empId);
								var delBtn = $("<button></button>")
										.addClass(
												"btn btn-danger btn-sm delete_btn")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-trash"))
										.append("删除");
								delBtn.attr("del-id", item.empId);
								var btnTd = $("<td></td>").append(editBtn)
										.append(" ").append(delBtn);
								$("<tr></tr>").append(checkBoxTd).append(
										empIdTd).append(empNameTd).append(
										genderTd).append(emailTd).append(
										deptNameTd).append(btnTd).appendTo(
										"#emps_table tbody");
							});
		};
		function build_page_info(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前 " + result.extend.PageInfo.pageNum + " 页，总 "
							+ result.extend.PageInfo.pages + " 页,总  "
							+ result.extend.PageInfo.total + " 条记录");
			totalRecord = result.extend.PageInfo.total;
			currentPage = result.extend.PageInfo.pageNum;
		}
		function build_page_nav(result) {
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			if (!result.extend.PageInfo.hasPreviousPage) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				firstPageLi.click(function() {
					to_Page(1)
				});
				prePageLi.click(function() {
					to_Page(result.extend.PageInfo.pageNum - 1)
				});
			}
			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));
			if (!result.extend.PageInfo.hasNextPage) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_Page(result.extend.PageInfo.pageNum + 1)
				});
				lastPageLi.click(function() {
					to_Page(result.extend.PageInfo.pages)
				});
			}
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.PageInfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.PageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					to_Page(item);
				})
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul).appendTo("#page_nav_area");
		};

		//清空表单
		function reset_form(ele) {
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}

		$("#emp_add_modal_btn").click(function() {
			//清除上一次输入校验过的数据 表单完整重置(数据，样式)
			reset_form("#empAddModal form");
			//ajax 获取显示部门信息
			getDepts("#empAddModal select")
			$("#empAddModal").modal({
				backdrop : "static"
			});
		});
		function getDepts(ele) {
			//清空
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH}/depts",
				type : "get",
				success : function(result) {
					$.each(result.extend.depts, function() {
						var optionEle = $("<option></option>").append(
								this.deptName).attr("value", this.deptId);
						optionEle.appendTo(ele);
					})
				}
			})
		}

		//检验 
		function validate_add_form() {
			var empName = $("#empName_add_input").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if (regName.test(empName)) {
				show_validate_msg("#empName_add_input", "success", "");
			} else {
				show_validate_msg("#empName_add_input", "error", "用户名格式错误");
				return false;
			}
			var email = $("#email_add_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if (regEmail.test(email)) {
				show_validate_msg("#email_add_input", "success", "");
			} else {
				show_validate_msg("#email_add_input", "error", "邮箱格式错误");
				return false;
			}
			return true;
		}

		function show_validate_msg(ele, state, msg) {
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if (state == "success") {
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			} else if (state == "error") {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}

		$("#empName_add_input").change(
				function name() {
					var empName = this.value;
					$.ajax({
						url : "${APP_PATH}/checkuser",
						type : "post",
						data : "empName=" + empName,
						success : function name(result) {
							if (result.code == 100) {
								show_validate_msg("#empName_add_input",
										"success", "用户名可用");
								$("#emp_save_btn").attr("ajax-va", "success");
							} else {
								show_validate_msg("#empName_add_input",
										"error", "用户名已存在");
								$("#emp_save_btn").attr("ajax-va", "error");
							}
						}
					});
				})

		$("#emp_save_btn")
				.click(
						function() {
							// 提交表单数据 --- 数据校验--- 服务器保存
							if (!validate_add_form()) {
								return false;
							}
							if ($(this).attr("ajax-va") == "error") {
								return false;
							}

							$
									.ajax({
										url : "${APP_PATH}/emps",
										type : "post",
										data : $("#empAddModal form")
												.serialize(),
										success : function name(result) {
											if (result.code == 100) {
												//alert(result.msg);
												//关闭模态框
												$("#empAddModal").modal('hide');
												//显示插入的数据
												to_Page(totalRecord);
											} else {
												if (result.extend.errorFields.email != undefined) {
													show_validate_msg(
															"#email_add_input",
															"error", "邮箱格式错误");
												}
												if (result.extend.errorFields.empName != undefined) {
													show_validate_msg(
															"#empName_add_input",
															"error", "用户名格式错误")
												}
											}
										}
									});
						})

		function getEmp(id) {
			$.ajax({
				url : "${APP_PATH}/emp/" + id,
				type : "get",
				success : function(result) {
					var empData = result.extend.emp;
					$("#empName_update_static").text(empData.empName);
					$("#email_update_input").val(empData.email);
					$("#empUpdateModal input[name=gender]").val(
							[ empData.gender ]);
					$("#empUpdateModal select").val([ empData.dId ]);
				}
			})
		}
		$(document).on("click", ".edit_btn", function() {
			getDepts("#empUpdateModal select");
			getEmp($(this).attr("edit-id"));
			//传递id
			$("#emp_update_btn").attr("edit-id", $(this).attr("edit-id"));
			$("#empUpdateModal").modal({
				backdrop : "static"
			});
		})

		$("#emp_update_btn").click(function() {
			//验证邮箱 
			var email = $("#email_update_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if (regEmail.test(email)) {
				show_validate_msg("#email_update_input", "success", "");
			} else {
				show_validate_msg("#email_update_input", "error", "邮箱格式错误");
				return false;
			}

			//发送ajax 保存更新的员工数据
			$.ajax({
				url : "${APP_PATH}/emp/" + $(this).attr("edit-id"),
				type : "put",
				data : $("#empUpdateModal form").serialize(),
				success : function(result) {
					//alert(result.msg);
					//1.关闭对话框
					$("#empUpdateModal").modal("hide");
					//2.回到页面
					to_Page(currentPage);
				}
			})
		})
		$(document).on("click", ".delete_btn", function() {
			var empName = $(this).parents("tr").find("td:eq(2)").text();
			if (confirm("确认删除[ " + empName + " ]吗？")) {
				$.ajax({
					url : "${APP_PATH}/emp/" + $(this).attr("del-id"),
					type : "delete",
					success : function(result) {
						alert(result.msg);
						to_Page(currentPage);
					}
				})
			}
		});

		$("#check_all").click(function() {
			$(".check_item").prop("checked", $(this).prop("checked"));
		});

		$(document)
				.on(
						"click",
						".check_item",
						function() {
							var flag = $(".check_item:checked").length == $(".check_item").length;
							$("#check_all").prop("checked", flag);
						});

		$("#emp_delete_all_btn").click(
				function() {
					var empNames = "";
					var del_idstr = "";
					$.each($(".check_item:checked"), function() {
						empNames += $(this).parents("tr").find("td:eq(2)")
								.text()
								+ ",";
						del_idstr += $(this).parents("tr").find("td:eq(1)")
								.text()
								+ "-";
					});
					empNames = empNames.substring(0, empNames.length - 1);
					del_idstr = del_idstr.substring(0, del_idstr.length - 1);
					if (confirm("确认删除[ " + empNames + " ]吗？")) {
						$.ajax({
							url : "${APP_PATH}/emp/" + del_idstr,
							type : "delete",
							success : function(result) {
								alert(result.msg);
								to_Page(currentPage);
							}
						})
					}
				});
	</script>
	<script type="text/javascript"
		src="${APP_PATH}/static/js/common.js"></script>
</body>
</html>