package com.qualityevaluationsys.demo.service.impl;

import com.qualityevaluationsys.demo.dao.OhtaOrderMapper;
import com.qualityevaluationsys.demo.domain.OhtaOrder;
import com.qualityevaluationsys.demo.domain.OhtaOrderExample;
import com.qualityevaluationsys.demo.service.OhtaOrderService;
import com.qualityevaluationsys.demo.utils.DateOrder;
import com.qualityevaluationsys.demo.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OhtaOrderServicelmpl implements OhtaOrderService {
    @Autowired
    private OhtaOrderMapper ohtaOrderMapper;

    @Override
    public PageBean getPageUnfinshed(Integer limit, Integer page) throws RuntimeException{
        try {
            OhtaOrderExample example = new OhtaOrderExample();
            OhtaOrderExample.Criteria criteria = example.createCriteria();
            criteria.andStatusLike("%" +"制作"+ "%");
            int count = (int) ohtaOrderMapper.countByExample(example);
            if(count>0) {
                PageBean pageBean = new PageBean(page, count, limit);
                example.setLimit(limit);
                example.setOffset(pageBean.getStart());
                List<OhtaOrder> list = (ohtaOrderMapper.selectByExample(example));
                pageBean.setList(list);
                return pageBean;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public PageBean getPageFinshed(Integer limit, Integer page, String time ) throws RuntimeException{
        try {
            OhtaOrderExample example = new OhtaOrderExample();
            OhtaOrderExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo("交易完成");
            if (time!= null) {
                criteria.andOrderIdLike("%" + time + "%");
            }
            int count = (int) ohtaOrderMapper.countByExample(example);
            if(count>0) {
                PageBean pageBean = new PageBean(page, count, limit);
                example.setLimit(limit);
                example.setOffset(pageBean.getStart());
                List<OhtaOrder> list = (ohtaOrderMapper.selectByExample(example));
                pageBean.setList(list);
                return pageBean;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
//    @Override
//    public List<OhtaOrder> selectUnfinshed() throws RuntimeException {
//        try {
//            OhtaOrderExample example = new OhtaOrderExample();
//            OhtaOrderExample.Criteria criteria = example.createCriteria();
//            criteria.andStatusLike("%" +"制作"+ "%");
//            return ohtaOrderMapper.selectByExample(example);
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }

    @Override
    public List<OhtaOrder> selectByExampleOrder(OhtaOrder order) throws RuntimeException {
        try {
            OhtaOrderExample example = new OhtaOrderExample();
            OhtaOrderExample.Criteria criteria = example.createCriteria();
            criteria.andOrderIdEqualTo(order.getOrderId());
            return ohtaOrderMapper.selectByExample(example);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<OhtaOrder> selectByExampleUser(OhtaOrder order) throws RuntimeException {
        try {
            OhtaOrderExample example = new OhtaOrderExample();
            OhtaOrderExample.Criteria criteria = example.createCriteria();
            criteria.andOpenIdEqualTo(order.getOpenId());
            criteria.andStatusEqualTo("交易完成");
            return ohtaOrderMapper.selectByExample(example);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<OhtaOrder> selectByExampleUserUnfinshed(OhtaOrder order) throws RuntimeException {
        try {
            OhtaOrderExample example = new OhtaOrderExample();
            OhtaOrderExample.Criteria criteria = example.createCriteria();
            criteria.andOpenIdEqualTo(order.getOpenId());
            criteria.andStatusLike("%" +"制作"+ "%");
            return ohtaOrderMapper.selectByExample(example);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int insert(OhtaOrder order) throws RuntimeException {
        try {
            order.setGmtCreate(new Date());
            order.setGmtModified(new Date());
            order.setOrderId(DateOrder.getInstance().generateOrder());
            order.setStatus("制作中");
            return ohtaOrderMapper.insert(order);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int updateByExampleSelective(OhtaOrder order) throws RuntimeException {
        try {
            return ohtaOrderMapper.updateByPrimaryKeySelective(order);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
