package com.fh.dxl_shop_springboot.service.impl;

import com.fh.dxl_shop_springboot.dao.ProValDao;
import com.fh.dxl_shop_springboot.model.po.ProValue;
import com.fh.dxl_shop_springboot.model.vo.ProValTableVo;
import com.fh.dxl_shop_springboot.service.ProValService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProValServiceImpl implements ProValService {
    @Resource
    private ProValDao proValDao;


    @Override
    public Map selectByIdLimit(ProValTableVo vo) {
        Long count=proValDao.selectCount(vo);
        vo.setStartIndex((vo.getPage()-1)*vo.getLimit());
        List<ProValue> list=proValDao.selectByproid(vo);
        Map map=new HashMap();
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    @Override
    public void saveProVal(ProValue proValue) {
        proValue.setIsDel(0);
        proValDao.saveProVal(proValue);
    }

    @Override
    public ProValue selectProValByid(Integer id) {
        ProValue proValue=proValDao.selectProValByid(id);
        return proValue;
    }

    @Override
    public void updateProVal(ProValue proValue) {
        proValDao.updateProVal(proValue);
    }
}
