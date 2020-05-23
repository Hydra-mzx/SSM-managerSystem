package com.mzx.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzx.crud.bean.ProWithEmpKey;
import com.mzx.crud.dao.ProWithEmpMapper;

@Service
public class ProWithEmpService {
	
	@Autowired
	ProWithEmpMapper proWithEmpMapper;

	public void savePWE(int proid, int empid) {
		// TODO Auto-generated method stub
		proWithEmpMapper.insertSelective(new ProWithEmpKey(null, proid, empid));
	} 
	
	
}
