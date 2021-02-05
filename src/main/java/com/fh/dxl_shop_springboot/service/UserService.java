package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.LoginUser;
import com.fh.dxl_shop_springboot.model.vo.UserTableDataVo;

import java.util.Map;

public interface UserService {

    Map selectUserData(UserTableDataVo tableVo);

    LoginUser selectUserByid(Integer id);

    void updateUser(LoginUser loginUser);
}
