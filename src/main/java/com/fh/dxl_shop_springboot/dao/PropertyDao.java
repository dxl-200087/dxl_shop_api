package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.ShopProperty;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import com.fh.dxl_shop_springboot.model.vo.PropertyDataVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PropertyDao {

    @Select("<script> select Count(*) " +
            "from dxl_shop_property dsp left join dxl_shop_type dxt on dsp.typeId=dxt.id where 1=1 " +
            "<if test='cratename!=null and cratename!=&quot;&quot;'> and dsp.name like '%${cratename}%'</if>" +
            "</script>")
    Long selectCount(DataTablesVo vo);

    @Select("<script> select dsp.id,dsp.name,dsp.nameCH,dxt.name as typeId,dsp.type,dsp.isSKU,dsp.isDel " +
            "from dxl_shop_property dsp left join dxl_shop_type dxt on dsp.typeId=dxt.id where 2=2 " +
            "<if test='cratename!=null and cratename!=&quot;&quot;'> and dsp.name like '%${cratename}%'</if>" +
            "limit #{startIndex},#{limit}</script>")
    List<PropertyDataVo> selectProperty(DataTablesVo vo);

    @Insert("insert into dxl_shop_property (name,nameCH,typeId,type,isSKU,isDel,createDate,updateDate,author) value (#{name},#{nameCH},#{typeId},#{type},#{isSKU},#{isDel},#{createDate},#{updateDate},#{author})")
    void saveProperty(ShopProperty shopProperty);

    @Select("select * from dxl_shop_property where id=#{id}")
    ShopProperty selectPropertyByid(Integer id);

    @Update("update dxl_shop_property set name=#{name},nameCH=#{nameCH},typeId=#{typeId},type=#{type},isSKU=#{isSKU},isDel=#{isDel},createDate=#{createDate},updateDate=#{updateDate},author=#{author} where id=#{id}")
    void updateProperty(ShopProperty shopProperty);

    @Select("select * from dxl_shop_property where typeId=#{typeId}")
    List<ShopProperty> selectProByTypeId(Integer typeId);
}
