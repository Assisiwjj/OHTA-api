package com.qualityevaluationsys.demo.service;

import com.qualityevaluationsys.demo.domain.OhtaProduct;
import com.qualityevaluationsys.demo.utils.PageBean;

import java.util.List;

public interface OhtaProductService {
    public abstract int insert(OhtaProduct record);

    public abstract int updateByPrimaryKeySelective(OhtaProduct record);

    public abstract List selectAllProduct();

}
