package com.fh.dxl_shop_springboot.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ShopData {
    private Integer id;
    private String name;
    private String bandE;//首字母
    private String imgpath;
    private String bandDesc;//品牌介绍
    private Integer ord;//排序字段
    private Integer isdel;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
    private Date updateDate;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBandE() {
        return bandE;
    }

    public void setBandE(String bandE) {
        this.bandE = bandE;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getBandDesc() {
        return bandDesc;
    }

    public void setBandDesc(String bandDesc) {
        this.bandDesc = bandDesc;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
