package com.mzx.crud.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

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
import com.mzx.crud.service.ApplyService;
import com.mzx.crud.service.MeetingRoomService;

@Controller
public class ApplyController {
	
	@Autowired
	ApplyService applyService;
	@Autowired
	MeetingRoomService meetingRoomService;
	
	@ResponseBody
	@RequestMapping(value = "/addapply",method = RequestMethod.POST)
	public Msg saveApply(String applyTimeStart,String applyTimeEnd,int applyDept,String applyMr,String applyEmp,int applyCapacity,String applyRemark) throws ParseException {
		Apply apply = new Apply();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		apply.setApplyTimeStart(sdf.parse(applyTimeStart));
		apply.setApplyTimeEnd(sdf.parse(applyTimeEnd));
		apply.setApplyDept(applyDept);
		apply.setApplyMr(applyMr);
		apply.setApplyEmp(applyEmp);
		apply.setApplyCapacity(applyCapacity);
		apply.setApplyRemark(applyRemark);
		apply.setApplyState("f");;
		applyService.saveApply(apply);
		return Msg.success();		
	}
	
	@ResponseBody
	@RequestMapping("/apply")
	public Msg getApply(
			@RequestParam(value="pn",defaultValue = "1")Integer pn) {
		PageHelper.startPage(pn,5);
		List<Apply> applys = applyService.getAll();		
		PageInfo page = new PageInfo(applys, 5);
		return Msg.success().add("pageInfo", page);		
	}
	
	@ResponseBody
	@RequestMapping("/use")
	public Msg getUse(
			@RequestParam(value="pn",defaultValue = "1")Integer pn) {
		PageHelper.startPage(pn,5);
		List<Apply> applys = applyService.getAllx();		
		PageInfo page = new PageInfo(applys, 5);
		return Msg.success().add("pageInfox", page);		
	}
	
	@ResponseBody
	@RequestMapping("/getdata")
	public Msg getData(
			@RequestParam(value="pn",defaultValue = "1")Integer pn,String val) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$"); 
        List<Apply> applys;
        PageHelper.startPage(pn,5);
         if(val.equals("0")) {
        	 applys = applyService.getAllx();
         }else if(pattern.matcher(val).matches()){
			int deptId = Integer.parseInt(val);
			applys = applyService.getAllWithDept(deptId);		
		 }else{
			applys = applyService.getAllWithMr(val);	
		 }
		PageInfo page = new PageInfo(applys, 5);
		return Msg.success().add("pageInfox", page);
	}
	
	@ResponseBody
	@RequestMapping(value="/apply/{applyId}",method = RequestMethod.PUT)
	public Msg saveEmp(@PathVariable("applyId")Integer id,Integer nums,String mrid) {
		MeetingRoom mr = meetingRoomService.getMr(mrid);
		//System.out.println(mr.getMrCapacity());
		if(nums>mr.getMrCapacity()) {			
			return Msg.fail().add("failmsg", "请求人数超过会议室容量");
		}else {
			applyService.updateapply(id,nums);
		}
		return Msg.success();		
	}
	
	@ResponseBody
	@RequestMapping(value="/apply/{applyId}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("applyId")Integer id) {
		applyService.deleteApply(id);
		return Msg.success();
	}
}
