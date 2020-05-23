package com.mzx.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzx.crud.bean.Admin;
import com.mzx.crud.bean.AdminExample;
import com.mzx.crud.bean.Msg;
import com.mzx.crud.bean.AdminExample.Criteria;
import com.mzx.crud.dao.AdminMapper;

@Service
public class AdminService {
	
	@Autowired
	AdminMapper adminMapper;

	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminMapper.insertSelective(admin);
	}
	
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAdminEmailEqualTo(admin.getAdminEmail());
		adminMapper.updateByExampleSelective(admin, example);
	}

	public boolean findAdmin(String adminEmail) {
		// TODO Auto-generated method stub
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAdminEmailEqualTo(adminEmail);
		long count = adminMapper.countByExample(example);
		return count==0 ;
	}
	
	public boolean checkAdmin(Admin admin) {
		// TODO Auto-generated method stub		
		if( !findAdmin(admin.getAdminEmail())) {			
			AdminExample example = new AdminExample();
			Criteria criteria = example.createCriteria();
			criteria.andAdminEmailEqualTo(admin.getAdminEmail());
			Admin adminSave = adminMapper.selectByExample(example).get(0);
			if( admin.getAdminPassword().equals( adminSave.getAdminPassword() ) ) {
				return true;
			}else {
				return false;
			}
		}else{
			return false;
		}
	}

	
	
	/*
	 * if( !adminService.findAdmin(admin.getAdminEmail()) ) {
	 * if(adminService.checkAdmin()) { model.addAttribute("user",admin); return
	 * Msg.success();
	 * 
	 * } }else{ return Msg.fail(); }
	 */
	
	
	
}
