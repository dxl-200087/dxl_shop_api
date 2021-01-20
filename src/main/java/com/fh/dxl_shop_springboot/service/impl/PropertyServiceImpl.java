package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.PropertyDao;
import com.fh.dxl_shop_springboot.model.po.ShopProperty;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import com.fh.dxl_shop_springboot.model.vo.PropertyDataVo;
import com.fh.dxl_shop_springboot.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Resource
    private PropertyDao propertyDao;

    @Override
    public Map selectProperty(DataTablesVo vo) {
        Long count=propertyDao.selectCount(vo);
        vo.setStartIndex((vo.getPage()-1)*vo.getLimit());
        List<PropertyDataVo> list=propertyDao.selectProperty(vo);
        Map map=new HashMap();
        map.put("code",0);
        map.put("data",list);
        map.put("count",count);
        return map;
    }

    @Override
    public void saveProperty(ShopProperty shopProperty) {
        shopProperty.setCreateDate(new Date());
        shopProperty.setIsDel(0);
        shopProperty.setAuthor("dxl");
        propertyDao.saveProperty(shopProperty);
    }

    @Override
    public ShopProperty selectPropertyByid(Integer id) {
        ShopProperty shopProperty=propertyDao.selectPropertyByid(id);
        return shopProperty;
    }

    @Override
    public void updateProperty(ShopProperty shopProperty) {
        shopProperty.setUpdateDate(new Date());
        shopProperty.setAuthor("dxl");
        propertyDao.updateProperty(shopProperty);
    }

    @Override
    public List<ShopProperty> selectProByTypeId(Integer typeId) {
        List<ShopProperty> list=propertyDao.selectProByTypeId(typeId);
        return list;
    }
}
