package com.mzx.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzx.crud.bean.Project;
import com.mzx.crud.bean.ProjectExample;
import com.mzx.crud.bean.ProjectExample.Criteria;
import com.mzx.crud.dao.ProjectMapper;

@Service
public class ProjectService {
	
	@Autowired
	ProjectMapper projectMapper;

	public int savePro(Project pro) {
		// TODO Auto-generated method stub
		projectMapper.insertSelective(pro);
		ProjectExample projectExample = new ProjectExample();
		Criteria criteria = projectExample.createCriteria();
		criteria.andProNameEqualTo(pro.getProName());
		criteria.andProTypeEqualTo(pro.getProType());
		List<Project> prosearch = projectMapper.selectByExample(projectExample);
		return prosearch.get(0).getProId();		
	}

	public Project getPROID(String proName) {
		// TODO Auto-generated method stub
		ProjectExample projectExample = new ProjectExample();
		Criteria criteria = projectExample.createCriteria();
		criteria.andProNameEqualTo(proName);
		List<Project> pro = projectMapper.selectByExample(projectExample);
		return pro.get(0);
	}

	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return projectMapper.selectByExample(null);
	}

	public void updateState(Integer id, Integer state) {
		// TODO Auto-generated method stub
		projectMapper.updateByPrimaryKeySelective(new Project(id, null, null, state+1, null, null, null));
	}

	public List<Project> searchPro(String search) {
		// TODO Auto-generated method stub
		/*
		 * ProjectExample projectExample = new ProjectExample(); Criteria criteria =
		 * projectExample.createCriteria();
		 */
		return projectMapper.selectByExampleSearch(search);
	}
}
