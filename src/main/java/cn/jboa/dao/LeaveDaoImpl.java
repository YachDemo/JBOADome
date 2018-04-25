package cn.jboa.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.jboa.pojo.BizLeave;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.utils.Page;

@Repository("leaveDao")
public class LeaveDaoImpl extends HibernateDaoSupport implements LeaveDao {
	public LeaveDaoImpl() {	}
	@Autowired
	public LeaveDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	public List<BizLeave> find_Page(final Map<String, Object> map, final SysEmployee employees, final Page<BizLeave> page) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<List<BizLeave>>() {

			public List<BizLeave> doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = null;
				// TODO Auto-generated method stub
				if ("manager".equals(map.get("post"))) {
					hql = "from BizLeave as l where 1=1 and l.nextDealSn = :employees";
				}else {
					hql = "from BizLeave as l where 1=1 and l.employeeSn = :employees ";
				}
				Query query = null;
				if(map.get("beginTime")!=null || "".equals(map.get("beginTime"))) {
					hql += " and a.createTime >= :beginTime";
				}
				if(map.get("overTime") != null || "".equals(map.get("overTime"))) {
					hql += " and a.createTime <= :overTime";
				}
				
				query = session.createQuery(hql);
				
				if(map.get("beginTime")!=null || "".equals(map.get("beginTime"))) {
					query.setParameter("beginTime", map.get("beginTime"));
				}
				if(map.get("overTime") != null || "".equals(map.get("overTime"))) {
					query.setParameter("overTime", map.get("overTime"));
				}
				query.setParameter("employees", employees);
				query.setFirstResult((page.getCurrtentPage()-1)*(page.getPageSize()));
				query.setMaxResults(page.getPageSize());
				List<BizLeave> list = query.list();
				return list;
			}
		});
	}
	public Integer find_countAll(final Map<String, Object> map, final SysEmployee employees) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = null;
				if ("manager".equals(map.get("post"))) {
					hql = "select count(*) from BizLeave as l where 1=1 and l.nextDealSn = :employees ";
				}else {
					hql = "select count(*) from BizLeave as l where 1=1 and l.employeeSn = :employees ";
				}
				Query query = null;
				if(map.get("beginTime")!=null || "".equals(map.get("beginTime"))) {
					hql += " and a.createTime >= :beginTime";
				}
				if(map.get("overTime") != null || "".equals(map.get("overTime"))) {
					hql += " and a.createTime <= :overTime";
				}
				query = session.createQuery(hql);
				if(map.get("beginTime")!=null || "".equals(map.get("beginTime"))) {
					query.setParameter("beginTime", map.get("beginTime"));
				}
				if(map.get("overTime") != null || "".equals(map.get("overTime"))) {
					query.setParameter("overTime", map.get("overTime"));
				}
				query.setParameter("employees", employees);
				Number number = (Number) query.uniqueResult();
				return number.intValue();
			}
		});
	}
	public BizLeave find_Page_ById(final long id, final SysEmployee employee) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<BizLeave>() {
			public BizLeave doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = null;
				if ("manager".equals(employee.getSysPosition().getNameEn())) {
					hql = "from BizLeave as a where a.nextDealSn = :employee and a.id = :id";
				}else {
					hql = "from BizLeave as a where a.employeeSn = :employee and a.id = :id";
				}
				
				Query query = session.createQuery(hql);
				query.setParameter("employee", employee);
				query.setParameter("id", id);
				return (BizLeave) query.uniqueResult();
			}
		});
	}
	public void modify_lea_manager(BizLeave bizLeave) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(bizLeave);
	}
	public void save_leave(BizLeave leave) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(leave);
	}
	

}
