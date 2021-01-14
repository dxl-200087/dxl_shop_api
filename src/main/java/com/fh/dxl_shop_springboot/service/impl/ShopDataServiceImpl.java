package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.ShopDataDao;
import com.fh.dxl_shop_springboot.model.po.ShopData;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import com.fh.dxl_shop_springboot.service.ShopDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopDataServiceImpl implements ShopDataService {
    @Resource
    private ShopDataDao shopDataDao;

    @Override
    public Map selectShopData(DataTablesVo vo) {
        Long count=shopDataDao.selectCount(vo);
        vo.setStartIndex((vo.getPage()-1)*vo.getLimit());
        List<ShopData> list=shopDataDao.selectShopData(vo);
        Map map=new HashMap();
        map.put("code",0);
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    @Override
    public void saveShopData(ShopData shopData) {
        shopData.setCreateDate(new Date());
        shopData.setAuthor("dxl");
        shopData.setIsdel(0);
        shopDataDao.saveShopData(shopData);
    }

    @Override
    public ShopData selectShopByid(Integer id) {
        ShopData shopData=shopDataDao.selectShopByid(id);
        return shopData;
    }

    @Override
    public void updateShopData(ShopData shopData) {
        shopData.setUpdateDate(new Date());
        shopData.setAuthor("dxl");
        shopDataDao.updateShopData(shopData);
    }
}
