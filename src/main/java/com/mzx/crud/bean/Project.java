package com.mzx.crud.bean;

import java.util.Date;

public class Project {
    private Integer proId;

    private String proName;

    private Date proTime;

    private Integer proState;

    private Integer proDept;

    private String proType;

    private String proEmps;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public Date getProTime() {
        return proTime;
    }

    public void setProTime(Date proTime) {
        this.proTime = proTime;
    }

    public Integer getProState() {
        return proState;
    }

    public void setProState(Integer proState) {
        this.proState = proState;
    }

    public Integer getProDept() {
        return proDept;
    }

    public void setProDept(Integer proDept) {
        this.proDept = proDept;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType == null ? null : proType.trim();
    }

    public String getProEmps() {
        return proEmps;
    }

    public void setProEmps(String proEmps) {
        this.proEmps = proEmps == null ? null : proEmps.trim();
    }

    
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(Integer proId, String proName, Date proTime, Integer proState, Integer proDept, String proType,
			String proEmps) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proTime = proTime;
		this.proState = proState;
		this.proDept = proDept;
		this.proType = proType;
		this.proEmps = proEmps;
	}
    
    
}