package com.myweb.www.handler;

import com.myweb.www.domain.PagingVO;

public class PagingHandler {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int totalCnt;
	private PagingVO pgvo;

	public PagingHandler(PagingVO pgvo, int totalCnt) {
		this.pgvo = pgvo;
		this.totalCnt = totalCnt;
		this.endPage = (int) (Math.ceil(pgvo.getPageNo() / (pgvo.getQty() * 1.0))) * pgvo.getQty();
		this.startPage = endPage - 9;

		int realEndPage = (int) Math.ceil(totalCnt * 1.0 / pgvo.getQty());

		if (realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEndPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}

	@Override
	public String toString() {
		return "PagingHandler [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", totalCnt=" + totalCnt + ", pgvo=" + pgvo + "]";
	}

}
