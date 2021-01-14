package com.fh.dxl_shop_springboot.model.vo;
//自定义的规范

//  {"status":,"info":,"data":}
public class ReponseData {
	private Integer status;
	private String message;
	private Object data;
	
	private ReponseData() {
		
	}
	
	
	public static ReponseData success(Object data) {
		ReponseData rs=new ReponseData();
		rs.setMessage("处理成功");
		rs.setStatus(200);
		rs.setData(data);
		return  rs;
	}
	
	public static ReponseData error(String message) {
		ReponseData rs=new ReponseData();
		rs.setMessage(message);
		rs.setStatus(500);
		rs.setData(null);
		return  rs;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
