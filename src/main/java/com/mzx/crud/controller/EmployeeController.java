package com.mzx.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mzx.crud.bean.Employee;
import com.mzx.crud.bean.Msg;
import com.mzx.crud.service.EmployeeService;

/*
 * 处理员工CRUD请求
*/
/* 
 * 导入jackson包
 * 将return 的对象转换成json格式
 *  */
@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids ) {
		if(ids.contains("-")) {
			List<Integer> del_ids = new ArrayList<Integer>();
			String[] str_ids = ids.split("-");
			for(String string :str_ids) {
				del_ids.add(Integer.parseInt(string));
				employeeService.deleteBatch(del_ids);
			}
		}else {
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}		
		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value="/emp/{empId}",method = RequestMethod.PUT)
	public Msg saveEmp(Employee employee) {
		//System.out.println("更新的数据："+ employee );
		employeeService.updateEmp(employee);
		return Msg.success();
		
	}
	
	@RequestMapping(value = "/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")Integer id) {
		Employee employee =  employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
		
	}
	
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName")String empName) {
		boolean b = employeeService.checkUser(empName);
		if(b) {
			return Msg.success();
		}else {
			return Msg.fail();
		}		
	}
	
	@RequestMapping(value="/emps",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee,BindingResult result) {
		if(result.hasErrors()) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError fieldError:errors) {
				//字段名fieldError.getField()
				//字段对应错误信息fieldError.getDefaultMessage()
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else {
			employeeService.saveEmp(employee);
			return Msg.success();			
		}
		
	}
	
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value="pn",defaultValue = "1")Integer pn) {
		//引入PageHelper 分页插件
		//在查询之前只需要调用  传入页码，以及分页
		PageHelper.startPage(pn, 5);
		List<Employee> emps = employeeService.getAll();
		//使用pageInfo 包装查询后的结果，只需要将pageInfo交给页面就行了
		//封装了详细的分页信息
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("PageInfo", page);
	}
	
}
