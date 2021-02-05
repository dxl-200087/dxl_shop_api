package com.fh.dxl_shop_springboot.controller;

import com.fh.dxl_shop_springboot.model.po.LoginUser;
import com.fh.dxl_shop_springboot.model.vo.ReponseData;
import com.fh.dxl_shop_springboot.service.LoginService;
import com.fh.dxl_shop_springboot.utils.OssFileUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/loginController")
@CrossOrigin
public class LoginController {
    @Resource
    private LoginService loginService;


    /*头像上传
     * 请求路径 http://localhost:8080/api/loginController/addLoginUpFile?
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

    /*注册
     * 请求路径 http://localhost:8080/api/loginController/addUser?
     * 请求方式 post
     * 请求参数 LoginUser对象
     * 返回值   {code:200,message:"处理成功",data:{code:0}}
     * code   0 用户已存在    1  注册成功
     * */
    @PostMapping("addUser")
    public ReponseData addUser(LoginUser loginUser){
        Map map=loginService.addUser(loginUser);
        return ReponseData.success(map);
    }

    /*登录
     * 请求路径 http://localhost:8080/api/loginController/loginUser?
     * 请求方式 post
     * 请求参数 name password
     * 返回值   {code:200,message:"处理成功",data:{code:0}}
     * code   1 用户不存在    2  登陆成功     3  密码错误
     * */
    @PostMapping("loginUser")
    public ReponseData loginUser(String name,String password){
        Map map=loginService.loginUser(name,password);
        return ReponseData.success(map);
    }



}
