package com.ada.feed.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.feed.entity.Feed;
import com.ada.feed.page.FeedCommentPage;

public interface FeedDao extends BaseDao<Feed, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Feed findById(Long id);

	public Feed save(Feed bean);

	public Feed updateByUpdater(Updater<Feed> updater);

	public Feed deleteById(Long id);
	

}