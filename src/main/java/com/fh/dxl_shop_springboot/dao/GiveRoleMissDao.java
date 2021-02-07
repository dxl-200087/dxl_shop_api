package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.GiveRoleMiss;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface GiveRoleMissDao {

    @Select("select * from dxl_user_rolemiss where rid=#{rid}")
    List<GiveRoleMiss> selectRoleMiss(Integer rid);

    @Delete("delete from dxl_user_rolemiss where rid=#{rid}")
    void deleteByRid(Integer rid);

    @Insert("<script>insert into dxl_user_rolemiss (rid,mid) values" +
            "<foreach collection='list' item='data' separator=','>" +
            "(#{data.rid},#{data.mid})</foreach></script>")
    void addRoleMenuData(List<GiveRoleMiss> list);
}
