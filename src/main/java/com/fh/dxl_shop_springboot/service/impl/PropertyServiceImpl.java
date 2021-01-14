package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.PropertyDao;
import com.fh.dxl_shop_springboot.model.po.ShopProperty;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import com.fh.dxl_shop_springboot.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        List<ShopProperty> list=propertyDao.selectProperty(vo);
        Map map=new HashMap();
        map.put("code",0);
        map.put("data",list);
        map.put("count",count);
        return map;
    }
}
