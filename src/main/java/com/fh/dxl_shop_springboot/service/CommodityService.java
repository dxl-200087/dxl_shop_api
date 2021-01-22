package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.Commodity;
import com.fh.dxl_shop_springboot.model.po.ProValData;
import com.fh.dxl_shop_springboot.model.vo.CommDataVo;

import java.util.List;
import java.util.Map;

public interface CommodityService {

    void saveCommodity(Commodity commodity,String sku,String noSKU);

    Commodity selectCommodityByid(Integer id);

    void updateCommodity(Commodity commodity);

    Map selectCommodity(CommDataVo vo);

    void deleteCommodity(Commodity commodity);

    List<ProValData> selectProValDataByPid(Integer proid);
}
