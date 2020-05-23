package com.mzx.crud.bean;

public class MeetingRoom {
    private String mrId;

    private String mrName;

    private String mrType;

    private Integer mrCapacity;

    private String tblMeetingroomcol;

    public String getMrId() {
        return mrId;
    }

    public void setMrId(String mrId) {
        this.mrId = mrId == null ? null : mrId.trim();
    }

    public String getMrName() {
        return mrName;
    }

    public void setMrName(String mrName) {
        this.mrName = mrName == null ? null : mrName.trim();
    }

    public String getMrType() {
        return mrType;
    }

    public void setMrType(String mrType) {
        this.mrType = mrType == null ? null : mrType.trim();
    }

    public Integer getMrCapacity() {
        return mrCapacity;
    }

    public void setMrCapacity(Integer mrCapacity) {
        this.mrCapacity = mrCapacity;
    }

    public String getTblMeetingroomcol() {
        return tblMeetingroomcol;
    }

    public void setTblMeetingroomcol(String tblMeetingroomcol) {
        this.tblMeetingroomcol = tblMeetingroomcol == null ? null : tblMeetingroomcol.trim();
    }
}