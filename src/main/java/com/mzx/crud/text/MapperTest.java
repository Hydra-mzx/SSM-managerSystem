package com.mzx.crud.text;


import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mzx.crud.bean.Department;
import com.mzx.crud.bean.Employee;
import com.mzx.crud.dao.DepartmentMapper;
import com.mzx.crud.dao.EmployeeMapper;

//  测试dao层 
/*
 * 推荐 使用Spring 的单元测试，可以自动注入我们需要的组件
 * 1.导入SpringTest 模块
 * 2.使用@ContextConfiguration 指定Spring 配置文件的位置
 * 3.直接autowired要使用的组件
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	@Test
	public void testCRUD(){
		/*
		 * //测试department //正常1.创建SpringIOC容器 ApplicationContext ioc = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); //2.从容器中获取mapper
		 * ioc.getBean(DepartmentMapper.class);
		 */
		System.out.println(departmentMapper);
		
		//1.部门插入
//		departmentMapper.insertSelective(new Department(null,"开发部"));
//		departmentMapper.insertSelective(new Department(null,"测试部"));	
		
		//2.测试员工的插入
//		employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@qq.com", 1));
		
		//3.批量插入 
		/*
		 * for() { employeeMapper.insertSelective(new Employee(null, "Jerry", "M",
		 * "Jerry@qq.com", 1)); }
		 */
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5) + i;
			mapper.insertSelective(new Employee(null, uid, "M", uid+"@xxx.com", 1));
		}
		System.out.println("批量完成");
	}
}
