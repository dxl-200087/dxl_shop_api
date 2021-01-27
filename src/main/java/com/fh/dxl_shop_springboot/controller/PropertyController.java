package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.model.po.ShopProperty;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import com.fh.dxl_shop_springboot.model.vo.ReponseData;
import com.fh.dxl_shop_springboot.model.vo.SelectProVal;
import com.fh.dxl_shop_springboot.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/property")
@CrossOrigin
public class PropertyController {
    @Resource
    private PropertyService propertyService;

    /*查询所有的属性数据
     * 请求路径 http://localhost:8080/api/property/selectProperty
     * 请求方式 get
     * 请求参数 DataTablesVo对象
     * 返回值   {code:200,message:"处理成功",data:{code:0,count:count,data:[{},{}]}}
     * */
    @GetMapping("selectProperty")
    public ReponseData selectProperty(DataTablesVo vo){
        Map map=propertyService.selectProperty(vo);
        return ReponseData.success(map);
    }

    /*新增属性数据
     * 请求路径 http://localhost:8080/api/property/saveProperty?
     * 请求方式 post
     * 请求参数 ShopProperty对象
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("saveProperty")
    public ReponseData saveProperty(ShopProperty shopProperty){
        propertyService.saveProperty(shopProperty);
        return ReponseData.success(null);
    }

    /*查询回显属性数据
     * 请求路径 http://localhost:8080/api/property/selectPropertyByid?
     * 请求方式 get
     * 请求参数 id
     * 返回值   {code:200,message:"处理成功",data:{ShopProperty对象}}
     * */
    @GetMapping("selectPropertyByid")
    public ReponseData selectPropertyByid(Integer id){
        ShopProperty shopProperty=propertyService.selectPropertyByid(id);
        return ReponseData.success(shopProperty);
    }

    /*修改属性数据
     * 请求路径 http://localhost:8080/api/property/updateProperty?
     * 请求方式 post
     * 请求参数 ShopProperty对象
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("updateProperty")
    public ReponseData updateProperty(ShopProperty shopProperty){
        propertyService.updateProperty(shopProperty);
        return ReponseData.success(null);
    }

    /*回显  根据typeId查询对应所有属性的数据   回显sku和nosku的属性用
     * 请求路径 http://localhost:8080/api/property/selectProByTypeId?
     * 请求方式 get
     * 请求参数 typeId
     * 返回值   {code:200,message:"处理成功",data:ShopProperty对象}
     * */
    @GetMapping("selectProByTypeId")
    public ReponseData selectProByTypeId(Integer typeId){
        Map map=propertyService.selectProByTypeId(typeId);
        return ReponseData.success(map);
    }

    /*回显  根据proid查询对应所有的skuTable数据  回显sku的table用
     * 请求路径 http://localhost:8080/api/property/selectSkuTable?
     * 请求方式 get
     * 请求参数 proid
     * 返回值   {code:200,message:"处理成功",data:ProValData对象}
     * */
    @GetMapping("selectSkuTable")
    public ReponseData selectSkuTable(Integer proid){
        Map map=propertyService.selectSkuTable(proid);
        return ReponseData.success(map);
    }

    /*回显  根据proid查询对应所有的skuTable数据  回显sku的table用
     * 请求路径 http://localhost:8080/api/property/updateProValAttrData?
     * 请求方式 post
     * 请求参数 sku,nosku,proid
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("updateProValAttrData")
    public ReponseData updateProValAttrData(String sku,String nosku,Integer proid){
        propertyService.updateProValAttrData(sku,nosku,proid);
        return ReponseData.success(null);
    }


}
