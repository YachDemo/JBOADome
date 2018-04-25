package cn.jboa.dao;

import java.util.List;
import java.util.Map;

import cn.jboa.pojo.BizLeave;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.utils.Page;

public interface LeaveDao {

	List<BizLeave> find_Page(Map<String, Object> map, SysEmployee employees, Page<BizLeave> page);

	Integer find_countAll(Map<String, Object> map, SysEmployee employees);

	BizLeave find_Page_ById(long id, SysEmployee employee);

	void modify_lea_manager(BizLeave bizLeave);

	void save_leave(BizLeave leave);

}
