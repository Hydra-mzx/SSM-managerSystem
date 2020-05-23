package com.mzx.crud.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mzx.crud.bean.Admin;
import com.mzx.crud.bean.Msg;
import com.mzx.crud.service.AdminService;

@SessionAttributes
@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/main")
	public String getMain() {
		return "main";		
	}
	
	@RequestMapping("/projectMa")
	public String getLogin() {
		return "project";		
	}
	
	@RequestMapping("/meetingMa")
	public String getMeeting() {		
		return "meeting";		
	}
	
	@RequestMapping("/personnelMa")
	public String getPersonnel() {
		return "personnel";		
	}
	
	@ResponseBody
	@RequestMapping(value = "adminreg",method = RequestMethod.POST)
	public Msg saveAdmin(Admin admin) {		
		if( adminService.findAdmin( admin.getAdminEmail() ) ) {
			adminService.saveAdmin(admin);			
			return Msg.success();		
		}else{
			return Msg.fail();	
		}
	}	
	
	@ResponseBody
	@RequestMapping(value = "adminlog",method = RequestMethod.POST)
	public Msg logAdmin(Admin admin,Model model,HttpServletRequest request) {	
		//System.out.println(adminService.checkAdmin(admin));
		HttpSession session = request.getSession();
		if(adminService.checkAdmin(admin)) {
			//model.addAttribute("user",admin);
			session.setAttribute("user", admin);			
			return Msg.success();
		}else{
			return Msg.fail();	
		}
	}	
	
	@ResponseBody	
	@RequestMapping(value="/setting",method = RequestMethod.POST)
	public Msg setAdmin(Admin admin) {
		// TODO Auto-generated method stub
		//System.out.println(admin);
		if( !adminService.findAdmin(admin.getAdminEmail())) {
			adminService.updateAdmin(admin);
			return Msg.success();
		}else {
			return Msg.fail();
		}
	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public Msg logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//session.removeAttribute("user");
		session.invalidate();
		return Msg.success();		
	}
	
}
