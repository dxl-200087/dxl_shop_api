package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.UserPersona;
import com.fh.dxl_shop_springboot.model.vo.PersonaTableVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonaDao {

    @Select("<script>select count(*) from dxl_user_persona where 1=1" +
            "<if test='crateName!=null and crateName!=&quot;&quot;'>and name like '%${crateName}%'</if>" +
            "</script>")
    Long selectCount(PersonaTableVo tableVo);

    @Select("<script>select * from dxl_user_persona where 1=1" +
            "<if test='crateName!=null and crateName!=&quot;&quot;'>and name like '%${crateName}%'</if>" +
            "limit #{startIndex},#{limit} </script>")
    List<UserPersona> selectPersona(PersonaTableVo tableVo);

    @Insert("insert into dxl_user_persona (name,isDel,createDate,author) value (#{name},#{isDel},#{createDate},#{author})")
    void savePersona(UserPersona userPersona);

    @Select("select * from dxl_user_persona where id=#{id}")
    UserPersona selectPersonaById(Integer id);

    @Update("update dxl_user_persona set name=#{name},isDel=#{isDel} where id=#{id}")
    void updatePersona(UserPersona userPersona);

    @Select("select * from dxl_user_persona")
    List<UserPersona> selectPersonaData();
}
