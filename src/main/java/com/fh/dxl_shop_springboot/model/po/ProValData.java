package com.fh.dxl_shop_springboot.model.po;

public class ProValData {
    private Integer id;
    private Integer proid;
    private String skuData; // {"1":3,"2":9}
    private Integer stocks;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getSkuData() {
        return skuData;
    }

    public void setSkuData(String skuData) {
        this.skuData = skuData;
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
