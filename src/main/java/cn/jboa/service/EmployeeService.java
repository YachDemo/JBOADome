package cn.jboa.service;

import cn.jboa.pojo.SysEmployee;
import cn.jboa.pojo.SysPosition;

public interface EmployeeService {

	SysEmployee findLogin(SysEmployee employee);

	SysEmployee findPosEmp(SysPosition sysPosition);

}
