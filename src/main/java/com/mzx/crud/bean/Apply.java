package com.mzx.crud.bean;

import java.util.Date;

public class Apply {
    private Integer applyId;

    private Date applyTimeStart;

    private Date applyTimeEnd;

    private String applyEmp;

    private Integer applyDept;

    private Integer applyCapacity;

    private String applyRemark;

	private String applyMr;

    private String applyState;
    
    private Department department;
    
    private MeetingRoom meetingRoom;

    public Department getDepartment() {
    	return department;
    }
    
    public void setDepartment(Department department) {
    	this.department = department;
    }
    
    public MeetingRoom getMeetingRoom() {
    	return meetingRoom;
    }
    
    public void setMeetingRoom(MeetingRoom meetingRoom) {
    	this.meetingRoom = meetingRoom;
    }
    
    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Date getApplyTimeStart() {
        return applyTimeStart;
    }

    public void setApplyTimeStart(Date applyTimeStart) {
        this.applyTimeStart = applyTimeStart;
    }

    public Date getApplyTimeEnd() {
        return applyTimeEnd;
    }

    public void setApplyTimeEnd(Date applyTimeEnd) {
        this.applyTimeEnd = applyTimeEnd;
    }

    public String getApplyEmp() {
        return applyEmp;
    }

    public void setApplyEmp(String applyEmp) {
        this.applyEmp = applyEmp == null ? null : applyEmp.trim();
    }

    public Integer getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(Integer applyDept) {
        this.applyDept = applyDept;
    }

    public Integer getApplyCapacity() {
        return applyCapacity;
    }

    public void setApplyCapacity(Integer applyCapacity) {
        this.applyCapacity = applyCapacity;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark == null ? null : applyRemark.trim();
    }

    public String getApplyMr() {
        return applyMr;
    }

    public void setApplyMr(String applyMr) {
        this.applyMr = applyMr == null ? null : applyMr.trim();
    }

    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState == null ? null : applyState.trim();
    }
  
	public Apply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apply(Integer applyId, Date applyTimeStart, Date applyTimeEnd, String applyEmp, Integer applyDept,
			Integer applyCapacity, String applyRemark, String applyMr, String applyState) {
		super();
		this.applyId = applyId;
		this.applyTimeStart = applyTimeStart;
		this.applyTimeEnd = applyTimeEnd;
		this.applyEmp = applyEmp;
		this.applyDept = applyDept;
		this.applyCapacity = applyCapacity;
		this.applyRemark = applyRemark;
		this.applyMr = applyMr;
		this.applyState = applyState;
	}
    
    
}