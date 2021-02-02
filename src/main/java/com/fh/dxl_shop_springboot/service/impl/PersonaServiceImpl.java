package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.PersonaDao;
import com.fh.dxl_shop_springboot.model.po.UserPersona;
import com.fh.dxl_shop_springboot.model.vo.PersonaTableVo;
import com.fh.dxl_shop_springboot.service.PersonaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Resource
    private PersonaDao personaDao;


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
}
