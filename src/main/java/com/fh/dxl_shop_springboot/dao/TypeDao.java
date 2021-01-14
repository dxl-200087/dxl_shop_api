package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.ShopType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeDao {

    @Select("select * from dxl_shop_type")
    List<ShopType> selectType();

    @Select("select * from dxl_shop_type where pid=#{pid}")
    List<ShopType> selectTypeBypid(Integer pid);

    @Insert("insert into dxl_shop_type (name,pid,createDate,updateDate,whoUser,isDel) value (#{name},#{pid},#{createDate},#{updateDate},#{whoUser},#{isDel})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer saveType(ShopType shopType);

    @Update("update dxl_shop_type set name=#{name},pid=#{pid},updateDate=#{updateDate},isDel=#{isDel} where id=#{id}")
    void updateType(ShopType shopType);

    @Select("select id,name,pid,isDel from dxl_shop_type where id=#{id}")
    ShopType selectTypeByid(Integer id);
}
