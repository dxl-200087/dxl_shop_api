package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.model.po.Commodity;
import com.fh.dxl_shop_springboot.model.po.ProValData;
import com.fh.dxl_shop_springboot.model.vo.CommDataVo;
import com.fh.dxl_shop_springboot.model.vo.ReponseData;
import com.fh.dxl_shop_springboot.service.CommodityService;
import com.fh.dxl_shop_springboot.utils.OssFileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/commodity")
@CrossOrigin
public class CommodityController {
    @Resource
    private CommodityService commodityService;

    /*查询所有商品数据
     * 请求路径 http://localhost:8080/api/commodity/selectCommodity?
     * 请求方式 post
     * 请求参数 Commodity commBandId
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @GetMapping("selectCommodity")
    public ReponseData selectCommodity(CommDataVo vo){
        Map map=commodityService.selectCommodity(vo);
        return ReponseData.success(map);
    }

    /*新增商品数据
     * 请求路径 http://localhost:8080/api/commodity/saveCommodity?
     * 请求方式 post
     * 请求参数 Commodity
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("saveCommodity")
    public ReponseData saveCommodity(Commodity commodity,String sku,String noSKU){
        commodityService.saveCommodity(commodity,sku,noSKU);
        return ReponseData.success(null);
    }

    /*图片上传
     * 请求路径 http://localhost:8080/api/commodity/upFile?
     * 请求方式 post
     * 请求参数 file
     * 返回值   {code:200,message:"处理成功",data:图片上传路径}
     * */
    @PostMapping("upFile")
    public ReponseData upFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String newName="images/"+UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        String str= OssFileUtils.upLoadFile(file.getInputStream(), newName);
        return ReponseData.success(str);
    }

    /*根据id查询单条数据
     * 请求路径 http://localhost:8080/api/commodity/selectCommodityByid?
     * 请求方式 get
     * 请求参数 id
     * 返回值   {code:200,message:"处理成功",data:Commodity对象}
     * */
    @GetMapping("selectCommodityByid")
    public ReponseData selectCommodityByid(Integer id){
        Commodity commodity=commodityService.selectCommodityByid(id);
        return ReponseData.success(commodity);
    }

    /*修改商品数据
     * 请求路径 http://localhost:8080/api/commodity/updateCommodity?
     * 请求方式 post
     * 请求参数 Commodity
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("updateCommodity")
    public ReponseData updateCommodity(Commodity commodity){
        commodityService.updateCommodity(commodity);
        return ReponseData.success(null);
    }

    /*修改isDel属性
     * 请求路径 http://localhost:8080/api/commodity/deleteCommodity?
     * 请求方式 post
     * 请求参数 Commodity
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("deleteCommodity")
    public ReponseData deleteCommodity(Commodity commodity){
        commodityService.deleteCommodity(commodity);
        return ReponseData.success(null);
    }

    /*根据proid查询属性值
     * 请求路径 http://localhost:8080/api/commodity/selectProValDataByPid?
     * 请求方式 get
     * 请求参数 proid
     * 返回值   {code:200,message:"处理成功",data:[{ProValData对象},{ProValData对象}]}
     * */
    @GetMapping("selectProValDataByPid")
    public ReponseData selectProValDataByPid(Integer proid){
        List<ProValData> list=commodityService.selectProValDataByPid(proid);
     return ReponseData.success(list);
    }



}
