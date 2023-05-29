package com.product.detail.entity;

import java.util.List;

public class SearchQuery {
	private String type;
	private String fieldId;
	private String operatorId;
	private List<String> values;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	
}
