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

import cn.jboa.pojo.SysEmployee;
import cn.jboa.pojo.SysPosition;
import oracle.net.aso.q;

@Repository("employeeDao")
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{
	public EmployeeDaoImpl() {	}
	@Autowired
	public EmployeeDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	/**
	 * µÇÂ¼
	 */
	public SysEmployee findLogin(final SysEmployee employee) {
		
		// TODO Auto-generated method stub
		return  this.getHibernateTemplate().execute(new HibernateCallback<SysEmployee>() {
			public SysEmployee doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "from SysEmployee as d"
						+ " where d.sn = '"+employee.getSn()+"' and d.password = '"
						+ employee.getPassword() +"'";
				Query query = session.createQuery(hql);
				if (query.list().size()>0) {
						return (SysEmployee) query.uniqueResult();
				}else {
					return null;
				}
			}
		});
	}
	public SysEmployee findPosEmp(final SysPosition sysPosition) {
		// TODO Auto-generated method stub
		return  this.getHibernateTemplate().execute(new HibernateCallback<SysEmployee>() {
			public SysEmployee doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "from SysEmployee as a where a.sysPosition = :sysPosition";
				Query query = session.createQuery(hql);
				query.setParameter("sysPosition", sysPosition);
				return (SysEmployee) query.uniqueResult();
			}
		});
	}

}
