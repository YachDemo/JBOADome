package cn.jboa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jboa.dao.PositionDao;
import cn.jboa.pojo.SysPosition;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
	@Resource(name="positionDao")
	private PositionDao positionDao;

	public List<SysPosition> findTest() {
		// TODO Auto-generated method stub
		return positionDao.findTest();
	}

}
