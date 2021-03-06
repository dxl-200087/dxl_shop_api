package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.ShopProperty;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import com.fh.dxl_shop_springboot.model.vo.SelectProVal;

import java.util.List;
import java.util.Map;

public interface PropertyService {
    Map selectProperty(DataTablesVo vo);

    void saveProperty(ShopProperty shopProperty);

    ShopProperty selectPropertyByid(Integer id);

    void updateProperty(ShopProperty shopProperty);

    Map selectProByTypeId(Integer typeId);

    Map selectSkuTable(Integer proid);

    void updateProValAttrData(String sku, String nosku, Integer proid);
}
