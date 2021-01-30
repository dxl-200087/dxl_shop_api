package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.LoginUser;

import java.util.Map;

public interface LoginService {
    Map addUser(LoginUser loginUser);

    Map loginUser(String name, String password);
}
