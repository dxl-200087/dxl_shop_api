package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.LoginUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginDao {
    @Select("select * from dxl_user_user where name=#{name}")
    LoginUser selectUserByName(String name);

    @Insert("insert into dxl_user_user (name,realName,password,sex,phone,email,idCard,birthday,imgUrl,eduId,deptId,createDate,updateDate) value (#{name},#{realName},#{password},#{sex},#{phone},#{email},#{idCard},#{birthday},#{imgUrl},#{eduId},#{deptId},#{createDate},#{updateDate})")
    void addUser(LoginUser loginUser);
}
