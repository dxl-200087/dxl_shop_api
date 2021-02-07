package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.model.po.UserPersona;
import com.fh.dxl_shop_springboot.model.vo.PersonaTableVo;
import com.fh.dxl_shop_springboot.model.vo.ReponseData;
import com.fh.dxl_shop_springboot.service.PersonaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("api/persona")
@CrossOrigin
public class PersonaController {
    @Resource
    private PersonaService personaService;

    /*查询所有的角色数据
     * 请求路径 http://localhost:8080/api/persona/selectPersonaData?
     * 请求方式 get
     * 请求参数 PersonaTableVo业务类
     * 返回值   {code:200,message:"处理成功",data:{count:count,data:[{},{}]}}
     * */
    @GetMapping("selectPersonaData")
    public ReponseData selectPersonaData(PersonaTableVo tableVo){
        Map map=personaService.selectPersonaData(tableVo);
        return ReponseData.success(map);
    }

    /*新增角色数据
     * 请求路径 http://localhost:8080/api/persona/savePersona?
     * 请求方式 post
     * 请求参数 UserPersona
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("savePersona")
    public ReponseData savePersona(UserPersona userPersona){
        personaService.savePersona(userPersona);
        return ReponseData.success(null);
    }

    /*根据id回显数据角色数据
     * 请求路径 http://localhost:8080/api/persona/selectPersonaById?
     * 请求方式 get
     * 请求参数 id
     * 返回值   {code:200,message:"处理成功",data:UserPersona单条数据}
     * */
    @GetMapping("selectPersonaById")
    public ReponseData selectPersonaById(Integer id){
        UserPersona userPersona=personaService.selectPersonaById(id);
        return ReponseData.success(userPersona);
    }

    /*修改角色数据
     * 请求路径 http://localhost:8080/api/persona/updatePersona?
     * 请求方式 post
     * 请求参数 name isDel
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("updatePersona")
    public ReponseData updatePersona(UserPersona userPersona){
        personaService.updatePersona(userPersona);
        return ReponseData.success(null);
    }

    /*赋权限回显
     * 请求路径 http://localhost:8080/api/persona/selectPersonaOrMiss?
     * 请求方式 get
     * 请求参数 rid
     * 返回值   {code:200,message:"处理成功",data:{roleData:{{},{}},roleMissData:{{},{}}}}
     * */
    @GetMapping("selectPersonaOrMiss")
    public ReponseData selectPersonaOrMiss(Integer rid){
        Map map=personaService.selectPersonaOrMiss(rid);
        return ReponseData.success(map);
    }

    /*赋权限
     * 请求路径 http://localhost:8080/api/persona/addRoleMenuData?
     * 请求方式 post
     * 请求参数 rid  [1,2,3]
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("addRoleMenuData")
    public ReponseData addRoleMenuData(Integer rid, String roleMenuId){
        personaService.addRoleMenuData(rid,roleMenuId);
        return ReponseData.success(null);
    }


}
