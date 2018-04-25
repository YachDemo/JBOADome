package cn.jboa.common;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.jboa.pojo.SysEmployee;

/**
 * À¹½ØÆ÷Àà
 * @author Yach
 *
 */
public class AuthInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session = invocation.getInvocationContext().getSession();
		SysEmployee employee = (SysEmployee) session.get("login");
		if (employee==null) {
			return Action.LOGIN;
		}
			return invocation.invoke();
	}

}
