package com.ada.data.rest.core;

import java.util.ArrayList;
import java.util.List;

import com.ada.data.core.Pagination;
import com.ada.data.rest.domain.PageVo;

public class ConverUtils {

	/**
	 * 从一个对象转换到例外一个对象
	 * 
	 * @param result
	 * @param pager
	 */
	public static <R, S> void cover(PageVo<R> result, Pagination<S> pager) {
		result.setPage(pager.getPageNo());
		result.setSize(pager.getPageSize());
		result.setTotal(pager.getTotalCount());
		result.setTotalPage(pager.getTotalPage());
	}

	public static <R, S> PageVo<R> coverpage(PageVo<R> result, Pagination<S> pager, Conver<R, S> conver) {
		cover(result, pager);
		List<R> vos = new ArrayList<R>();
		List<S> cs = pager.getList();
		if (cs != null) {
			for (S classRoom : cs) {
				vos.add(conver.conver(classRoom));
			}
		}
		result.setList(vos);
		return result;
	}

}
