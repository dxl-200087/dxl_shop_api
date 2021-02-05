package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.UserDao;
import com.fh.dxl_shop_springboot.model.po.LoginUser;
import com.fh.dxl_shop_springboot.model.vo.UserTableDataVo;
import com.fh.dxl_shop_springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;


    @Override
    public Map selectUserData(UserTableDataVo tableVo) {
        Map map=new HashMap();
        Long count=userDao.SelectUserCount(tableVo);
        tableVo.setStartIndex((tableVo.getPage()-1)*tableVo.getLimit());
        List<LoginUser> list=userDao.selectUserData(tableVo);
        map.put("data",list);
        map.put("count",count);
        return map;
    }

    @Override
    public LoginUser selectUserByid(Integer id) {
        LoginUser loginUser=userDao.selectUserByid(id);
        return loginUser;
    }

    @Override
    public void updateUser(LoginUser loginUser) {
        loginUser.setUpdateDate(new Date());
        userDao.updateUser(loginUser);
    }
}
