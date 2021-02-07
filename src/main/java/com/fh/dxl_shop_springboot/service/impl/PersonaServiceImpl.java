package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.GiveRoleMissDao;
import com.fh.dxl_shop_springboot.dao.PersonaDao;
import com.fh.dxl_shop_springboot.dao.RoleDao;
import com.fh.dxl_shop_springboot.model.po.GiveRoleMiss;
import com.fh.dxl_shop_springboot.model.po.UserPersona;
import com.fh.dxl_shop_springboot.model.po.UserRole;
import com.fh.dxl_shop_springboot.model.vo.PersonaTableVo;
import com.fh.dxl_shop_springboot.service.PersonaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.*;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Resource
    private PersonaDao personaDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private GiveRoleMissDao giveRoleMissDao;

    @Override
    public Map selectPersonaData(PersonaTableVo tableVo) {
        Map map=new HashMap();
        Long count=personaDao.selectCount(tableVo);
        tableVo.setStartIndex((tableVo.getPage()-1)*tableVo.getLimit());
        List<UserPersona> list=personaDao.selectPersona(tableVo);
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    @Override
    public void savePersona(UserPersona userPersona) {
        userPersona.setAuthor("dxl");
        userPersona.setCreateDate(new Date());
        personaDao.savePersona(userPersona);
    }

    @Override
    public UserPersona selectPersonaById(Integer id) {
        UserPersona userPersona=personaDao.selectPersonaById(id);
        return userPersona;
    }

    @Override
    public void updatePersona(UserPersona userPersona) {
        personaDao.updatePersona(userPersona);
    }

    @Override
    @Transactional
    public Map selectPersonaOrMiss(Integer rid) {
        Map map=new HashMap();
        List<UserRole> list=roleDao.selectRoleDate();
        List<GiveRoleMiss> list2=giveRoleMissDao.selectRoleMiss(rid);
        map.put("roleData",list);
        map.put("roleMissData",list2);
        return map;
    }

    @Override
    @Transactional
    public void addRoleMenuData(Integer rid,String roleMenuId) {
        giveRoleMissDao.deleteByRid(rid);
        String[] split = roleMenuId.split(",");
        List<GiveRoleMiss> list=new ArrayList<GiveRoleMiss>();
        for (int i = 0; i <split.length ; i++) {
            GiveRoleMiss giveRoleMiss=new GiveRoleMiss();
            giveRoleMiss.setRid(rid);
            giveRoleMiss.setMid(Integer.valueOf(split[i]));
            list.add(giveRoleMiss);
        }
        giveRoleMissDao.addRoleMenuData(list);
    }


}
