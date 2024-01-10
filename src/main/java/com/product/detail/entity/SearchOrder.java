package com.product.detail.entity;

import java.util.Objects;

public class SearchOrder {
		private String fieldId;
		private String sort;
		public String getFieldId() {
			return fieldId;
		}
		public void setFieldId(String fieldId) {
			this.fieldId = fieldId;
		}
		public String getSort() {
			return sort;
		}
		public void setSort(String sort) {
			this.sort = sort;
		}
		@Override
		public String toString() {
			return "SearchOrder [fieldId=" + fieldId + ", sort=" + sort + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(fieldId, sort);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SearchOrder other = (SearchOrder) obj;
			return Objects.equals(fieldId, other.fieldId) && Objects.equals(sort, other.sort);
		}
		
		
}