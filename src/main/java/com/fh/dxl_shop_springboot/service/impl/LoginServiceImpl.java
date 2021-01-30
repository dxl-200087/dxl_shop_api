package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.LoginDao;
import com.fh.dxl_shop_springboot.model.po.LoginUser;
import com.fh.dxl_shop_springboot.service.LoginService;
import com.fh.dxl_shop_springboot.utils.Md5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginDao loginDao;


    @Override
    public Map addUser(LoginUser loginUser) {
        Map map=new HashMap();
        LoginUser user=loginDao.selectUserByName(loginUser.getName());
        if(user!=null){
            map.put("code",0);
        }else {
            String pass = Md5Utils.getMD5(loginUser.getPassword());
            String name = Md5Utils.getMD5(loginUser.getName());
            String md5 = Md5Utils.getMD5(name + pass);
            loginUser.setPassword(md5);
            loginUser.setCreateDate(new Date());
            loginUser.setUpdateDate(new Date());
            loginDao.addUser(loginUser);
            map.put("code",1);
        }
        return map;
    }

    @Override
    public Map loginUser(String name, String password) {
        Map map=new HashMap();
        LoginUser user=loginDao.selectUserByName(name);
        if(user==null){
            map.put("code",1);
        }else {
            String md5pass = Md5Utils.getMD5(password);
            String md5name = Md5Utils.getMD5(name);
            String md5 = Md5Utils.getMD5(md5name + md5pass);
            if(user.getPassword().equals(md5)){
                map.put("code",2);
                map.put("img",user.getImgUrl());
            }else {
                map.put("code",3);
            }
        }
        return map;
    }


}
