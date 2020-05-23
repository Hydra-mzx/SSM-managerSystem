package com.mzx.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzx.crud.bean.Apply;
import com.mzx.crud.bean.ApplyExample;
import com.mzx.crud.bean.ApplyExample.Criteria;
import com.mzx.crud.dao.ApplyMapper;

@Service
public class ApplyService {
	
	@Autowired
	ApplyMapper applyMapper;

	public void saveApply(Apply apply) {
		// TODO Auto-generated method stub
		applyMapper.insertSelective(apply);
	}


	public void updateapply(Integer id, Integer nums) {
		// TODO Auto-generated method stub
		applyMapper.updateByPrimaryKeySelective(new Apply(id, null, null, null, null, nums, null, null, "t"));
	}
	
	public List<Apply> getAll() {
		// TODO Auto-generated method stub
		ApplyExample example = new ApplyExample();
		Criteria criteria = example.createCriteria();
		criteria.andApplyStateEqualTo("f");
		return applyMapper.selectByExampleWithOther(example);
	}

	public List<Apply> getAllx() {
		// TODO Auto-generated method stub
		ApplyExample example = new ApplyExample();
		Criteria criteria = example.createCriteria();
		criteria.andApplyStateEqualTo("t");
		return applyMapper.selectByExampleWithOther(example);
	}

	public List<Apply> getAllWithDept(int deptId) {
		// TODO Auto-generated method stub
		ApplyExample example = new ApplyExample();
		Criteria criteria = example.createCriteria();
		criteria.andApplyStateEqualTo("t");
		criteria.andApplyDeptEqualTo(deptId);
		return applyMapper.selectByExampleWithOther(example);
	}

	public List<Apply> getAllWithMr(String mrId) {
		// TODO Auto-generated method stub
		ApplyExample example = new ApplyExample();
		Criteria criteria = example.createCriteria();
		criteria.andApplyStateEqualTo("t");
		criteria.andApplyMrEqualTo(mrId);
		return applyMapper.selectByExampleWithOther(example);
	}


	public void deleteApply(Integer id) {
		// TODO Auto-generated method stub
		applyMapper.deleteByPrimaryKey(id);
	}
	
	
}
