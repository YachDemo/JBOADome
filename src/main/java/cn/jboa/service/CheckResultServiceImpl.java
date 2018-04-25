package cn.jboa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jboa.dao.CheckResultDao;
import cn.jboa.pojo.BizCheckResult;
import cn.jboa.pojo.BizClaimVoucher;

@Service("checkResultService")
public class CheckResultServiceImpl implements CheckResultService {

	@Resource(name="checkResultDao")
	private CheckResultDao checkResultDao;
	
	public void save_resultManage(BizCheckResult checkResult) {
		// TODO Auto-generated method stub
		checkResultDao.save_resultManage(checkResult);
	}

	public BizCheckResult find_Check(BizClaimVoucher voucher) {
		// TODO Auto-generated method stub
		return checkResultDao.find_check(voucher);
	}

}
