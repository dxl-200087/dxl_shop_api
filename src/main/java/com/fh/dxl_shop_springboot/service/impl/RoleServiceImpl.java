package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.RoleDao;
import com.fh.dxl_shop_springboot.model.po.UserRole;
import com.fh.dxl_shop_springboot.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Override
    public List<UserRole> selectRoleDate() {
        List<UserRole> list=roleDao.selectRoleDate();
        return list;
    }

    @Override
    public void saveRoleData(UserRole userRole) {
        userRole.setCreateDate(new Date());
        userRole.setAuthor("dxl");
        roleDao.saveRoleData(userRole);
    }

    @Override
    public UserRole selectRoleById(Integer id) {
        UserRole userRole=roleDao.selectRoleById(id);
        return userRole;
    }

    @Override
    public void updateRole(UserRole userRole) {
        roleDao.updateRole(userRole);
    }
}
