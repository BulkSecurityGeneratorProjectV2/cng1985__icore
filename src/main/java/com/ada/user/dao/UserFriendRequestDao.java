package com.ada.user.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserFriendRequest;

public interface UserFriendRequestDao extends BaseDao<UserFriendRequest, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserFriendRequest findById(Long id);

	public UserFriendRequest save(UserFriendRequest bean);

	public UserFriendRequest updateByUpdater(Updater<UserFriendRequest> updater);

	public UserFriendRequest deleteById(Long id);
}