package com.fh.dxl_shop_springboot.service;

import com.fh.dxl_shop_springboot.model.vo.ProValTableVo;

import java.util.Map;

public interface ProValService {
    Map selectByIdLimit(ProValTableVo vo);
}
