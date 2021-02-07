package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.po.UserPersona;
import com.fh.dxl_shop_springboot.model.vo.PersonaTableVo;

import java.util.Map;

public interface PersonaService {
    Map selectPersonaData(PersonaTableVo tableVo);

    void savePersona(UserPersona userPersona);

    UserPersona selectPersonaById(Integer id);

    void updatePersona(UserPersona userPersona);

    Map selectPersonaOrMiss(Integer rid);

    void addRoleMenuData(Integer rid, String roleMenuId);
}
