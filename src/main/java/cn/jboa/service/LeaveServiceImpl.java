package cn.jboa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jboa.dao.LeaveDao;
import cn.jboa.pojo.BizLeave;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.utils.Page;

@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {
	@Resource(name="leaveDao")
	private LeaveDao leaveDao;

	public Page<BizLeave> find_Page(Map<String, Object> map, SysEmployee employees) {
		// TODO Auto-generated method stub
		Page<BizLeave> page = new Page<BizLeave>();
		page.setPageSize(4);
		Integer totalCount = leaveDao.find_countAll(map,employees);
		Integer totalPage = (totalCount % page.getPageSize() == 0)
				? (totalCount/page.getPageSize()) : (totalCount /page.getPageSize()+1);
		page.setTotalPage(totalPage);
		page.setTotalCount(totalCount);
		if (map.get("currtent")==null) {
			page.setCurrtentPage(1);
		}else if((Integer)map.get("currtent")>totalPage){
			page.setCurrtentPage(totalPage);
		}else if((Integer)map.get("currtent")<1){
			page.setCurrtentPage(1);
		}else {
			page.setCurrtentPage((Integer)map.get("currtent"));
		}
		List<BizLeave> result = leaveDao.find_Page(map,employees,page);
		page.setResult(result);
		return page;
	}

	public BizLeave find_Page_ById(long id, SysEmployee employee) {
		// TODO Auto-generated method stub
		return leaveDao.find_Page_ById(id,employee);
	}

	public void modify_lea_manager(BizLeave bizLeave) {
		// TODO Auto-generated method stub
		this.leaveDao.modify_lea_manager(bizLeave);
	}

	public void save_leave(BizLeave leave) {
		// TODO Auto-generated method stub
		this.leaveDao.save_leave(leave);
	}

}
