package com.product.detail.entity;

import java.util.List;

public class SearchRequest {
	private List<String> fieldIds;
	private List<SearchOrder> order;
	private List<SearchQuery> query;
	public List<String> getFieldIds() {
		return fieldIds;
	}
	public void setFieldIds(List<String> fieldIds) {
		this.fieldIds = fieldIds;
	}
	public List<SearchOrder> getOrder() {
		return order;
	}
	public void setOrder(List<SearchOrder> order) {
		this.order = order;
	}
	public List<SearchQuery> getQuery() {
		return query;
	}
	public void setQuery(List<SearchQuery> query) {
		this.query = query;
	}
	
	
}
