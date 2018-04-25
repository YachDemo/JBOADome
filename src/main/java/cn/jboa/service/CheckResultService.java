package cn.jboa.service;

import cn.jboa.pojo.BizCheckResult;
import cn.jboa.pojo.BizClaimVoucher;

public interface CheckResultService {

	void save_resultManage(BizCheckResult checkResult);

	BizCheckResult find_Check(BizClaimVoucher voucher);

}
