package com.ada.article.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.article.dao.ArticleCatalogDao;
import com.ada.article.entity.ArticleCatalog;

@Repository
public class ArticleCatalogDaoImpl extends BaseDaoImpl<ArticleCatalog, Integer> implements ArticleCatalogDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ArticleCatalog findById(Integer id) {
		ArticleCatalog entity = get(id);
		return entity;
	}

	public ArticleCatalog save(ArticleCatalog bean) {
		getSession().save(bean);
		return bean;
	}

	public ArticleCatalog deleteById(Integer id) {
		ArticleCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ArticleCatalog> getEntityClass() {
		return ArticleCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}