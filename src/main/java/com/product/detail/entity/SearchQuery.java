package com.product.detail.entity;

import java.util.List;
import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(fieldId, operatorId, type, values);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchQuery other = (SearchQuery) obj;
		return Objects.equals(fieldId, other.fieldId) && Objects.equals(operatorId, other.operatorId)
				&& Objects.equals(type, other.type) && Objects.equals(values, other.values);
	}
	@Override
	public String toString() {
		return "SearchQuery [type=" + type + ", fieldId=" + fieldId + ", operatorId=" + operatorId + ", values="
				+ values + "]";
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
