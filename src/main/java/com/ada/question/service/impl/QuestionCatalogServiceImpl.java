package com.ada.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.question.dao.QuestionCatalogDao;
import com.ada.question.entity.QuestionCatalog;
import com.ada.question.page.QuestionCatalogPage;
import com.ada.question.service.QuestionCatalogService;

@Service
@Transactional
public class QuestionCatalogServiceImpl implements QuestionCatalogService {
	@Transactional(readOnly = true)
	public QuestionCatalogPage getPage(int pageNo, int pageSize) {
	    QuestionCatalogPage result=null;
		Pagination<QuestionCatalog> page = dao.getPage(pageNo, pageSize);
		result=new QuestionCatalogPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	public QuestionCatalog findById(Integer id) {
		QuestionCatalog entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public QuestionCatalog save(QuestionCatalog bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public QuestionCatalog update(QuestionCatalog bean) {
		Updater<QuestionCatalog> updater = new Updater<QuestionCatalog>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public QuestionCatalog deleteById(Integer id) {
		QuestionCatalog bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public QuestionCatalog[] deleteByIds(Integer[] ids) {
		QuestionCatalog[] beans = new QuestionCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private QuestionCatalogDao dao;

	@Autowired
	public void setDao(QuestionCatalogDao dao) {
		this.dao = dao;
	}

	@Override
	public List<QuestionCatalog> findChild(int pid) {
		Finder finder = Finder.create("from QuestionCatalog t where t.parent.id=" + pid);
		finder.append(" order by t.sortnum asc");
		finder.setCacheable(true);
		return dao.find(finder);
	}
}