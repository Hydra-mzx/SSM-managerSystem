package com.mzx.crud.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mzx.crud.bean.Apply;
import com.mzx.crud.bean.Employee;
import com.mzx.crud.bean.MeetingRoom;
import com.mzx.crud.bean.Msg;
import com.mzx.crud.bean.Project;
import com.mzx.crud.service.EmployeeService;
import com.mzx.crud.service.ProWithEmpService;
import com.mzx.crud.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectService;
	@Autowired
	EmployeeService employService;
	@Autowired
	ProWithEmpService proWithEmpService;
	
	@ResponseBody
	@RequestMapping(value = "/addpro",method = RequestMethod.POST)
	public Msg saveApply(String proName,String proType,String proTime,int proDept,String proEmps) throws ParseException {
		boolean flag = true;
		String name="";
		int proid;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		Project pro = new Project(null, proName, sdf.parse(proTime), 0, proDept, proType, proEmps);
		//Project(null, proName, sdf.parse(proTime), 0, proDept, proType, proEmps);
		//System.out.println(pro);
		//System.out.println(proEmps);
		//先判断
        for (String retval: proEmps.split("、")){
        	if( employService.checkUser(retval) ) {
        		flag = false;
        		name = retval;
        		break;
        	}else {
        		//projectService.savePro(pro);
        		System.out.println(retval);
        		//int empid = employService.getEMPID(retval);
        		//System.out.println(empid);
        		//System.out.println(proid);
        	}
        }
        //在插入
        if(!flag) {
        	return Msg.fail().add("failmsg", name +"用户不存在");
        }else {
        	proid = projectService.savePro(pro);
            for (String retval: proEmps.split("、")){
				// projectService.savePro(pro);
				int empid = employService.getEMPID(retval);
				//System.out.println(empid);
				//System.out.println(proid);
				proWithEmpService.savePWE(proid,empid);
            }
        }
		//
		return Msg.success().add("proid", proid);		
	}
	
	@RequestMapping("/pros")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value="pn",defaultValue = "1")Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Project> pros = projectService.getAll();	
		PageInfo page = new PageInfo(pros, 5);		
		return Msg.success().add("PageInfo", page);
	}
	
	@ResponseBody
	@RequestMapping(value="/pro/{proId}",method = RequestMethod.PUT)
	public Msg updatePro(@PathVariable("proId")Integer id,Integer state) {
		projectService.updateState(id,state);
		return Msg.success().add("proid", id);		
	}
	
	@ResponseBody
	@RequestMapping(value="/searchpro",method = RequestMethod.PUT)
	public Msg searchPro(String search) {
		PageHelper.startPage(1, 5);
		List<Project> pros = projectService.searchPro(search);
		PageInfo page = new PageInfo(pros, 5);		
		return Msg.success().add("PageInfo", page);	
	}
}
