package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.ShopProperty;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;

import java.util.Map;

public interface PropertyService {
    Map selectProperty(DataTablesVo vo);

    void saveProperty(ShopProperty shopProperty);
}
