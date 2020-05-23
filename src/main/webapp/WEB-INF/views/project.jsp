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
</head>
<body>

	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增项目</h4>
				</div>
				<div class="modal-body">
					<form id="add_pro_form">
						<div class="form-group row">
							<label for="pro_name" class="col-sm-3 control-label">项目名称</label>
							<div class="col-sm-6">
								<input type="text" name="proName" class="form-control"
									id="pro_name">
							</div>
						</div>
						<div class="form-group row">
							<label for="pro_type" class="col-sm-3 control-label">项目类别</label>
							<div class="col-sm-4">
								<input type="text" name="proType" class="form-control"
									id="pro_type">
							</div>
						</div>
						<div class="form-group row">
							<label for="pro_type" class="col-sm-3 control-label">选择立项时间：</label>
							<div class='input-group date datetimepicker col-sm-4'>
								<input type='text' class="form-control" name="proTime" /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group row">
							<label for="select_dept" class="col-sm-3 control-label">部门名</label>
							<div class="col-sm-4">
								<select class="form-control" name="proDept">
									<option value="1">开发部</option>
									<option value="2">测试部</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="apply_capacity" class="col-sm-3 control-label">人员</label>
							<div class="col-sm-6">
								<input type="text" name="proEmps" class="form-control"
									id="apply_capacity">
								<!-- <span class="help-block"></span> -->
							</div>
						</div>
					</form>
					<div class="row center-block">
						<label for="exampleInputFile">上传文档：</label>
						<form id="addFile">
							<input type="file" name='file' />
							<!-- <input type="button" id="button2" value="ajax上传" "> -->
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="add_pro_ok">确定</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">更新项目状态</h4>
				</div>
				<div class="modal-body">
					<!-- <form id="update_pro_form"> -->
						<!-- <div class="row"> -->
						<div class="form-group row center-block" id="pcontent">
							<!-- <p>当前项目过程为：，更新为下一过程为：</p> -->
						</div>
						<div class="row center-block">
							<label for="exampleInputFile">上传文档：</label>
							<form id="updateFile">
								<input type="file" name='file' />
								<!-- <input type="button" id="button2" value="ajax上传" "> -->
							</form>
						</div>
					<!-- </form> -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="update_pro_ok">确定</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="fileModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">查看和下载文件</h4>
				</div>
				<div class="modal-body">
					<div class="row center-block">
						<ol>
							<li><a>立项</a></li>
							<li><a>签约</a></li>
							<li><a>执行</a></li>
							<li><a>成果</a></li>
						</ol>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="update_pro_ok">确定</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row col-sm-offset-2">
  		<h1>安监局综合管理系统</h1>
		<ul class="nav nav-pills" style="float:left">
			<li role="presentation"><a href="${APP_PATH}/main">首页</a></li>
			<li role="presentation"><a href="${APP_PATH}/personnelMa">人事管理</a></li>
			<li role="presentation"><a href="${APP_PATH}/meetingMa">办公管理</a></li>
			<li role="presentation" class="active"><a href="#">项目管理</a></li>
		</ul>
		<div class="col-sm-offset-8">
			<button type="button" class="btn btn-default btn-sm" id="setting_btn">
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
		<div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search for...">
					<span class="input-group-btn ">
						<button class="btn btn-default" type="button" id="search_btn">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						查询</button>
					</span>
					<span class="input-group-btn ">
						<button class="btn btn-default" type="button" id="return_btn">
						<span class="glyphicon glyphicon-retweet" aria-hidden="true"></span>
						返回</button>
					</span>
				</div>
			</div>
			<div class="col-sm-offset-9">
				<button class="btn btn-primary btn-sm" data-toggle="modal"
					data-target="#addModal" id="add_pro">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增项目
				</button>
			</div>
		</div>
		<div class="row"><hr></div>
		<div class="row">
			<table class="table table-hover table-condensed" id="pros_table">
				<thead>
					<tr>
						<th>#</th>
						<th>项目名称</th>
						<th>类别</th>
						<th>立项时间</th>
						<th>部门</th>
						<th>员工</th>
						<th>状态</th>
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
	<!-- <form  id ="form2" action="load/upload2" enctype="multipart/form-data" method="post">
    		<input type = "file" name= 'file' />
    		<input type="text" name="name" value="dzf"/>
    		<input type="button" id = "button2" value="ajax上传" onclick="fileupload2()">
    		<input type ="submit" value="直接上传">
		</form> -->
		
	<script type="text/javascript">
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
	};	
		var upload = function(ele, id) {
			var formData = new FormData($(ele)[0]);
			$.ajax({
				url : '${APP_PATH}/upload1/' + id,
				type : 'post',
				data : formData,
				//必须false才会自动加上正确的Content-Type
				contentType : false,
				//必须false才会避开jQuery对 formdata 的默认处理
				//XMLHttpRequest会对 formdata 进行正确的处理
				processData : false,
				success : function(data) {
					alert(data);
				},
				error : function(data) {
					alert(data);
					alert("后台发生异常");
				},
				cache : false,
				async : true
			});
		}
		$("#button2").click(function() {
			upload("#addFile", 0);
		})
		$("#add_pro").click(function() {
			//console.log(currentDate);
			reset_form("#add_pro_form");
			//getDepts("#addModal select[name='applyDept']");
			//时间输入设置 
			$('.datetimepicker').datetimepicker({
				format : 'yyyy-mm-dd',
				//startDate : currentDate,
				autoclose : true,
				todayHighlight : true
			})
		})

		$("#add_pro_ok").click(function() {
			//console.log($("#add_pro_form").serialize())
			if ($("#addFile input").val() == "") {
				alert("请上传文件！")
				return false;
			} else {
				$.ajax({
					url : "${APP_PATH}/addpro",
					type : "post",
					data : $("#add_pro_form").serialize(),
					success : function(result) {
						if (result.code == 100) {
							alert("添加成功");
							upload("#addFile", result.extend.proid);
							$("#addModal").modal('hide');
							to_Page(currentPage);
						} else if (result.code == 200) {
							//console.log(result);
							alert("添加失败,原因："+result.extend.failmsg);
						}
					}
				})
			}
		});
		var totalRecord, currentPage;
		$(function() {
			to_Page(1);
		});
		function to_Page(pn) {
			$.ajax({
				url : "${APP_PATH}/pros",
				data : "pn=" + pn,
				type : "get",
				success : function(result) {
					//console.log(result);
					build_pros_table(result);
					build_page_info(result);
					build_page_nav(result);
				}
			});
		}
		function getState(state) {
			var res;
			switch (state) {
			case 0:
				res = "立项";
				break;
			case 1:
				res = "签约";
				break;
			case 2:
				res = "执行";
				break;
			default:
				res = "成果";
				break;
			}
			return res;
		}
		function build_pros_table(result) {
			$("#pros_table tbody").empty();
			var pros = result.extend.PageInfo.list;
			$.each(pros,
					function(index, item) {
						//var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
						var proIdTd = $("<td></td>").append(item.proId);
						var proNameTd = $("<td></td>").append(item.proName);
						var proTypeTd = $("<td></td>").append(item.proType);
						var proTimeTd = $("<td></td>").append(
								(new Date(item.proTime)).Format("yyyy-MM-dd"));
						var proDeptTd = $("<td></td>").append(
								item.proDept == 1 ? "开发部" : "测试部");
						var proEmpsTd = $("<td></td>").append(item.proEmps);
						var proStateTd = $("<td></td>").append(
								getState(item.proState));
						var editBtn = $("<button></button>").addClass(
								"btn btn-default btn-sm edit_btn").append(
								$("<span></span>").addClass(
										"glyphicon glyphicon-retweet")).append(
								"状态更新");
						editBtn.attr("editstate", item.proState);
						var delBtn = $("<button></button>").addClass(
								"btn btn-default btn-sm delete_btn").append(
								$("<span></span>").addClass(
										"glyphicon glyphicon-import")).append(
								"查看文件");
						delBtn.attr("del-id", item.empId);
						if (item.proState == 3) {
							var btnTd = $("<td></td>").append(delBtn);
						} else {
							var btnTd = $("<td></td>").append(editBtn).append(
									" ").append(delBtn);
						}
						$("<tr></tr>").append(proIdTd).append(proNameTd)
								.append(proTypeTd).append(proTimeTd).append(
										proDeptTd).append(proEmpsTd).append(
										proStateTd).append(btnTd).appendTo(
										"#pros_table tbody");
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
		$(document).on(
				"click",
				".edit_btn",
				function() {
					$("#pcontent").empty();
					var proId = $(this).parents("tr").find("td:eq(0)").text();
					var proState = Number($(this).attr("editstate"));//#modalcontent	
					//console.log(proState);
					$("#update_pro_ok").attr("proId", proId);
					$("<p></p>").append(
							"当前项目过程为：" + getState(proState) + " ，更新为下一过程为："
									+ getState(proState + 1)).appendTo(
							"#pcontent").attr("state", proState);
					$('#updateModal').modal('show');
				});
		$("#update_pro_ok").click(function() {
			var proid = Number($(this).attr("proId"));
			var state = Number($("#pcontent p").attr("state"));
			if ($("#updateFile input").val() == "") {
				alert("请上传文件！")
				return false;
			} else {
				$.ajax({
					url : "${APP_PATH}/pro/" + proid,
					type : "put",
					data : "state=" + state,
					success : function(result) {
						if (result.code == 100) {
							alert("更新成功");
							upload("#updateFile", proid);
						} else if (result.code == 200) {
							//alert(result.msg + ",原因："+ result.extend.failmsg);
							alert("更新失败");
						}
					}
				});
			}
		});
		$("#search_btn").click(function() {
			//console.log($(this).parent().prev().val());
			$.ajax({
				url : "${APP_PATH}/searchpro",
				type : "put",
				data : "search=" + $(this).parent().prev().val(),
				success : function(result) {
					if (result.code == 100) {
						alert("更新成功");
						build_pros_table(result);
						build_page_info(result);
						build_page_nav(result);
					} else if (result.code == 200) {
						//alert(result.msg + ",原因："+ result.extend.failmsg);
						alert("更新失败");
					}
				}
			});
		})
		$("#return_btn").click(function() {
			to_Page(1);
		})
		$(document).on("click", ".delete_btn", function() {

			/* 	$("#pcontent").empty();
				var proId = $(this).parents("tr").find("td:eq(0)").text();
				var proState = Number($(this).attr("editstate"));//#modalcontent	
				//console.log(proState);
				$("#update_pro_ok").attr("proId",proId);
				$("<p></p>").append(
						"当前项目过程为：" + getState(proState) + " ，更新为下一过程为："
								+ getState(proState+1)).appendTo(
						"#pcontent").attr("state",proState); */
			$('#fileModal').modal('show');
		});
	</script>
	 <script type="text/javascript"
		src="${APP_PATH}/static/js/common.js"></script>
</body>
</html>