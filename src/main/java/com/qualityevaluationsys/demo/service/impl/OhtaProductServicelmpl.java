package com.qualityevaluationsys.demo.service.impl;

import com.qualityevaluationsys.demo.dao.OhtaProductMapper;
import com.qualityevaluationsys.demo.domain.OhtaProduct;
import com.qualityevaluationsys.demo.service.OhtaProductService;
import com.qualityevaluationsys.demo.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

@Service
public class OhtaProductServicelmpl implements OhtaProductService {
    @Autowired
    private OhtaProductMapper ohtaProductMapper;

    @Override
    public int insert(OhtaProduct product) throws RuntimeException {
        product.setGmtCreate(new Date());
        product.setGmtModified(new Date());
        return ohtaProductMapper.insert(product);
    }

    @Override
    public int updateByPrimaryKeySelective(OhtaProduct product) throws RuntimeException {
        return ohtaProductMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public List selectAllProduct() throws RuntimeException {
        return ohtaProductMapper.selectAllProduct();
    }

}
