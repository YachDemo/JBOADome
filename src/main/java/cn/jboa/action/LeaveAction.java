package cn.jboa.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.jboa.pojo.BizLeave;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.pojo.SysPosition;
import cn.jboa.service.EmployeeService;
import cn.jboa.service.LeaveService;
import cn.jboa.utils.Page;

@Controller("leaveAction")
public class LeaveAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name="leaveService")
	private LeaveService leaveService;
	@Resource(name = "employeeService")
	private EmployeeService employeeService;
	
	private Date beginTime;
	private Date overTime;
	private BizLeave leave = new BizLeave();
	private Integer currtent;
	
	public String find_lea_Page() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String empSn = (String) ServletActionContext.getRequest().getSession().getAttribute("empSn");
		SysEmployee employees = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		map.put("post", employees.getSysPosition().getNameEn());
		map.put("currtent", this.getCurrtent());
		map.put("empSn", empSn);
		map.put("beginTime", beginTime);
		map.put("overTime", overTime);
		// 结果集
		Page<BizLeave> page = leaveService.find_Page(map, employees);
		if (page.getResult().size() > 0) {
			ServletActionContext.getRequest().setAttribute("beginTime", beginTime);
			ServletActionContext.getRequest().setAttribute("post", employees.getSysPosition().getNameEn());
			ServletActionContext.getRequest().setAttribute("overTime", overTime);
			ServletActionContext.getRequest().setAttribute("page", page);
		} else {
			ServletActionContext.getRequest().setAttribute("t", "tt");
		}
		return "find_Page";
	}
	
	/**
	 * 根据id查询请假
	 * @return
	 * @throws Exception
	 */
	public String find_Page_ById() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		BizLeave lea = leaveService.find_Page_ById(leave.getId(),employee);
		ServletActionContext.getRequest().setAttribute("lea", lea);
		return "find_Page_ById";
	}
	/**
	 * 审批请假跳转
	 * @return
	 * @throws Exception
	 */
	public String modify_lea_ById() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		BizLeave lea = leaveService.find_Page_ById(leave.getId(),employee);
		ServletActionContext.getRequest().setAttribute("lea", lea);
		return "modify_lea_ById";
	}
	/**
	 * 审批请假
	 * @return
	 * @throws Exception
	 */
	public String modify_lea_managerById() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		BizLeave bizLeave = leaveService.find_Page_ById(leave.getId(), employee);
		bizLeave.setApproveOpinion(leave.getApproveOpinion());
		bizLeave.setModifytime(new Date());
		bizLeave.setStatus(leave.getStatus());
		leaveService.modify_lea_manager(bizLeave);
		return "modify_lea_managerById";
	}

	/**
	 * 添加请假跳转
	 * @return
	 * @throws Exception
	 */
	public String sava_Tolea() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee employees = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		ServletActionContext.getRequest().setAttribute("employee", employees);
		SysPosition sysPosition = new SysPosition();
		sysPosition.setId(2);
		SysEmployee employpos = employeeService.findPosEmp(sysPosition);
		ServletActionContext.getRequest().setAttribute("employpos", employpos);
		return "sava_Tolea";
	}
	public String save_laeve() throws Exception {
		// TODO Auto-generated method stub
		leave.setCreatetime(new Date());
		SysEmployee employees = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		SysPosition sysPosition = new SysPosition();
		sysPosition.setId(2);
		SysEmployee employpos = employeeService.findPosEmp(sysPosition);
		leave.setNextDealSn(employpos);
		leave.setEmployeeSn(employees);
		leave.setStatus("待审批");
		leaveService.save_leave(leave);
		return "save_laeve";
	}
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getOverTime() {
		return overTime;
	}

	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}


	public BizLeave getLeave() {
		return leave;
	}


	public void setLeave(BizLeave leave) {
		this.leave = leave;
	}


	public Integer getCurrtent() {
		return currtent;
	}


	public void setCurrtent(Integer currtent) {
		this.currtent = currtent;
	}
	
}
