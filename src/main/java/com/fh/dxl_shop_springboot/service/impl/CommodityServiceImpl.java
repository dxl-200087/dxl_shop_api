package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.CommodityDao;
import com.fh.dxl_shop_springboot.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityDao commodityDao;



}
