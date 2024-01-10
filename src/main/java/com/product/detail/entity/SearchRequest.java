package com.product.detail.entity;

import java.util.List;
import java.util.Objects;

public class SearchRequest {
	@Override
	public String toString() {
		return "SearchRequest [fieldIds=" + fieldIds + ", order=" + order + ", query=" + query + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(fieldIds, order, query);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchRequest other = (SearchRequest) obj;
		return Objects.equals(fieldIds, other.fieldIds) && Objects.equals(order, other.order)
				&& Objects.equals(query, other.query);
	}
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
