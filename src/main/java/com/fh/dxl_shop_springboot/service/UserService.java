package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.LoginUser;
import com.fh.dxl_shop_springboot.model.po.UserRole;
import com.fh.dxl_shop_springboot.model.vo.UserTableDataVo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserService {

    Map selectUserData(UserTableDataVo tableVo);

    LoginUser selectUserByid(Integer id);

    void updateUser(LoginUser loginUser);

    Map selectGiveUserPer(Integer id);

    void addUserPer(Integer uid, String userPerList);

    List<UserRole> selectUserMeunData(String name);
}
