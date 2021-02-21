package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.LoginUser;
import com.fh.dxl_shop_springboot.model.po.UserRole;
import com.fh.dxl_shop_springboot.model.vo.UserTableDataVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("<script>select count(*) from dxl_user_user where 1=1" +
            "<if test='crname!=null and crname!=&quot;&quot;'>and name like '%${crname}%'</if>" +
            "<if test='beginDate!=null'>and birthday >= #{beginDate}</if>" +
            "<if test='endDate!=null'>and birthday &lt;= #{endDate}</if></script>")
    Long SelectUserCount(UserTableDataVo tableVo);

    @Select("<script>select * from dxl_user_user where 1=1" +
            "<if test='crname!=null and crname!=&quot;&quot;'>and name like '%${crname}%'</if>" +
            "<if test='beginDate!=null'>and birthday >= #{beginDate}</if>" +
            "<if test='endDate!=null'>and birthday &lt;= #{endDate}</if>" +
            "limit #{startIndex},#{limit}</script>")
    List<LoginUser> selectUserData(UserTableDataVo tableVo);

    @Select("select * from dxl_user_user where id=#{id}")
    LoginUser selectUserByid(Integer id);

    @Update("update dxl_user_user set realName=#{realName},sex=#{sex},phone=#{phone},email=#{email},idCard=#{idCard},birthday=#{birthday},imgUrl=#{imgUrl},eduId=#{eduId},deptId=#{deptId} where id=#{id}")
    void updateUser(LoginUser loginUser);

    @Select("select * from dxl_user_user where name=#{name}")
    LoginUser selectUser(String name);

    @Select("SELECT distinct r.id,r.pid,r.name,r.url,r.icon,r.type " +
            "from dxl_user_userper up LEFT JOIN dxl_user_rolemiss rm on up.rid=rm.rid LEFT JOIN dxl_user_role r on rm.mid=r.id " +
            "where up.uid=#{id} and r.id is not null ORDER BY r.id ASC")
    List<UserRole> selectUserMeunData(Integer id);
}
