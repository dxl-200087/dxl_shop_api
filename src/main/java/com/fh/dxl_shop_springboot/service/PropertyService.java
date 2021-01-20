package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.ShopProperty;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;

import java.util.List;
import java.util.Map;

public interface PropertyService {
    Map selectProperty(DataTablesVo vo);

    void saveProperty(ShopProperty shopProperty);

    ShopProperty selectPropertyByid(Integer id);

    void updateProperty(ShopProperty shopProperty);

    List<ShopProperty> selectProByTypeId(Integer typeId);
}
