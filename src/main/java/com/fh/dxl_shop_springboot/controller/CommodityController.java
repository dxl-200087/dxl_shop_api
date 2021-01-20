package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.service.CommodityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/commodity")
@CrossOrigin
public class CommodityController {
    @Resource
    private CommodityService commodityService;



}
