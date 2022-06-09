package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;

public class PageForm<T> {
	Page<T> page;
	List<T> pageContent;
	boolean hasPrevious;
	boolean hasNext;
	int totalPage;
	int thisPageNumber;
	
	public PageForm(Page<T> page) {
		this.page = page;
		this.pageContent = page.getContent();
		this.hasPrevious = page.hasPrevious();
		this.hasNext = page.hasNext();
		this.totalPage = page.getTotalPages();
		this.thisPageNumber = page.getPageable().getPageNumber();
	}
}
