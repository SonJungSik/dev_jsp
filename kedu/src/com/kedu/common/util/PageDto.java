package com.kedu.common.util;

public class PageDto {
	private int firstPage;
	private int lastPage;
	private int prevPage;
	private int nextPage;
	private int isEmpty;
	
	public int getIsEmpty() {
		return isEmpty;
	}
	public void setIsEmpty(int isEmpty) {
		this.isEmpty = isEmpty;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	
}
