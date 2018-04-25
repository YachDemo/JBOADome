package cn.jboa.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 * @author Yach
 *
 * @param <T>
 */
public class Page<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer currtentPage;//当前页
	private Integer totalPage;//总页数
	private Integer totalCount;//总记录数
	private Integer pageSize;//每页数据
	private List<T> result = new ArrayList<T>();//数据集
	
	public Integer getCurrtentPage() {
		return currtentPage;
	}
	public void setCurrtentPage(Integer currtentPage) {
		this.currtentPage = currtentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Page [currtentPage=" + currtentPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + ", result=" + result + "]";
	}

}
