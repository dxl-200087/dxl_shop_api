package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.ShopType;

import java.util.List;

public interface TypeService {
    List<ShopType> selectType();

    List<ShopType> selectTypeBypid(Integer pid);

    Integer saveType(ShopType shopType);

    void updateType(ShopType shopType);

    ShopType selectTypeByid(Integer id);
}
