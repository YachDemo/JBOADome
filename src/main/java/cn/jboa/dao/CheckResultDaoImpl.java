package cn.jboa.dao;


import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.jboa.pojo.BizCheckResult;
import cn.jboa.pojo.BizClaimVoucher;

@Repository("checkResultDao")
public class CheckResultDaoImpl extends HibernateDaoSupport implements CheckResultDao {
	public CheckResultDaoImpl() {	}
	@Autowired
	public CheckResultDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {	
		this.setSessionFactory(sessionFactory);
	}
	
	public void save_resultManage(BizCheckResult checkResult) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(checkResult);
	}
	public BizCheckResult find_check(final BizClaimVoucher voucher) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<BizCheckResult>() {
			public BizCheckResult doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "from BizCheckResult as a where a.bizClaimVoucher = :employee and a.id = (select  max(id) from BizCheckResult)";
				Query query = session.createQuery(hql);
				query.setParameter("employee", voucher);
				return (BizCheckResult) query.uniqueResult();
			}
		});
	}
}
