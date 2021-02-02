package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RoleDao {

    @Select("select * from dxl_user_role")
    List<UserRole> selectRoleDate();

    @Insert("insert into dxl_user_role (pid,name,url,type,isDel,createDate,author) value (#{pid},#{name},#{url},#{type},#{isDel},#{createDate},#{author})")
    void saveRoleData(UserRole userRole);

    @Select("select * from dxl_user_role where id=#{id}")
    UserRole selectRoleById(Integer id);

    @Update("update dxl_user_role set name=#{name},url=#{url},type=#{type},isDel=#{isDel} where id=#{id}")
    void updateRole(UserRole userRole);
}
