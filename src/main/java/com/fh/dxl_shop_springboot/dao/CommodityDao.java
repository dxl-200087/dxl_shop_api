package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.Commodity;
import com.fh.dxl_shop_springboot.model.vo.CommDataVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommodityDao {

    @Insert("insert into dxl_shop_commodity (name,title,imagepath,typeId,bandId,productdecs,price,stocks,sortNum,createDate,updateDate,author,isDel) " +
            "value (#{name},#{title},#{imagepath},#{typeId},#{bandId},#{productdecs},#{price},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveCommodity(Commodity commodity);

    @Select("select * from dxl_shop_commodity where id=#{id}")
    Commodity selectCommodityByid(Integer id);

    @Update("update dxl_shop_commodity set name=#{name},title=#{title},imagepath=#{imagepath},typeId=#{typeId},bandId=#{bandId},productdecs=#{productdecs},price=#{price},stocks=#{stocks},sortNum=#{sortNum},updateDate=#{updateDate},author=#{author},isDel=#{isDel} where id=#{id}")
    void updateCommodity(Commodity commodity);

    @Select("<script>select count(*) from dxl_shop_commodity where 1=1 " +
            "<if test='commName!=null and commName!=&quot;&quot;'> and name like '%${commName}%'</if>" +
            "<if test='commBandId!=null and commBandId!=&quot;&quot;'> and bandId = #{commBandId}</if>" +
            "</script>")
    Long selectCount(CommDataVo vo);

    @Select("<script>select * from dxl_shop_commodity where 2=2 " +
            "<if test='commName!=null and commName!=&quot;&quot;'> and name like '%${commName}%'</if>" +
            "<if test='commBandId!=null and commBandId!=&quot;&quot;'> and bandId = #{commBandId}</if>" +
            "order by id desc limit #{startIndex},#{limit}</script>")
    List<Commodity> selectCommodity(CommDataVo vo);

    @Update("update dxl_shop_commodity set isDel=#{isDel},updateDate=#{updateDate},author=#{author} where id=#{id}")
    void deleteCommodity(Commodity commodity);
}
