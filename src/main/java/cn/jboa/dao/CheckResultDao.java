package cn.jboa.dao;

import cn.jboa.pojo.BizCheckResult;
import cn.jboa.pojo.BizClaimVoucher;

public interface CheckResultDao {

	void save_resultManage(BizCheckResult checkResult);

	BizCheckResult find_check(BizClaimVoucher voucher);

}
