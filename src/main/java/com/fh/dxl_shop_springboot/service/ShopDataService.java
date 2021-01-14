package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.ShopData;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;

import java.util.Map;

public interface ShopDataService {

    Map selectShopData(DataTablesVo vo);

    void saveShopData(ShopData shopData);

    ShopData selectShopByid(Integer id);

    void updateShopData(ShopData shopData);
}
