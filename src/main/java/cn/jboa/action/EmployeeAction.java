package cn.jboa.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.jboa.pojo.SysEmployee;
import cn.jboa.service.EmployeeService;

/**
 * ‘±π§øÿ÷∆¿‡
 * @author Yach
 *
 */
@Controller("employeeAction")
public class EmployeeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	private SysEmployee employee;
	private String message;
	
	public String login() throws Exception {
		// TODO Auto-generated method stub
		if (employee.getSn()!=null || employee.getPassword() != null) {
			SysEmployee emp = employeeService.findLogin(employee);
			if (emp!=null) {
				ServletActionContext.getRequest().getSession().setAttribute("login", emp);
				ServletActionContext.getRequest().getSession().setAttribute("empName", emp.getName());
				ServletActionContext.getRequest().getSession().setAttribute("empSn", emp.getSn());
				if ("manager".equals(emp.getSysPosition().getNameEn())) {
					return "manager";
				}
				if ("generalmanager".equals(emp.getSysPosition().getNameEn())) {
					return "generalmanager";
				}
				if ("cashier".equals(emp.getSysPosition().getNameEn())) {
					return "cashier";
				}
				if ("staff".equals(emp.getSysPosition().getNameEn())) {
					return "staff";
				}
				return ERROR;
			}else {
				this.setMessage("’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°");
				return ERROR;
			}
		}else {
			this.setMessage("«Î ‰»Î’À∫≈√‹¬Î£°");
			return ERROR;
		}
		
	}
	public String out() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession().removeAttribute("login");
		return SUCCESS;
	}

	public SysEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(SysEmployee employee) {
		this.employee = employee;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
