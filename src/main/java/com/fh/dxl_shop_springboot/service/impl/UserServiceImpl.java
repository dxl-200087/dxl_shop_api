package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.GiveUserPersonaDao;
import com.fh.dxl_shop_springboot.dao.PersonaDao;
import com.fh.dxl_shop_springboot.dao.UserDao;
import com.fh.dxl_shop_springboot.model.po.GiveUserPersona;
import com.fh.dxl_shop_springboot.model.po.LoginUser;
import com.fh.dxl_shop_springboot.model.po.UserPersona;
import com.fh.dxl_shop_springboot.model.vo.UserTableDataVo;
import com.fh.dxl_shop_springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private PersonaDao personaDao;
    @Resource
    private GiveUserPersonaDao giveUserPersonaDao;


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

    @Override
    @Transactional
    public Map selectGiveUserPer(Integer id) {
        Map map=new HashMap();
        List<UserPersona> personaList=personaDao.selectPersonaData();
        List<GiveUserPersona> userPerlist=giveUserPersonaDao.selectDataById(id);
        map.put("perList",personaList);
        map.put("userper",userPerlist);
        return map;
    }

    @Override
    @Transactional
    public void addUserPer(Integer uid,String userPerList) {
        giveUserPersonaDao.deleteUserPerByUid(uid);
        String[] split = userPerList.split(",");
        List<GiveUserPersona> list=new ArrayList<GiveUserPersona>();
        for (int i = 0; i <split.length; i++) {
            GiveUserPersona giveUserPersona=new GiveUserPersona();
            giveUserPersona.setUid(uid);
            giveUserPersona.setRid(Integer.valueOf(split[i]));
            list.add(giveUserPersona);
        }
        giveUserPersonaDao.addUserPer(list);
    }
}
