<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>办公管理</title>
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
<script type="text/javascript"
	src="${APP_PATH}/static/js/jquery-2.1.4.min.js"></script>
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
	
 
<!-- <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script> -->

</head>
<body>
	<!-- 设置模态框 -->
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
	<!-- 新增申请模态框 -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增会议室申请</h4>
				</div>
				<div class="modal-body">
					<form id="add_apply_form">
						<div class="row">
							<div class="form-group col-sm-6">
								<label>选择开始时间：</label>
								<!--指定 date标记-->
								<div class='input-group date datetimepicker'>
									<input type='text' class="form-control" name="applyTimeStart" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label>选择结束时间：</label>
								<!--指定 date标记-->
								<div class='input-group date datetimepicker'>
									<input type='text' class="form-control" name="applyTimeEnd" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="select_dept" class="col-sm-2 control-label">部门名</label>
							<div class="col-sm-4">
								<select class="form-control" name="applyDept">
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="select_mr" class="col-sm-2 control-label">会议室</label>
							<div class="col-sm-4">
								<select class="form-control" name="applyMr">
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="apply_emp" class="col-sm-2 control-label">申请人</label>
							<div class="col-sm-4">
								<input type="text" name="applyEmp" class="form-control" id="apply_emp">
								<!-- <span class="help-block"></span> -->
							</div>
						</div>
						<div class="form-group row">
							<label for="apply_capacity" class="col-sm-2 control-label">人数</label>
							<div class="col-sm-4">
								<input type="text" name="applyCapacity" class="form-control" id="apply_capacity">
								<!-- <span class="help-block"></span> -->
							</div>
						</div>
						<div class="form-group row">
							<label for="apply_remark" class="col-sm-2 control-label">备注</label>
							<div class="col-sm-8">
								<input type="text" name="applyRemark" class="form-control" id="apply_remark">
								<!-- <span class="help-block"></span> -->
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="add_apply_ok">确定</button>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-offset-2">
  		<h1>安监局综合管理系统</h1>
		<ul class="nav nav-pills" style="float:left">
			<li role="presentation"><a href="${APP_PATH}/main">首页</a></li>
			<li role="presentation" ><a href="${APP_PATH}/personnelMa">人事管理</a></li>
			<li role="presentation" class="active"><a href="#">办公管理</a></li>
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
	<div class="container">
		<div class="row" id="meeting_nav">
			<ul class="nav nav-tabs" style="float:left">
				<li role="presentation" class="active"><a href="#">申请</a></li>
				<li role="presentation"><a href="#">使用情况</a></li>
			</ul>
			<div class="col-sm-offset-9">
				<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#addModal" id="add_apply">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增申请
				</button>
			</div>
		</div>
		<div>
			<!-- 申请页 -->
			<div class="row show" id="p1">
				<table class="table table-hover" id="apply_meeting">
					<thead>
						<tr>
							<th>#</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th><select class="form-control" id="pageDept">
							</select></th>
							<th>会议室</th>
							<th>申请人</th>
							<th>人数</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<!-- 分页信息栏 -->
				<div class="row">
					<!-- 分页条 -->
					<div class="col-md-6" id="page_info_area"></div>
					<!-- 分页信息 -->
					<div class="col-md-6" id="page_nav_area"></div>
				</div>
			</div>
			<!-- 使用页 -->
			<div class="row hide" id="p2">
				<table class="table table-hover" id="meeting">
					<thead>
						<tr>
							<th>#</th>
							<th>使用时间</th>
							<th><select class="form-control" id="useMr">
									<option>会议室</option>
							</select></th>
							<th><select class="form-control" id="useDept">
									<option>部门</option>
							</select></th>
							<th>申请人</th>
							<th>人数</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<!-- 分页信息栏 -->
				<div class="row">
					<!-- 分页条 -->
					<div class="col-md-6" id="pagex_info_area">分页条</div>
					<!-- 分页信息 -->
					<div class="col-md-6" id="pagex_nav_area">分页信息</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var totalRecord, currentPage;
		var totalRecordx, currentPagex;
		//日期转换 
		Date.prototype.Format = function(fmt) {
			var o = {
				"M+" : this.getMonth() + 1, //月份 
				"d+" : this.getDate(), //日 
				"h+" : this.getHours(), //小时 
				"m+" : this.getMinutes(), //分 
				"s+" : this.getSeconds(), //秒 
				"q+" : Math.floor((this.getMonth() + 3) / 3),
				"S" : this.getMilliseconds()
			//毫秒 
			};
			if (/(y+)/.test(fmt))
				fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			for ( var k in o) {
				if (new RegExp("(" + k + ")").test(fmt)) {
					fmt = fmt.replace(RegExp.$1,
							(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
									.substr(("" + o[k]).length)));
				}
			}
			return fmt;
		}
		var currentDate = (new Date()).Format("yyyy-MM-dd");
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
		$("#setting_btn").attr("pass","no");
	//验证密码重复性 
	$("#set_password").blur(function () {
		chePwd("#set_password");
		if($("#set_password_repeat").val() != $(this).val()) {
			show_validate_msg("#set_password_repeat","error","密码输入不一致");
			$("#setting_btn").attr("pass","no");
		}else{
			show_validate_msg("#set_password_repeat","success","密码输入一致");
			$("#setting_btn").attr("pass","yes");
		}
	});
	$("#set_password_repeat").blur(function () {
		chePwd("#set_password_repeat");
			if($("#set_password").val() != $(this).val()) {
			show_validate_msg("#set_password_repeat","error","密码输入不一致")
			$("#setting_btn").attr("pass","no");
		}else{
			show_validate_msg("#set_password_repeat","success","密码输入一致");
			$("#setting_btn").attr("pass","yes");
		}
	});
	$("#setting_btn").click(function() {
		//console.log($(this).attr("pass"));
		if($(this).attr("pass") == "yes"){			
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
		}else{
			return false;
		}
	})
		//导航切换 
		$("#meeting_nav li").click(function() {
			if ($("#p1").hasClass("show")) {
				$("#p1").addClass("hide").removeClass("show");
				$("#p2").addClass("show").removeClass("hide");
			} else {
				$("#p1").addClass("show").removeClass("hide");
				$("#p2").addClass("hide").removeClass("show");
			}
			$(this).siblings().removeClass("active");
			$(this).addClass("active");
			//console.log((new Date(1585688400000)).Format("yyyy-MM-dd hh:mm"));
		});



		//获取部门信息 
		function getDepts(ele) {
			//清空
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH}/depts",
				type : "get",
				success : function(result) {
					$("<option></option>").append("部门").attr("value", 0).appendTo(ele);
					$.each(result.extend.depts, function() {
						var optionEle = $("<option></option>").append(
								this.deptName).attr("value", this.deptId);
						optionEle.appendTo(ele);
					})
				}
			})
		}
		function getMeetingroom(ele) {
			//清空
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH}/mrs",
				type : "get",
				success : function(result) {
					//console.log(result);
					$("<option></option>").append("会议室").attr("value", 0).appendTo(ele);
					$.each(result.extend.mrs, function() {
						var optionEle = $("<option></option>").append(this.mrName)
								.attr("value", this.mrId);
						optionEle.appendTo(ele);
					})
				}
			})
		}

		$("#add_apply").click(function() {
			//console.log(currentDate);
			reset_form("#add_apply_form");
			getDepts("#addModal select[name='applyDept']");
			getMeetingroom("#addModal select[name='applyMr']");
			$('.datetimepicker').datetimepicker('remove');
			//时间输入设置 
			$('.datetimepicker').eq(0).datetimepicker({
				format : 'yyyy-mm-dd hh:ii',
				startDate : currentDate,
				autoclose : true,
				todayHighlight :true
			}).on('changeDate', function(ev) {
				//console.log(new Date(ev.date).Format("yyyy-MM-dd"));	
				var start = ev.date;
				//console.log(start);
				$('.datetimepicker').eq(1).datetimepicker('setStartDate', start);
			})

			$('.datetimepicker').eq(1).datetimepicker({
				format : 'yyyy-mm-dd hh:ii',
				startDate : currentDate,
				autoclose : true,
				todayHighlight :true
			}).on('changeDate', function(ev) {
				//console.log(new Date(ev.date).Format("yyyy-MM-dd"));	
				var end = ev.date;
				//console.log(end);
				$('.datetimepicker').eq(0).datetimepicker('setEndDate', end);
			});
		})

		$("#add_apply_ok").click(function() {
			//console.log($("#add_apply_form").serialize())
			if($("select[name='applyDept'] option:selected").val() == "0" || 
				$("select[name='applyMr'] option:selected").val() == "0"){
				return false;
			}
			$.ajax({
				url : "${APP_PATH}/addapply",
				type : "post",
				data : $("#add_apply_form").serialize(),
				success : function(result) {
					if (result.code == 100) {
						alert("添加成功");
						$("#addModal").modal('hide');
						to_Page(currentPage);
					} else if (result.code == 200) {
						alert("添加失败");
					}
				}
			})
		});
		$(function() {
			to_Page(1);
			to_Pagex(1);
		});
		function to_Page(pn) {
			getDepts("#pageDept");
			$.ajax({
				url : "${APP_PATH}/apply",
				data : "pn=" + pn,
				type : "get",
				success : function(result) {
					//console.log(result);
					build_apply_table(result);
					build_page_info(result);
					build_page_nav(result);
				}
			});
		}
		//创建表格 
		function build_apply_table(result) {
			$("#p1 tbody").empty();
			var applys = result.extend.pageInfo.list;
			$.each(applys,
					function(index, item) {
						var applyIdTd = $("<td></td>").append(item.applyId);
						var applyTimeStartTd = $("<td></td>").append(
								(new Date(item.applyTimeStart))
										.Format("yyyy-MM-dd hh:mm"));
						var applyTimeEndTd = $("<td></td>").append(
								(new Date(item.applyTimeEnd))
										.Format("yyyy-MM-dd hh:mm"));
						var applyDeptTd = $("<td></td>").append(
								item.department.deptName);
						var applyMrTd = $("<td></td>").append(
								item.meetingRoom.mrName);
						var applyEmpTd = $("<td></td>").append(item.applyEmp);
						var applyCapacityTd = $("<td></td>").append(
								item.applyCapacity);
						var applyRemarkTd = $("<td></td>").append(
								item.applyRemark);
						var editBtn = $("<button></button>").addClass(
								"btn btn-primary btn-sm edit_btn").append(
								$("<span></span>").addClass(
										"glyphicon glyphicon-ok"));
						editBtn.attr("edit-id", item.applyId).attr("mrid",
								item.meetingRoom.mrId);
						var delBtn = $("<button></button>").addClass(
								"btn btn-danger btn-sm delete_btn").append(
								$("<span></span>").addClass(
										"glyphicon glyphicon-remove"));
						delBtn.attr("del-id", item.applyId).attr("mrid",
								item.meetingRoom.mrId);
						var btnTd = $("<td></td>").append(editBtn).append(" ")
								.append(delBtn);
						$("<tr></tr>").append(applyIdTd).append(
								applyTimeStartTd).append(applyTimeEndTd)
								.append(applyDeptTd).append(applyMrTd).append(
										applyEmpTd).append(applyCapacityTd)
								.append(applyRemarkTd).append(btnTd).appendTo(
										"#p1 tbody");
					});
		};
		function build_page_info(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前 " + result.extend.pageInfo.pageNum + " 页，总 "
							+ result.extend.pageInfo.pages + " 页,总  "
							+ result.extend.pageInfo.total + " 条记录");
			totalRecord = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}
		function build_page_nav(result) {
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			if (!result.extend.pageInfo.hasPreviousPage) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				firstPageLi.click(function() {
					to_Page(1)
				});
				prePageLi.click(function() {
					to_Page(result.extend.pageInfo.pageNum - 1)
				});
			}
			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));
			if (!result.extend.pageInfo.hasNextPage) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_Page(result.extend.pageInfo.pageNum + 1)
				});
				lastPageLi.click(function() {
					to_Page(result.extend.pageInfo.pages)
				});
			}
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
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
		function to_Pagex(pn) {
			getDepts("#useDept");
			getMeetingroom("#useMr");
			$.ajax({
				url : "${APP_PATH}/use",
				data : "pn=" + pn,
				type : "get",
				success : function(result) {
					//console.log(result);
					build_use_table(result);
					build_pagex_info(result);
					build_pagex_nav(result); 
				}
			});
		}
		//创建表格 
	 	function build_use_table(result) {
			$("#p2 tbody").empty();
			var applys = result.extend.pageInfox.list;
			$.each(applys,
					function(index, item) {
						var applyIdTd = $("<td></td>").append(item.applyId);
						var applyTimetTd = $("<td></td>").append(
								(new Date(item.applyTimeStart)).Format("yyyy-MM-dd hh:mm")
										+"--"+
								(new Date(item.applyTimeEnd)).Format("yyyy-MM-dd hh:mm"));
						var applyMrTd = $("<td></td>").append(
								item.meetingRoom.mrName);
						var applyDeptTd = $("<td></td>").append(
								item.department.deptName);
						var applyEmpTd = $("<td></td>").append(item.applyEmp);
						var applyCapacityTd = $("<td></td>").append(
								item.applyCapacity);
						var applyRemarkTd = $("<td></td>").append(
								item.applyRemark);
						$("<tr></tr>").append(applyIdTd).append(
								applyTimetTd).append(applyMrTd)
								.append(applyDeptTd).append(applyEmpTd).append(
										applyCapacityTd).append(applyRemarkTd)
										.appendTo("#p2 tbody");
					});
		};
		function build_pagex_info(result) {
			$("#pagex_info_area").empty();
			$("#pagex_info_area").append(
					"当前 " + result.extend.pageInfox.pageNum + " 页，总 "
							+ result.extend.pageInfox.pages + " 页,总  "
							+ result.extend.pageInfox.total + " 条记录");
			totalRecordx = result.extend.pageInfox.total;
			currentPagex = result.extend.pageInfox.pageNum;
		}
		function build_pagex_nav(result) {
			$("#pagex_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			if (!result.extend.pageInfox.hasPreviousPage) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				firstPageLi.click(function() {
					to_Pagex(1)
				});
				prePageLi.click(function() {
					to_Page(result.extend.pageInfox.pageNum - 1)
				});
			}
			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));
			if (!result.extend.pageInfox.hasNextPage) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_Pagex(result.extend.pageInfox.pageNum + 1)
				});
				lastPageLi.click(function() {
					to_Pagex(result.extend.pageInfox.pages)
				});
			}
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfox.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfox.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					to_Pagex(item);
				})
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul).appendTo("#pagex_nav_area");
		}; 
		$(document).on("click",".edit_btn",function(){
			//console.log(confirm("是否通过此条申请？"));
			//console.log($(this).parent().prev().text())
			var appId = $(this).parents("tr").find("td:eq(0)").text();
			if(confirm("确认通过[ "+ appId +" ]吗？")){
			 $.ajax({
				url : "${APP_PATH}/apply/" + $(this).attr("edit-id"),
				type : "put",
				data : "nums=" + $(this).parent().prev().prev().text()
						+ "&mrid=" + $(this).attr("mrid"),
				success : function(result){
					if (result.code == 100){
						to_Page(currentPage);
						to_Pagex(currentPagex);
					}else if (result.code == 200) {
						alert(result.msg + ",原因："+ result.extend.failmsg);
					}
				}
			});
			}else{
				return false;
			}
		});
		$(document).on("click",".delete_btn",function(){
		var appId = $(this).parents("tr").find("td:eq(0)").text();
		if(confirm("确认删除[ "+ appId +" ]吗？")){
			$.ajax({
				url:"${APP_PATH}/apply/" + $(this).attr("del-id"),
				type:"delete",
				success: function (result) {
					alert(result.msg);
					to_Page(currentPage);
				}
			})
		}			
	});
		$(document).on(
				"change",
				"#useMr",
				function() {
					var vs = $('#useMr option:selected').val();
					//console.log(vs);
					to_Pagex_example(1,vs);
					 $("#useDept").val("0");
				})
		$(document).on(
				"change",
				"#useDept",
				function() {
					var vs = parseInt($('#useDept option:selected').val());
					//console.log(vs);
					to_Pagex_example(1,vs);
					$("#useMr").val("0");
				})
		function to_Pagex_example(pn,val) {
			//console.log(typeof val)
 			$.ajax({
				url : "${APP_PATH}/getdata",
				data : "pn=" + pn + "&val=" + val,
				type : "get",
				success : function(result) {
					//console.log(result);
 					build_use_table(result);
 					build_pagex_info(result);
 					build_pagex_nav(result); 
				}
			}); 
		}
	</script>
 <script type="text/javascript"
		src="${APP_PATH}/static/js/common.js"></script>
</body>
</html>