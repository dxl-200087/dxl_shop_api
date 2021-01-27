package com.fh.dxl_shop_springboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.dxl_shop_springboot.dao.ProValDao;
import com.fh.dxl_shop_springboot.dao.ProValDataDao;
import com.fh.dxl_shop_springboot.dao.PropertyDao;
import com.fh.dxl_shop_springboot.model.po.ProValData;
import com.fh.dxl_shop_springboot.model.po.ProValue;
import com.fh.dxl_shop_springboot.model.po.ShopProperty;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import com.fh.dxl_shop_springboot.model.vo.PropertyDataVo;
import com.fh.dxl_shop_springboot.model.vo.SelectProVal;
import com.fh.dxl_shop_springboot.service.PropertyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Resource
    private PropertyDao propertyDao;
    @Resource
    private ProValDao proValDao;
    @Resource
    private ProValDataDao proValDataDao;


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
        shopProperty.setUpdateDate(new Date());
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
    @Transactional
    public Map selectProByTypeId(Integer typeId) {
        Map map=new HashMap();
        List<SelectProVal> list=propertyDao.selectProByTypeId(typeId);
        List list1=new ArrayList();
        List list2=new ArrayList();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getType()==2&&list.get(i).getIsSKU()==0){
                List<ProValue> li=proValDao.selectProValueByid(list.get(i).getId());
                list.get(i).setValues(li);
                list1.add(list.get(i));
            }
            if(list.get(i).getIsSKU()==1){
                if(list.get(i).getType()!=3){
                    List<ProValue> li=proValDao.selectProValueByid(list.get(i).getId());
                    list.get(i).setValues(li);
                    list2.add(list.get(i));
                }else {
                    list2.add(list.get(i));
                }
            }
        }
        map.put("skuData",list1);
        map.put("noSkuData",list2);
        return map;
    }

    @Override
    @Transactional
    public Map selectSkuTable(Integer proid) {
        Map map=new HashMap();
        List list=new ArrayList();
        List<ProValData> provalList=proValDataDao.selectSkuTable(proid);
        for (int i = 0; i <provalList.size() ; i++) {
            if(provalList.get(i).getPrice()!=null){
                JSONObject jsonObject = JSON.parseObject(provalList.get(i).getSkuData());
                jsonObject.put("price",provalList.get(i).getPrice());
                jsonObject.put("stocks",provalList.get(i).getStocks());
                list.add(jsonObject);
            }
        }
        map.put("table",list);
        return map;
    }

    @Override
    public void updateProValAttrData(String sku, String nosku, Integer proid) {
        proValDataDao.deleteProValByProid(proid);
        List<ProValData> list=new ArrayList<>();
        JSONArray noObj = JSON.parseArray(nosku);
        for (int i = 0; i <noObj.size() ; i++) {
            ProValData proValData=new ProValData();
            proValData.setProid(proid);
            proValData.setSkuData(noObj.get(i).toString());
            list.add(proValData);
        }
        JSONArray obj= JSON.parseArray(sku);
        for (int i = 0; i <obj.size() ; i++) {
            JSONObject jsonObj= (JSONObject) obj.get(i);
            //创建对象
            ProValData proValData=new ProValData();
            //获取id;
            proValData.setProid(proid);
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


}
