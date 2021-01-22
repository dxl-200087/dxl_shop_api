package com.fh.dxl_shop_springboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.dxl_shop_springboot.dao.CommodityDao;
import com.fh.dxl_shop_springboot.dao.ProValDataDao;
import com.fh.dxl_shop_springboot.model.po.Commodity;
import com.fh.dxl_shop_springboot.model.po.ProValData;
import com.fh.dxl_shop_springboot.model.vo.CommDataVo;
import com.fh.dxl_shop_springboot.service.CommodityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityDao commodityDao;
    @Resource
    private ProValDataDao proValDataDao;


    @Override
    @Transactional
    public void saveCommodity(Commodity commodity,String sku,String noSKU) {
        commodity.setUpdateDate(new Date());
        commodity.setCreateDate(new Date());
        commodity.setAuthor("dxl");
        commodity.setIsDel(0);
        commodityDao.saveCommodity(commodity);
        List<ProValData> list=new ArrayList<>();
        JSONArray noobj = JSON.parseArray(noSKU);
        for (int i = 0; i <noobj.size() ; i++) {
            ProValData proValData=new ProValData();
            proValData.setProid(commodity.getId());
            proValData.setSkuData(noobj.get(i).toString());
            list.add(proValData);
        }
        JSONArray obj= JSON.parseArray(sku);
        for (int i = 0; i <obj.size() ; i++) {
            JSONObject jsonObj= (JSONObject) obj.get(i);
            //创建对象
            ProValData proValData=new ProValData();
            //获取id;
            proValData.setProid(commodity.getId());
            //给价格和库存赋值
            proValData.setPrice(jsonObj.getDouble("price"));
            proValData.setStocks(jsonObj.getInteger("stocks"));
            jsonObj.remove("price");
            jsonObj.remove("stocks");
            //给skuData字段赋值
            proValData.setSkuData(obj.get(i).toString());
            list.add(proValData);
        }
        proValDataDao.saveProValData(list);
    }

    @Override
    public Commodity selectCommodityByid(Integer id) {
        Commodity commodity=commodityDao.selectCommodityByid(id);
        return commodity;
    }

    @Override
    public void updateCommodity(Commodity commodity) {
        commodity.setUpdateDate(new Date());
        commodity.setAuthor("dxl");
        commodityDao.updateCommodity(commodity);
    }

    @Override
    public Map selectCommodity(CommDataVo vo) {
        Long count=commodityDao.selectCount(vo);
        vo.setStartIndex((vo.getPage()-1)*vo.getLimit());
        List<Commodity> list=commodityDao.selectCommodity(vo);
        Map map=new HashMap();
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    @Override
    public void deleteCommodity(Commodity commodity) {
        commodity.setUpdateDate(new Date());
        commodity.setAuthor("dxl");
        commodityDao.deleteCommodity(commodity);
    }
}
