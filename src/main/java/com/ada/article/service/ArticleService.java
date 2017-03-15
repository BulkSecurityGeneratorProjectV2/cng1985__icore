package com.ada.article.service;

import java.util.List;

import com.ada.article.entity.Article;
import com.ada.article.page.ArticlePage;
import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;



public interface ArticleService {
	public Pagination getPage(int pageNo, int pageSize);

	public Article findById(Long id);
	public Article view(Long id);

	public Article save(Article bean,String... tag);
	
	public Article addTag(Long id,String tag);

	public Article addTagS(Long id,List<String> tags);
	
	public Article resetTagS(Long id,List<String> tags);

	public Article update(Article bean);

	public Article deleteById(Long id);
	
	public Article[] deleteByIds(Long[] ids);
	
	public ArticlePage pageByCatalog(int catalog,int pageNo, int pageSize);
	
	public ArticlePage pageByCatalog(long uid,int catalog,int pageNo, int pageSize);
	
	public Page<Article> findPage(Pageable pageable);



}