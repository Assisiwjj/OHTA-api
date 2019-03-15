package com.qualityevaluationsys.demo.service;

import com.qualityevaluationsys.demo.domain.OhtaOrder;
import com.qualityevaluationsys.demo.utils.PageBean;

import java.util.List;

public interface OhtaOrderService {
    PageBean getPageUnfinshed(Integer limit, Integer page);

    public PageBean getPageFinshed(Integer limit, Integer page, String time);

    //public abstract List<OhtaOrder> selectUnfinshed();

    public abstract List<OhtaOrder> selectByExampleOrder(OhtaOrder record);

    public abstract List<OhtaOrder> selectByExampleUser(OhtaOrder record);

    public abstract List<OhtaOrder> selectByExampleUserUnfinshed(OhtaOrder record);

    public abstract int insert(OhtaOrder record);

    public abstract int updateByExampleSelective(OhtaOrder record);
}
