package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.UserRole;

import java.util.List;

public interface RoleService {


    List<UserRole> selectRoleDate();

    void saveRoleData(UserRole userRole);

    UserRole selectRoleById(Integer id);

    void updateRole(UserRole userRole);
}
