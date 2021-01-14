package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.model.po.ShopType;
import com.fh.dxl_shop_springboot.model.vo.ReponseData;
import com.fh.dxl_shop_springboot.service.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/type")
@CrossOrigin
public class TypeController {
    @Resource
    private TypeService typeService;

    /*查询所有的分类数据
    * 请求路径 http://localhost:8080/api/type/selectType
    * 请求方式 get
    * 请求参数 null
    * 返回值   {code:200,message:"处理成功",data:[{},{}]}
    * */
    @GetMapping("selectType")
    public ReponseData selectType(){
        List<ShopType> list=typeService.selectType();
        return ReponseData.success(list);
    }

    /*查询指定pid的数据
     * 请求路径 http://localhost:8080/api/type/selectTypeBypid?
     * 请求方式 get
     * 请求参数 pid
     * 返回值   {code:200,message:"处理成功",data:[{},{}]}
     * */
    @GetMapping("selectTypeBypid")
    public ReponseData selectTypeBypid(Integer pid){
        List<ShopType> list=typeService.selectTypeBypid(pid);
        return ReponseData.success(list);
    }

    /*新增分类
     * 请求路径 http://localhost:8080/api/type/saveType?
     * 请求方式 post
     * 请求参数 pid,name
     * 返回值   {code:200,message:"处理成功",data:id}
     * */
    @PostMapping("saveType")
    public ReponseData saveType(ShopType shopType){
        Integer id=typeService.saveType(shopType);
        return ReponseData.success(id);
    }

    /*回显
     * 请求路径 http://localhost:8080/api/type/selectTypeByid?
     * 请求方式 get
     * 请求参数 id
     * 返回值   {code:200,message:"处理成功",data:{id:1,name:'',pid:0}}
     * */
    @GetMapping("selectTypeByid")
    public ReponseData selectTypeByid(Integer id){
        ShopType shopType=typeService.selectTypeByid(id);
        return ReponseData.success(shopType);
    }

    /*修改分类
     * 请求路径 http://localhost:8080/api/type/updateType?
     * 请求方式 post
     * 请求参数 id(必传)  name,pid,isDel
     * 返回值   {code:200,message:"处理成功",data:id}
     * */
    @PostMapping("updateType")
    public ReponseData updateType(ShopType shopType){
        if(shopType.getId()==null){
            return ReponseData.error("请求参数异常");
        }
        typeService.updateType(shopType);
        return ReponseData.success(null);
    }

}
