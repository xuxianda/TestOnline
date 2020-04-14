package com.online.domain;

import org.springframework.stereotype.Component;

@Component
public class UserRecordDomain {
		private int order;
		private String value;
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
}
