package cn.jboa.service;

import java.util.List;
import java.util.Map;

import cn.jboa.pojo.BizClaimVoucher;
import cn.jboa.pojo.BizClaimVoucherDetail;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.pojo.SysPosition;
import cn.jboa.utils.Page;

public interface VoucherService {

	/**
	 * 查看报销单
	 * @param map
	 * @param Employee
	 * @return
	 */
	Page<BizClaimVoucher> findPageCla(Map<String, Object> map,SysEmployee Employee);

	/**
	 * 删除报销单
	 * @param id
	 * @return
	 */
	boolean delECla(long id);

	/**
	 * 根据报销单id查询
	 * @param emp
	 * @param id
	 * @return
	 */
	BizClaimVoucher findEClaById(SysEmployee emp, long id);

	/**
	 * 报销单从表
	 * @param voucher
	 * @return
	 */
	List<BizClaimVoucherDetail> findvoucherDetails(BizClaimVoucher voucher);

	/**
	 * 添加主报销单
	 * @param claimVoucher
	 */
	void add_Cla(BizClaimVoucher claimVoucher);

	/**
	 * 添加从报销单
	 * @param voucherDetail
	 */
	void add_Detail(BizClaimVoucherDetail voucherDetail);

	BizClaimVoucher find_Cla_id(long id);

	List<BizClaimVoucherDetail> find_Detail_Cla(BizClaimVoucher voucher);

	SysPosition find_Pos_Emp(SysEmployee employee);

	boolean del_Detail(Long id);

	void modify_Cla(BizClaimVoucher claimVoucher);
	
	void findReport();


}
