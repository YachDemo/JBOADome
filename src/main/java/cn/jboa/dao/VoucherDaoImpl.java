package cn.jboa.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.jboa.pojo.BizClaimVoucher;
import cn.jboa.pojo.BizClaimVoucherDetail;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.pojo.SysPosition;
import cn.jboa.utils.Page;

@Repository("voucherDao")
public class VoucherDaoImpl extends HibernateDaoSupport implements VoucherDao {
	public VoucherDaoImpl() {	}
	
	@Autowired
	public VoucherDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	/**
	 * 查询总记录数
	 */
	public Integer findCountCla(final Map<String, Object> map,final SysEmployee employee) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = null;
				Query query = null;
				if (map.get("manager")!=null) {
					hql = "select count(*) from BizClaimVoucher as a where"
							+ " a.sysEmployeeByNextDealSn = :employee and a.status != '新创建'";
				}else {
					hql = "select count(*) from BizClaimVoucher as a where a.sysEmployeeByCreateSn"
							+ " = :employee";
				}
				if ("all".equals(map.get("stauts")) || "".equals(map.get("stauts"))
						|| map.get("stauts")==null) {
					if (map.get("manager")!=null) {
						hql = "select count(*) from BizClaimVoucher as a where"
								+ " a.sysEmployeeByNextDealSn = :employee and a.status != '新创建'";
					}else {
						hql = "select count(*) from BizClaimVoucher as a where a.sysEmployeeByCreateSn"
								+ " = :employee";
					}
				}else {
					if(map.get("stauts")!=null) {
						hql += " and a.status = '"+map.get("stauts")+"'";
					}
				}
				if(map.get("beginTime")!=null || "".equals(map.get("beginTime"))) {
					hql += " and a.createTime >= :beginTime";
				}
				if(map.get("overTime") != null || "".equals(map.get("overTime"))) {
					hql += " and a.createTime <= :overTime";
				}
				
				query = session.createQuery(hql);
				if(map.get("beginTime")!=null) {
					query.setDate("beginTime", (Date)map.get("beginTime"));
				}
				if(map.get("overTime")!=null) {
					query.setDate("overTime", (Date)map.get("overTime"));
				}
				query.setParameter("employee", employee);
				Number count = (Number)query.uniqueResult();
				return count.intValue();
			}
		});
	}

	/**
	 * 查询个人报销表
	 */
	public List<BizClaimVoucher> findPageCla(final Map<String, Object> map, final SysEmployee employee,final Page<BizClaimVoucher> page) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<List<BizClaimVoucher>>() {
			@SuppressWarnings("unchecked")
			public List<BizClaimVoucher> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = null;
				Query query = null;
				if (map.get("manager")!=null) {
					hql = "from BizClaimVoucher as a where 1=1 and"
							+ " a.sysEmployeeByNextDealSn = :employee and a.status != '新创建'";
				}else {
					hql = "from BizClaimVoucher as a where 1=1 and a.sysEmployeeByCreateSn"
							+ " = :employee";
				}
				if ("all".equals(map.get("stauts")) || "".equals(map.get("stauts"))
						|| map.get("stauts")==null) {
					if (map.get("manager")!=null) {
						hql = "from BizClaimVoucher as a where 1=1 and"
								+ " a.sysEmployeeByNextDealSn = :employee and a.status != '新创建'";
					}else {
						hql = "from BizClaimVoucher as a where 1=1 and a.sysEmployeeByCreateSn"
								+ " = :employee";
					}
				}else {
					if(map.get("stauts")!=null) {
						hql += " and a.status = '"+map.get("stauts")+"'";
					}
				}
				if(map.get("beginTime")!=null) {
					hql += " and a.createTime >= :beginTime";
				}
				if(map.get("overTime")!=null) {
					hql += " and a.createTime <= :overTime";
				}
				query = session.createQuery(hql);
				
				if(map.get("beginTime")!=null) {
					query.setDate("beginTime", (Date)map.get("beginTime"));
				}
				if(map.get("overTime")!=null) {
					query.setDate("overTime", (Date)map.get("overTime"));
				}
				query.setFirstResult((page.getCurrtentPage()-1)*(page.getPageSize()));
				query.setMaxResults(page.getPageSize());
				query.setParameter("employee", employee);
				List<BizClaimVoucher> list = query.list();
				return list;
			}
			});
	}

	
	

	/**
	 * 删除
	 */
	public boolean delECla(long id) {
		// TODO Auto-generated method stub
		try {
			BizClaimVoucher bizClaimVoucher = this.getHibernateTemplate().load(BizClaimVoucher.class, id);
			this.getHibernateTemplate().delete(bizClaimVoucher);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public BizClaimVoucher findEClaById(final SysEmployee emp, final long id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<BizClaimVoucher>() {
			public BizClaimVoucher doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = null;
				if ("manager".equals(emp.getSysPosition().getNameEn()) || "generalmanager".equals(emp.getSysPosition().getNameEn()) 
						|| "cashier".equals(emp.getSysPosition().getNameEn())
						) {
					 hql = "from BizClaimVoucher as a where 1=1 and a.sysEmployeeByNextDealSn"
							+ " = :employee and a.id = :id";
				}else {
					  hql = "from BizClaimVoucher as a where 1=1 and a.sysEmployeeByCreateSn"
								+ " = :employee and a.id = :id";
				}
				Query query = session.createQuery(hql);
				query.setParameter("employee", emp);
				query.setParameter("id", id);
				return (BizClaimVoucher) query.uniqueResult();
			}
			
		});
	}

	public List<BizClaimVoucherDetail> findvoucherDetails(final BizClaimVoucher voucher) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<List<BizClaimVoucherDetail>>() {
			public List<BizClaimVoucherDetail> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "from BizClaimVoucherDetail as b where b.bizClaimVoucher = :voucher";
				Query query = session.createQuery(hql);
				query.setParameter("voucher", voucher);
				return query.list();
			}
			
		});
	}


	public void add_Cla(BizClaimVoucher claimVoucher) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(claimVoucher);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void add_Detail(BizClaimVoucherDetail voucherDetails) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(voucherDetails);
		
	}

	public BizClaimVoucher find_Cla_id(final long id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<BizClaimVoucher>() {
			public BizClaimVoucher doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "from BizClaimVoucher where id = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				return (BizClaimVoucher) query.uniqueResult();
			}
			
		});
	}

	public List<BizClaimVoucherDetail> find_Detail_Cla(final BizClaimVoucher voucher) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<List<BizClaimVoucherDetail>>() {
			public List<BizClaimVoucherDetail> doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "from BizClaimVoucherDetail as a where a.bizClaimVoucher = :voucher";
				Query query = session.createQuery(hql);
				query.setParameter("voucher", voucher);
				return query.list();
			}
			
		});
	}

	public SysPosition find_Pos_Emp(final SysEmployee employee) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<SysPosition>() {
			public SysPosition doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "from SysPosition as a where a.sysEmployees = :employee";
				Query query = session.createQuery(hql);
				query.setParameter("employee", employee);
				return (SysPosition) query.uniqueResult();
			}
		});
	}

	public boolean del_Detail(Long id) {
		// TODO Auto-generated method stub
		try {
			BizClaimVoucherDetail bizClaimVoucher = this.getHibernateTemplate().load(BizClaimVoucherDetail.class, id);
			this.getHibernateTemplate().delete(bizClaimVoucher);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public void modify_Cla(BizClaimVoucher claimVoucher) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(claimVoucher);
	}
}
