package com.fh.dxl_shop_springboot.model.vo;

public class ProValTableVo {
    private  Integer page;
    private  Integer limit;
    private Integer startIndex;
    private Integer proid;
    private String craname;

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

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

    public String getCraname() {
        return craname;
    }

    public void setCraname(String craname) {
        this.craname = craname;
    }
}
