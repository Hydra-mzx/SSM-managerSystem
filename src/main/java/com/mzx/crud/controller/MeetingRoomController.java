package com.mzx.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzx.crud.bean.Department;
import com.mzx.crud.bean.MeetingRoom;
import com.mzx.crud.bean.Msg;
import com.mzx.crud.service.DepartmentService;
import com.mzx.crud.service.MeetingRoomService;

@Controller
public class MeetingRoomController {
	
	@Autowired
	private MeetingRoomService meetingRoomService;
	
	@RequestMapping("/mrs")
	@ResponseBody
	public Msg getMrs() {		
		List<MeetingRoom> list = meetingRoomService.getMrs();
		return Msg.success().add("mrs", list);	
	}
	
}
