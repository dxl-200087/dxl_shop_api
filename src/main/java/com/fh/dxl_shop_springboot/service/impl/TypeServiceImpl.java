package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.TypeDao;
import com.fh.dxl_shop_springboot.model.po.ShopType;
import com.fh.dxl_shop_springboot.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao typeDao;

    @Override
    public List<ShopType> selectType() {
        List<ShopType> list=typeDao.selectType();
        return list;
    }

    @Override
    public List<ShopType> selectTypeBypid(Integer pid) {
        List<ShopType> list=typeDao.selectTypeBypid(pid);
        return list;
    }

    @Override
    public Integer saveType(ShopType shopType) {
        shopType.setCreateDate(new Date());
        shopType.setWhoUser("dxl");
        shopType.setIsDel(0);
        typeDao.saveType(shopType);
        return shopType.getId();
    }

    @Override
    public void updateType(ShopType shopType) {
        shopType.setUpdateDate(new Date());
        typeDao.updateType(shopType);
    }

    @Override
    public ShopType selectTypeByid(Integer id) {
        ShopType shopType=typeDao.selectTypeByid(id);
        return shopType;
    }
}
