	//错误信息
	function show_validate_msg(ele,state,msg) {			
		if(state == "success"){
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(msg);	
		}else if(state == "error"){
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(msg);
		}
	};
	//邮箱校验
	var checkEmail = function (){
		var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if(regEmail.test($(this).val())){
			show_validate_msg($(this),"success","");
		}else{
			show_validate_msg($(this),"error","邮箱格式不正确");				
		}										
	};
	//密码校验
	function chePwd(ele){
		var regPwd = /^[a-z0-9_-]{6,18}$/;
		if(regPwd.test($(ele).val())){
			show_validate_msg(ele,"success","");
		}else{
			show_validate_msg(ele,"error","密码格式不正确");				
		}
	};
	$("#set_email").blur(checkEmail);
	//清空注册表单
	function reset_form(ele) {
		$(ele)[0].reset();
		$(ele).find("*").removeClass("has-error has-success");
		$(ele).find(".help-block").text("");
	};
	
	//设置模块校验 
	//$("#setting_btn").attr("pass","yes");
	/*	$("#set_password").blur(function () {
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
	});*/