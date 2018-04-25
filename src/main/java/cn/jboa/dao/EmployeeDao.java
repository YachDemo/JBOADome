package cn.jboa.dao;

import cn.jboa.pojo.SysEmployee;
import cn.jboa.pojo.SysPosition;

public interface EmployeeDao {

	SysEmployee findLogin(SysEmployee employee);

	SysEmployee findPosEmp(SysPosition sysPosition);

}
