package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.model.po.LoginUser;
import com.fh.dxl_shop_springboot.model.vo.ReponseData;
import com.fh.dxl_shop_springboot.model.vo.UserTableDataVo;
import com.fh.dxl_shop_springboot.service.UserService;
import com.fh.dxl_shop_springboot.utils.OssFileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    /*查询所有的用户数据
     * 请求路径 http://localhost:8080/api/user/selectUserData?
     * 请求方式 get
     * 请求参数 UserTableDataVo业务类
     * 返回值   {code:200,message:"处理成功",data:{count:count,data:{{},{}}}}
     * */
    @GetMapping("selectUserData")
    public ReponseData selectUserData(UserTableDataVo tableVo){
        Map map=userService.selectUserData(tableVo);
        return ReponseData.success(map);
    }

    /*头像上传
     * 请求路径 http://localhost:8080/api/user/addLoginUpFile?
     * 请求方式 post
     * 请求参数 file
     * 返回值   {code:200,message:"处理成功",data:图片上传路径}
     * */
    @PostMapping("addLoginUpFile")
    public ReponseData saveFile(MultipartFile file) throws IOException {
        //处理新名称  防止中文引起的错误
        String originalFilename = file.getOriginalFilename();
        String newName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        String str = OssFileUtils.upLoadFile(file.getInputStream(), ("images/"+newName));
        return ReponseData.success(str);
    }

    /*根据id查询用户数据
     * 请求路径 http://localhost:8080/api/user/selectUserByid?
     * 请求方式 get
     * 请求参数 id
     * 返回值   {code:200,message:"处理成功",data:LoginUser单条数据}
     * */
    @GetMapping("selectUserByid")
    public ReponseData selectUserByid(Integer id){
        LoginUser loginUser=userService.selectUserByid(id);
        return ReponseData.success(loginUser);
    }

    /*根据id查询用户数据
     * 请求路径 http://localhost:8080/api/user/updateUser?
     * 请求方式 post
     * 请求参数 LoginUser
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("updateUser")
    public ReponseData updateUser(LoginUser loginUser){
        userService.updateUser(loginUser);
        return ReponseData.success(null);
    }

    /*赋角色回显
     * 请求路径 http://localhost:8080/api/user/selectGiveUserPer?
     * 请求方式 get
     * 请求参数 userid
     * 返回值   {code:200,message:"处理成功",data:{perList:{},userper:{}}}
     * */
    @GetMapping("selectGiveUserPer")
    public ReponseData selectGiveUserPer(Integer id){
        Map map=userService.selectGiveUserPer(id);
        return ReponseData.success(map);
    }

    /*赋角色
     * 请求路径 http://localhost:8080/api/user/addUserPer?
     * 请求方式 post
     * 请求参数 uid,list
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("addUserPer")
    public ReponseData addUserPer(Integer uid,String userPerList){
        userService.addUserPer(uid,userPerList);
        return ReponseData.success(null);
    }


}
