package com.fh.dxl_shop_springboot.model.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DataTablesVo {
	//{code:0,data:list,count:count,msg:""}
	private  Integer page;
	private  Integer limit;
	private Integer startIndex;
	private String cratename;


	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public String getCratename() {
		return cratename;
	}

	public void setCratename(String cratename) {
		this.cratename = cratename;
	}
}
