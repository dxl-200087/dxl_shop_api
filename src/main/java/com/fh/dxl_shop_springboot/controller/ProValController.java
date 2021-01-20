package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.model.po.ProValue;
import com.fh.dxl_shop_springboot.model.vo.ProValTableVo;
import com.fh.dxl_shop_springboot.model.vo.ReponseData;
import com.fh.dxl_shop_springboot.service.ProValService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("api/val")
@CrossOrigin
public class ProValController {
    @Resource
    private ProValService proValService;

    /*查询属性对应的属性值
     * 请求路径 http://localhost:8080/api/val/selectByIdLimit?
     * 请求方式 get
     * 请求参数 page、limit、proid 必传
     * 返回值   {code:200,message:"处理成功",data:{}}
     * */
    @GetMapping("selectByIdLimit")
    public ReponseData selectByIdLimit(ProValTableVo vo){
        if(vo.getPage()==null){
            return ReponseData.error("参数不符合");
        }
        if(vo.getLimit()==null){
            return ReponseData.error("参数不符合");
        }
        if(vo.getProid()==null){
            return ReponseData.error("参数不符合");
        }
        Map map=proValService.selectByIdLimit(vo);
        return ReponseData.success(map);
    }

    /*查询属性对应的属性值
     * 请求路径 http://localhost:8080/api/val/saveProVal?
     * 请求方式 post
     * 请求参数 ProValue对象
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("saveProVal")
    public ReponseData saveProVal(ProValue proValue){
        proValService.saveProVal(proValue);
        return ReponseData.success(null);
    }

    /*根据id查询指定一条属性值
     * 请求路径 http://localhost:8080/api/val/selectProValByid?
     * 请求方式 get
     * 请求参数 id
     * 返回值   {code:200,message:"处理成功",data:ProValue对象}
     * */
    @GetMapping("selectProValByid")
    public ReponseData selectProValByid(Integer id){
        ProValue proValue=proValService.selectProValByid(id);
        return ReponseData.success(proValue);
    }

    /*根据id查询指定一条属性值
     * 请求路径 http://localhost:8080/api/val/updateProVal?
     * 请求方式 post
     * 请求参数 ProValue对象
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("updateProVal")
    public ReponseData updateProVal(ProValue proValue){
        proValService.updateProVal(proValue);
        return  ReponseData.success(null);
    }

}
