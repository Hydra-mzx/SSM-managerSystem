package com.mzx.crud.bean;

public class ProWithEmpKey {
    private Integer pweId;

    private Integer prId;

    private Integer emId;

    public Integer getPweId() {
        return pweId;
    }

    public void setPweId(Integer pweId) {
        this.pweId = pweId;
    }

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        this.emId = emId;
    }

	public ProWithEmpKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProWithEmpKey(Integer pweId, Integer prId, Integer emId) {
		super();
		this.pweId = pweId;
		this.prId = prId;
		this.emId = emId;
	}
    
}