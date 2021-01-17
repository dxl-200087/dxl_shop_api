package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.ShopData;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShopDataDao {
    @Select("<script>select count(*) from dxl_shop_data where 1=1" +
            "<if test='cratename!=null and cratename!=&quot;&quot;'> and name like '%${cratename}%'</if>" +
            "</script>")
    Long selectCount(DataTablesVo vo);

    @Select("<script>select * from dxl_shop_data where 1=1" +
            "<if test='cratename!=null and cratename!=&quot;&quot;'> and name like '%${cratename}%'</if>" +
            "limit #{startIndex},#{limit}</script>")
    List<ShopData> selectShopData(DataTablesVo vo);

    @Insert("insert into dxl_shop_data (name,bandE,imgpath,bandDesc,ord,isdel,createDate,updateDate,author) value (#{name},#{bandE},#{imgpath},#{bandDesc},#{ord},#{isdel},#{createDate},#{updateDate},#{author})")
    void saveShopData(ShopData shopData);

    @Select("select * from dxl_shop_data where id=#{id}")
    ShopData selectShopByid(Integer id);

    @Update("update dxl_shop_data set name=#{name},bandE=#{bandE},imgpath=#{imgpath},bandDesc=#{bandDesc},ord=#{ord},isdel=#{isdel},updateDate=#{updateDate},author=#{author} where id=#{id}")
    void updateShopData(ShopData shopData);
}
