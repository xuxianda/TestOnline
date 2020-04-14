package com.online.domain;

import java.util.List;

public class Page<T> {
	
	private int total;
	private List<T> rows;
	private int sum;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "Page [total=" + total + ", rows=" + rows + ", sum=" + sum + "]";
	}
	
	
}
