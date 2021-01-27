package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.ProValue;
import com.fh.dxl_shop_springboot.model.vo.ProValTableVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProValDao {

    @Select("<script>select count(*) from dxl_shop_provalue where proid=#{proid}" +
            "<if test='craname!=null and craname!=&quot;&quot;'> and name like '%${craname}%'</if>" +
            "</script>")
    Long selectCount(ProValTableVo vo);

    @Select("<script>select * from dxl_shop_provalue where proid=#{proid}" +
            "<if test='craname!=null and craname!=&quot;&quot;'> and name like '%${craname}%'</if>" +
            "limit #{startIndex},#{limit}</script>")
    List<ProValue> selectByproid(ProValTableVo vo);

    @Insert("insert into dxl_shop_provalue (name,nameCH,proid,isDel) value (#{name},#{nameCH},#{proid},#{isDel})")
    void saveProVal(ProValue proValue);

    @Select("select * from dxl_shop_provalue where id=#{id}")
    ProValue selectProValByid(Integer id);

    @Update("update dxl_shop_provalue set name=#{name},nameCH=#{nameCH},proid=#{proid},isDel=#{isDel} where id=#{id}")
    void updateProVal(ProValue proValue);


    @Select("select * from dxl_shop_provalue where proid=#{id}")
    List<ProValue> selectProValueByid(Integer id);
}
