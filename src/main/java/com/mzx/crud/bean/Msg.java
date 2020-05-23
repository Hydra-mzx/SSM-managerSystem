package com.mzx.crud.bean;

import java.util.HashMap;
import java.util.Map;

/*
 * 通用返回的数据类
 * */
public class Msg {
	//状态码	100-success 200-failed
	private int code;
	//提示信息
	private String msg;
	//返回数据
	private Map<String, Object> extend = new HashMap<String, Object>();
	
	public static Msg success() {
		Msg res = new Msg();
		res.setCode(100);
		res.setMsg("处理成功");
		return res;
	}
	
	public static Msg fail() {
		Msg res = new Msg();
		res.setCode(200);
		res.setMsg("处理失败");
		return res;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	public Msg add(String key,Object value) {
		this.getExtend().put(key, value);
		return this;
		
	}
	
}
