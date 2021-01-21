package com.fh.dxl_shop_springboot.dao;

import com.fh.dxl_shop_springboot.model.po.ProValData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProValDataDao {

    @Insert("<script>insert into dxl_shop_provaldata (proid,skuData,stocks,price) " +
            "values <foreach collection='list' item='a' separator=','> ( #{a.proid},#{a.skuData},#{a.stocks},#{a.price} ) " +
            "</foreach> </script>")
    void saveProValData(List<ProValData> list);
}
