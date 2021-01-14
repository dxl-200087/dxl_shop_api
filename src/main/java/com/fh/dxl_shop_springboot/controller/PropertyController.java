package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import com.fh.dxl_shop_springboot.model.vo.ReponseData;
import com.fh.dxl_shop_springboot.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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


}
