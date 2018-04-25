package cn.jboa.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.jboa.pojo.SysPosition;

@Repository("positionDao")
public class PositionDaoImpl extends HibernateDaoSupport implements PositionDao{
	public PositionDaoImpl() {	}
	
	@Autowired
	public PositionDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {	
		this.setSessionFactory(sessionFactory);
	}
	
	public List<SysPosition> findTest() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from SysPosition");
		
	}

}
