package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.GiveUserPersona;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GiveUserPersonaDao {

    @Select("select * from dxl_user_userper where uid=#{id}")
    List<GiveUserPersona> selectDataById(Integer id);

    @Delete("delete from dxl_user_userper where uid=#{uid}")
    void deleteUserPerByUid(Integer uid);

    @Insert("<script>insert into dxl_user_userper (uid,rid) values" +
            "<foreach collection='list' item='data' separator=','>" +
            "(#{data.uid},#{data.rid})</foreach></script>")
    void addUserPer(List<GiveUserPersona> list);
}
