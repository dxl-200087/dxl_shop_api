package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.model.po.UserRole;
import com.fh.dxl_shop_springboot.model.vo.ReponseData;
import com.fh.dxl_shop_springboot.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/role")
@CrossOrigin
public class RoleController {
    @Resource
    private RoleService roleService;

    /*查询权限表所有数据
     * 请求路径 http://localhost:8080/api/role/selectRoleDate?
     * 请求方式 get
     * 请求参数
     * 返回值   {code:200,message:"处理成功",data:UserRole的List集合}
     * */
    @GetMapping("selectRoleDate")
    public ReponseData selectRoleDate(){
        List<UserRole> list=roleService.selectRoleDate();
        return ReponseData.success(list);
    }

    /*新增权限表数据
     * 请求路径 http://localhost:8080/api/role/saveRoleData?
     * 请求方式 post
     * 请求参数 UserRole对象
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("saveRoleData")
    public ReponseData saveRoleData(UserRole userRole){
        roleService.saveRoleData(userRole);
        return ReponseData.success(null);
    }

    /*查询回显权限表数据
     * 请求路径 http://localhost:8080/api/role/selectRoleById?
     * 请求方式 get
     * 请求参数 id
     * 返回值   {code:200,message:"处理成功",data:单条UserRole数据}
     * */
    @GetMapping("selectRoleById")
    public ReponseData selectRoleById(Integer id){
        UserRole userRole=roleService.selectRoleById(id);
        return ReponseData.success(userRole);
    }

    /*修改权限表数据
     * 请求路径 http://localhost:8080/api/role/updateRole?
     * 请求方式 post
     * 请求参数 UserRole对象
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("updateRole")
    public ReponseData updateRole(UserRole userRole){
        roleService.updateRole(userRole);
        return ReponseData.success(null);
    }

}
