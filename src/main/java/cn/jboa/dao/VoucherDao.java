package cn.jboa.dao;

import java.util.List;
import java.util.Map;

import cn.jboa.pojo.BizClaimVoucher;
import cn.jboa.pojo.BizClaimVoucherDetail;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.pojo.SysPosition;
import cn.jboa.utils.Page;

public interface VoucherDao {

	Integer findCountCla(Map<String, Object> map,SysEmployee employee);

	List<BizClaimVoucher> findPageCla(Map<String, Object> map, SysEmployee employee,Page<BizClaimVoucher> page);


	boolean delECla(long id);

	BizClaimVoucher findEClaById(SysEmployee emp, long id);

	List<BizClaimVoucherDetail> findvoucherDetails(BizClaimVoucher voucher);

	void add_Cla(BizClaimVoucher claimVoucher);

	void add_Detail(BizClaimVoucherDetail voucherDetail);

	BizClaimVoucher find_Cla_id(long id);

	List<BizClaimVoucherDetail> find_Detail_Cla(BizClaimVoucher voucher);

	SysPosition find_Pos_Emp(SysEmployee employee);

	boolean del_Detail(Long id);

	void modify_Cla(BizClaimVoucher claimVoucher);

}
