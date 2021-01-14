package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.ShopProperty;
import com.fh.dxl_shop_springboot.model.vo.DataTablesVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PropertyDao {

    @Select("<script> select Count(*) from dxl_shop_property where 1=1 </script>")
    Long selectCount(DataTablesVo vo);

    @Select("<script> select * from dxl_shop_property where 2=2 " +
            "limit #{startIndex},#{limit}</script>")
    List<ShopProperty> selectProperty(DataTablesVo vo);
}
