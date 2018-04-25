package cn.jboa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jboa.dao.EmployeeDao;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.pojo.SysPosition;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Resource(name="employeeDao")
	private EmployeeDao employeeDao;

	public SysEmployee findLogin(SysEmployee employee) {
		// TODO Auto-generated method stub
		return employeeDao.findLogin(employee);
	}

	public SysEmployee findPosEmp(SysPosition sysPosition) {
		// TODO Auto-generated method stub
		return employeeDao.findPosEmp(sysPosition);
	}

}
