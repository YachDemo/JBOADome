package cn.jboa.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ҳ������
 * @author Yach
 *
 * @param <T>
 */
public class Page<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer currtentPage;//��ǰҳ
	private Integer totalPage;//��ҳ��
	private Integer totalCount;//�ܼ�¼��
	private Integer pageSize;//ÿҳ����
	private List<T> result = new ArrayList<T>();//���ݼ�
	
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
