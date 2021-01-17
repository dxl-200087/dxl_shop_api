package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.model.po.ShopData;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import com.fh.dxl_shop_springboot.model.vo.ReponseData;
import com.fh.dxl_shop_springboot.service.ShopDataService;
import com.fh.dxl_shop_springboot.utils.FileSaveUtils;
import com.fh.dxl_shop_springboot.utils.OssFileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/shopdata")
@CrossOrigin
public class ShopDataController {
    @Resource
    private ShopDataService shopDataService;

    /*查询商品
     * 请求路径 http://localhost:8080/api/shopdata/selectShopData?
     * 请求方式 get
     * 请求参数 DataTablesVo对象
     * 返回值   {code:200,message:"处理成功",data:id}
     * */
    @GetMapping("selectShopData")
    public ReponseData selectShopData(DataTablesVo vo){
        Map map=new HashMap();
        map=shopDataService.selectShopData(vo);
        return ReponseData.success(map);
    }

    /*文件上传
     * 请求路径 http://localhost:8080/api/shopdata/saveFile?
     * 请求方式 post
     * 请求参数 file
     * 返回值   {code:200,message:"处理成功",data:images(图片路径)}
     * */
    /*@PostMapping("saveFile")
    public ReponseData saveFile(MultipartFile file, HttpServletRequest request){
        String images = FileSaveUtils.saveFile(file, "images", request);
        return ReponseData.success(images);
    }*/
    /*OSS文件上传*/
    @PostMapping("saveFile")
    public ReponseData saveFile(MultipartFile file) throws IOException {
        //处理新名称  防止中文引起的错误
        String originalFilename = file.getOriginalFilename();
        String newName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        newName="images/"+newName;
        String str = OssFileUtils.upLoadFile(file.getInputStream(), newName);
        return ReponseData.success(str);
    }

    /*新增商品
     * 请求路径 http://localhost:8080/api/shopdata/saveShopData?
     * 请求方式 post
     * 请求参数 ShopData对象
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("saveShopData")
    public ReponseData saveShopData(ShopData shopData){
        shopDataService.saveShopData(shopData);
        return ReponseData.success(null);
    }

    /*回显
     * 请求路径 http://localhost:8080/api/shopdata/selectShopByid?
     * 请求方式 get
     * 请求参数 id
     * 返回值   {code:200,message:"处理成功",data:{id:1,name:"",....}}
     * */
    @GetMapping("selectShopByid")
    public ReponseData selectShopByid(Integer id){
        ShopData shopData=shopDataService.selectShopByid(id);
        return ReponseData.success(shopData);
    }

    /*修改
     * 请求路径 http://localhost:8080/api/shopdata/updateShopData?
     * 请求方式 post
     * 请求参数 ShopData对象
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("updateShopData")
    public ReponseData updateShopData(ShopData shopData){
        shopDataService.updateShopData(shopData);
        return ReponseData.success(null);
    }

}
