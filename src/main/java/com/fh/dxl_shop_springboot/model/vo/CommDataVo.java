package com.fh.dxl_shop_springboot.model.vo;

public class CommDataVo {
    private  Integer page;
    private  Integer limit;
    private Integer startIndex;
    private Integer commBandId;
    private String commName;


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

    public Integer getCommBandId() {
        return commBandId;
    }

    public void setCommBandId(Integer commBandId) {
        this.commBandId = commBandId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }
}
