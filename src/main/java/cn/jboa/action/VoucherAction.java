package cn.jboa.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.jboa.pojo.BizCheckResult;
import cn.jboa.pojo.BizClaimVoucher;
import cn.jboa.pojo.BizClaimVoucherDetail;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.pojo.SysPosition;
import cn.jboa.service.CheckResultService;
import cn.jboa.service.EmployeeService;
import cn.jboa.service.VoucherService;
import cn.jboa.utils.Page;

@Controller("voucherAction")
public class VoucherAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "voucherService")
	private VoucherService voucherService;
	@Resource(name = "employeeService")
	private EmployeeService employeeService;
	@Resource(name = "checkResultService")
	private CheckResultService checkResultService;

	private Long id;
	private BizClaimVoucherDetail voucherDetail = new BizClaimVoucherDetail();
	private String event;
	private String account;
	private String item;
	private InputStream inputStream;
	private Date beginTime;
	private Date overTime;
	private Integer currtent;
	private BizClaimVoucher claimVoucher = new BizClaimVoucher();
	private SysEmployee employee = new SysEmployee();
	private BizCheckResult checkResult = new BizCheckResult();

	/**
	 * 查看个人报销单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findPageCla() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> map = new HashMap<String, Object>();
		claimVoucher.setStatus(request.getParameter("claimVoucher.status"));
		map.put("currtent", this.getCurrtent());
		String empSn = (String) ServletActionContext.getRequest().getSession().getAttribute("empSn");
		SysEmployee employees = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		map.put("empSn", empSn);
		map.put("beginTime", beginTime);
		map.put("overTime", overTime);
		map.put("stauts", claimVoucher.getStatus());
		// 结果集
		Page<BizClaimVoucher> page = voucherService.findPageCla(map, employees);
		if (page.getResult().size() > 0) {
			ServletActionContext.getRequest().setAttribute("beginTime", beginTime);
			ServletActionContext.getRequest().setAttribute("overTime", overTime);
			ServletActionContext.getRequest().setAttribute("stauts", claimVoucher.getStatus());
			ServletActionContext.getRequest().setAttribute("page", page);
		} else {
			ServletActionContext.getRequest().setAttribute("t", "tt");
		}
		return SUCCESS;
	}

	public String loadFind() throws Exception {
		// TODO Auto-generated method stub
		
		return SUCCESS;
	}
	/**
	 * 跳转修改报销单
	 */
	public String modifyECla() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee emp = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		BizClaimVoucher voucher = voucherService.findEClaById(emp, claimVoucher.getId());
		ServletActionContext.getRequest().setAttribute("voucher", voucher);
		List<BizClaimVoucherDetail> voucherDetails = voucherService.findvoucherDetails(voucher);
		ServletActionContext.getRequest().setAttribute("details", voucherDetails);
		return SUCCESS;
	}

	/**
	 * 修改报销单
	 * @return
	 * @throws Exception
	 */
	public String modifyCla() throws Exception {
		// TODO Auto-generated method stub
		if ("新创建".equals(claimVoucher.getStatus())) {
			SysEmployee employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
			claimVoucher.setModifyTime(new Date());
			claimVoucher.setSysEmployeeByCreateSn(employee);
			voucherService.modify_Cla(claimVoucher);
			String[] items = item.split(",");
			String[] acctt = account.split(",");
			String[] ent = event.split(",");
			int arr = ent.length;
			if (arr==1) {
				arr = 2;
			}
			for (int i = 0; i < arr/2; i++) {
				BizClaimVoucherDetail voucherDetails = new BizClaimVoucherDetail();
				voucherDetails.setBizClaimVoucher(claimVoucher);
				voucherDetails.setItem(items[i].trim());
				voucherDetails.setDes(ent[i].trim());
				BigDecimal decimal = new BigDecimal(acctt[i].trim());
				voucherDetails.setAccount(decimal);
				voucherService.add_Detail(voucherDetails);
			}
			return SUCCESS;
		}else if ("待审核".equals(claimVoucher.getStatus())) {
			SysEmployee employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
			SysPosition position = new SysPosition();
			position.setId(2);
			SysEmployee employeePos = employeeService.findPosEmp(position);
			claimVoucher.setModifyTime(new Date());
			claimVoucher.setSysEmployeeByNextDealSn(employeePos);
			claimVoucher.setSysEmployeeByCreateSn(employee);
			voucherService.modify_Cla(claimVoucher);
			String[] items = item.split(",");
			String[] acctt = account.split(",");
			String[] ent = event.split(",");
			int arr = ent.length;
			if (arr==1) {
				arr = 2;
			}
			for (int i = 0; i < arr/2; i++) {
				BizClaimVoucherDetail voucherDetails = new BizClaimVoucherDetail();
				voucherDetails.setBizClaimVoucher(claimVoucher);
				voucherDetails.setItem(items[i].trim());
				voucherDetails.setDes(ent[i].trim());
				BigDecimal decimal = new BigDecimal(acctt[i].trim());
				voucherDetails.setAccount(decimal);
				voucherService.add_Detail(voucherDetails);
			}
			return SUCCESS;
		}
		return ERROR;
	}
	/**
	 * 删除报销单从表
	 * @return
	 * @throws Exception
	 */
	public String del_Detail() throws Exception {
		// TODO Auto-generated method stub
		String data = null;
		boolean t = voucherService.del_Detail(id);
		if (t) {
			data = "isTrue";
		} else {
			data = "isFalse";
		}
		inputStream = new ByteArrayInputStream(data.getBytes("utf-8"));
		return SUCCESS;
	}
	/**
	 * 删除报销单
	 * 
	 * @return
	 */
	public String delECla() throws Exception {
		// TODO Auto-generated method stub
		String data = null;
		boolean t = voucherService.delECla(claimVoucher.getId());
		if (t) {
			data = "isTrue";
		} else {
			data = "isFalse";
		}
		inputStream = new ByteArrayInputStream(data.getBytes("utf-8"));
		return SUCCESS;
	}

	/**
	 * 查看报销单
	 * 
	 * @return
	 */
	public String findEClaById() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee emp = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		BizClaimVoucher voucher = voucherService.findEClaById(emp, claimVoucher.getId());
		ServletActionContext.getRequest().setAttribute("voucher", voucher);
		List<BizClaimVoucherDetail> voucherDetails = voucherService.findvoucherDetails(voucher);
		ServletActionContext.getRequest().setAttribute("details", voucherDetails);
		return SUCCESS;
	}

	/**
	 * 添加跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toaddCla() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		ServletActionContext.getRequest().setAttribute("emp", employee);
		Date date = new Date();
		ServletActionContext.getRequest().setAttribute("date", date);
		return SUCCESS;
	}

	/**
	 * 添加报销单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addECla() throws Exception {
		if ("新创建".equals(claimVoucher.getStatus())) {
			SysEmployee employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
			claimVoucher.setCreateTime(new Date());
			claimVoucher.setSysEmployeeByCreateSn(employee);
			voucherService.add_Cla(claimVoucher);
			String[] items = item.split(",");
			String[] acctt = account.split(",");
			String[] ent = event.split(",");
			int arr = ent.length;
			if (arr==1) {
				arr = 2;
			}
			for (int i = 0; i < arr/2; i++) {
				BizClaimVoucherDetail voucherDetails = new BizClaimVoucherDetail();
				voucherDetails.setBizClaimVoucher(claimVoucher);
				voucherDetails.setItem(items[i].trim());
				voucherDetails.setDes(ent[i].trim());
				BigDecimal decimal = new BigDecimal(acctt[i].trim());
				voucherDetails.setAccount(decimal);
				voucherService.add_Detail(voucherDetails);
			}
			return SUCCESS;
		}else if ("待审核".equals(claimVoucher.getStatus())) {
			SysEmployee employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
			SysPosition position = new SysPosition();
			position.setId(2);
			SysEmployee employeePos = employeeService.findPosEmp(position);
			claimVoucher.setCreateTime(new Date());
			claimVoucher.setSysEmployeeByNextDealSn(employeePos);
			claimVoucher.setSysEmployeeByCreateSn(employee);
			voucherService.add_Cla(claimVoucher);
			String[] items = item.split(",");
			String[] acctt = account.split(",");
			String[] ent = event.split(",");
			int arr = ent.length;
			if (arr==1) {
				arr = 2;
			}
			for (int i = 0; i < arr/2; i++) {
				BizClaimVoucherDetail voucherDetails = new BizClaimVoucherDetail();
				voucherDetails.setBizClaimVoucher(claimVoucher);
				voucherDetails.setItem(items[i].trim());
				voucherDetails.setDes(ent[i].trim());
				BigDecimal decimal = new BigDecimal(acctt[i].trim());
				voucherDetails.setAccount(decimal);
				voucherService.add_Detail(voucherDetails);
			}
			return SUCCESS;
		}
		return ERROR;
	}


	/*----------------------------------------------------------------*/
	//管理层
	public String findPage_manager() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee employees = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> map = new HashMap<String, Object>();
		claimVoucher.setStatus(request.getParameter("claimVoucher.status"));
		map.put("currtent", this.getCurrtent());
		String empSn = (String) ServletActionContext.getRequest().getSession().getAttribute("empSn");
		map.put("empSn", empSn);
		map.put("beginTime", beginTime);
		map.put("overTime", overTime);
		map.put("stauts", claimVoucher.getStatus());
		map.put("manager", employees.getSysDepartment());
		// 结果集
		Page<BizClaimVoucher> page = voucherService.findPageCla(map, employees);
		if (page.getResult().size() > 0) {
			ServletActionContext.getRequest().setAttribute("beginTime", beginTime);
			ServletActionContext.getRequest().setAttribute("overTime", overTime);
			ServletActionContext.getRequest().setAttribute("stauts", claimVoucher.getStatus());
			ServletActionContext.getRequest().setAttribute("page", page);
		} else {
			ServletActionContext.getRequest().setAttribute("t", "tt");
		}
		return SUCCESS;
	}
	/**
	 * 部门经理审批跳转
	 * @return
	 * @throws Exception
	 */
	public String modify_Tomanager() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee emp = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		BizClaimVoucher voucher = voucherService.findEClaById(emp, claimVoucher.getId());
		ServletActionContext.getRequest().setAttribute("voucher", voucher);
		List<BizClaimVoucherDetail> voucherDetails = voucherService.findvoucherDetails(voucher);
		ServletActionContext.getRequest().setAttribute("details", voucherDetails);
		return SUCCESS;
	}
	/**
	 * 审核
	 */
	public String modify_manager() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee emp = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		checkResult.setCheckTime(new Date());
		checkResult.setCheckerSn(emp);
		BizClaimVoucher claimVouchers = voucherService.find_Cla_id(claimVoucher.getId());
		if ("已审核".equals(claimVoucher.getStatus())) {
			BigDecimal cc = new BigDecimal("5000");
			if (claimVoucher.getTotalAccount().compareTo(cc)>0) {
				SysPosition sysPosition = new SysPosition();
				sysPosition.setId(3);
				claimVouchers.setStatus("待审批");
				if ("generalmanager".equals(emp.getSysPosition().getNameEn())) {
					sysPosition.setId(4);
					claimVouchers.setStatus("已审批");
				}
				if ("cashier".equals(emp.getSysPosition().getNameEn())) {
					sysPosition.setId(4);
					claimVouchers.setStatus("已付款");
				}
				SysEmployee sysEmployee = employeeService.findPosEmp(sysPosition);
				sysEmployee.setSysPosition(sysPosition);
				claimVouchers.setSysEmployeeByNextDealSn(sysEmployee);
				voucherService.modify_Cla(claimVouchers);
			}else {
				SysPosition sysPosition = new SysPosition();
				sysPosition.setId(4);
				SysEmployee sysEmployee = employeeService.findPosEmp(sysPosition);
				sysEmployee.setSysPosition(sysPosition);
				claimVouchers.setSysEmployeeByNextDealSn(sysEmployee);
				voucherService.modify_Cla(claimVouchers);
			}
			checkResult.setBizClaimVoucher(claimVouchers);
			checkResultService.save_resultManage(checkResult);
			return SUCCESS;
		}else if ("已终止".equals(claimVoucher.getStatus())) {
			claimVouchers.setStatus("已终止");
			voucherService.modify_Cla(claimVouchers);
			checkResult.setBizClaimVoucher(claimVouchers);
			checkResultService.save_resultManage(checkResult);
			return SUCCESS;
		}else if ("已打回".equals(claimVoucher.getStatus())) {
			claimVouchers.setStatus("已打回");
			voucherService.modify_Cla(claimVouchers);
			checkResult.setBizClaimVoucher(claimVouchers);
			checkResultService.save_resultManage(checkResult);
			return SUCCESS;
		}
		return ERROR;
	}
	/**
	 * 总经理跳转
	 * @return
	 * @throws Exception
	 */
	public String modify_Togeneralmanager() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee emp = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		BizClaimVoucher voucher = voucherService.findEClaById(emp, claimVoucher.getId());
		ServletActionContext.getRequest().setAttribute("voucher", voucher);
		BizCheckResult result = checkResultService.find_Check(voucher);
		ServletActionContext.getRequest().setAttribute("result", result);
		List<BizClaimVoucherDetail> voucherDetails = voucherService.findvoucherDetails(voucher);
		ServletActionContext.getRequest().setAttribute("details", voucherDetails);
		return SUCCESS;
	}
	/**
	 * 财务
	 * @return
	 * @throws Exception
	 */
	public String modify_Tocashier() throws Exception {
		// TODO Auto-generated method stub
		SysEmployee emp = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("login");
		BizClaimVoucher voucher = voucherService.findEClaById(emp, claimVoucher.getId());
		ServletActionContext.getRequest().setAttribute("voucher", voucher);
		BizCheckResult result = checkResultService.find_Check(voucher);
		ServletActionContext.getRequest().setAttribute("result", result);
		List<BizClaimVoucherDetail> voucherDetails = voucherService.findvoucherDetails(voucher);
		ServletActionContext.getRequest().setAttribute("details", voucherDetails);
		return SUCCESS;
	}
	
	public Integer getCurrtent() {
		return currtent;
	}
	public void setCurrtent(Integer currtent) {
		this.currtent = currtent;
	}

	public SysEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(SysEmployee employee) {
		this.employee = employee;
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

	public BizClaimVoucher getClaimVoucher() {
		return claimVoucher;
	}

	public void setClaimVoucher(BizClaimVoucher claimVoucher) {
		this.claimVoucher = claimVoucher;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public BizClaimVoucherDetail getVoucherDetail() {
		return voucherDetail;
	}

	public void setVoucherDetail(BizClaimVoucherDetail voucherDetail) {
		this.voucherDetail = voucherDetail;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BizCheckResult getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(BizCheckResult checkResult) {
		this.checkResult = checkResult;
	}

}
