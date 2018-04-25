package cn.jboa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.jboa.dao.VoucherDao;
import cn.jboa.pojo.BizClaimVoucher;
import cn.jboa.pojo.BizClaimVoucherDetail;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.pojo.SysPosition;
import cn.jboa.utils.Page;

@Service("voucherService")
public class VoucherServiceImpl implements VoucherService {
	
	@Resource(name="voucherDao")
	private VoucherDao voucherDao;

	/**
	 * 月度报表
	 */
	@Scheduled(cron="0 13 10 ? * *")
	public void findReport() {
		// TODO Auto-generated method stub
		System.out.println("idex");
	}
	
	public Page<BizClaimVoucher> findPageCla(Map<String, Object> map,SysEmployee employee) {
		// TODO Auto-generated method stub
		Page<BizClaimVoucher> page = new Page<BizClaimVoucher>();
		page.setPageSize(4);
		Integer totalCount = voucherDao.findCountCla(map,employee);
		Integer totalPage = (totalCount % page.getPageSize() == 0)
				? (totalCount/page.getPageSize()) : (totalCount /page.getPageSize()+1);
		page.setTotalPage(totalPage);
		page.setTotalCount(totalCount);
		if (map.get("currtent")==null) {
			page.setCurrtentPage(1);
		}else if((Integer)map.get("currtent")>totalPage){
			page.setCurrtentPage(totalPage);
		}else if((Integer)map.get("currtent")<1){
			page.setCurrtentPage(1);
		}else {
			page.setCurrtentPage((Integer)map.get("currtent"));
		}
		List<BizClaimVoucher> result = voucherDao.findPageCla(map,employee,page);
		page.setResult(result);
		return page;
	}

	public boolean delECla(long id) {
		// TODO Auto-generated method stub
		return voucherDao.delECla(id);
	}

	public BizClaimVoucher findEClaById(SysEmployee emp, long id) {
		// TODO Auto-generated method stub
		return voucherDao.findEClaById(emp,id);
	}

	public List<BizClaimVoucherDetail> findvoucherDetails(BizClaimVoucher voucher) {
		// TODO Auto-generated method stub
		return voucherDao.findvoucherDetails(voucher);
	}


	public void add_Cla(BizClaimVoucher claimVoucher) {
		// TODO Auto-generated method stub
		voucherDao.add_Cla(claimVoucher);
	}

	public void add_Detail(BizClaimVoucherDetail voucherDetail) {
		// TODO Auto-generated method stub
		voucherDao.add_Detail(voucherDetail);
	}

	public BizClaimVoucher find_Cla_id(long id) {
		// TODO Auto-generated method stub
		return voucherDao.find_Cla_id(id);
	}

	public List<BizClaimVoucherDetail> find_Detail_Cla(BizClaimVoucher voucher) {
		// TODO Auto-generated method stub
		return voucherDao.find_Detail_Cla(voucher);
	}

	public SysPosition find_Pos_Emp(SysEmployee employee) {
		// TODO Auto-generated method stub
		return voucherDao.find_Pos_Emp(employee);
	}

	public boolean del_Detail(Long id) {
		// TODO Auto-generated method stub
		return voucherDao.del_Detail(id);
	}

	public void modify_Cla(BizClaimVoucher claimVoucher) {
		// TODO Auto-generated method stub
		voucherDao.modify_Cla(claimVoucher);
	}
	
	

}
