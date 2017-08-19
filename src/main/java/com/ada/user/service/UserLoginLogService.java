package com.ada.user.service;

import com.ada.user.entity.UserLoginLog;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

public interface UserLoginLogService {

	UserLoginLog findById(Long id);

	UserLoginLog save(UserLoginLog bean);

	UserLoginLog update(UserLoginLog bean);

	UserLoginLog deleteById(Long id);
	
	UserLoginLog[] deleteByIds(Long[] ids);
	
	Page<UserLoginLog> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserLoginLog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}