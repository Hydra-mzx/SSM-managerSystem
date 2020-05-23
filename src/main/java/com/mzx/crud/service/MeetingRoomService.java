package com.mzx.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzx.crud.bean.MeetingRoom;
import com.mzx.crud.dao.MeetingRoomMapper;

@Service
public class MeetingRoomService {
	
	@Autowired
	MeetingRoomMapper meetingRoomMapper;
	
	public List<MeetingRoom> getMrs() {
		// TODO Auto-generated method stub
		List<MeetingRoom> list = meetingRoomMapper.selectByExample(null);
		return list;
	}

	public MeetingRoom getMr(String mrid) {
		// TODO Auto-generated method stub		
		return meetingRoomMapper.selectByPrimaryKey(mrid);
	}
}
