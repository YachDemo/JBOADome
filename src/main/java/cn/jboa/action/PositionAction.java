package cn.jboa.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.jboa.service.PositionService;

@Controller("positionAction")
public class PositionAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource(name="positionService")
	private PositionService positionService;
	
	public String test() throws Exception {
		// TODO Auto-generated method stub
		positionService.findTest();
		return SUCCESS;
	}

}
