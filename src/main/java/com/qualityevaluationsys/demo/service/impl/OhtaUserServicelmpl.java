package com.qualityevaluationsys.demo.service.impl;


import com.qualityevaluationsys.demo.dao.OhtaUserMapper;
import com.qualityevaluationsys.demo.domain.OhtaOrder;
import com.qualityevaluationsys.demo.domain.OhtaOrderExample;
import com.qualityevaluationsys.demo.domain.OhtaUser;
import com.qualityevaluationsys.demo.domain.OhtaUserExample;
import com.qualityevaluationsys.demo.service.OhtaUserService;
import com.qualityevaluationsys.demo.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class OhtaUserServicelmpl implements OhtaUserService {
    @Autowired
    private OhtaUserMapper ohtaUserMapper;

    @Override
    public int insert(OhtaUser user){
        user.setPoint(0);
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        return ohtaUserMapper.insert(user);
    }

//    @Override
//    public List<OhtaUser> selectByExample(OhtaUser user){
//        OhtaUserExample example=new OhtaUserExample();
//        OhtaUserExample.Criteria criteria= example.createCriteria();
//        criteria.andOpenIdEqualTo(user.getOpenId());
//        return ohtaUserMapper.selectByExample(example);
//    }

    @Override
    public int update(OhtaUser user){
        OhtaUserExample example=new OhtaUserExample();
        OhtaUserExample.Criteria criteria= example.createCriteria();
        criteria.andOpenIdEqualTo(user.getOpenId());
        return ohtaUserMapper.updateByExampleSelective(user, example);
    }

    @Override
    public int updateByExample(OhtaUser user){
        OhtaUserExample example=new OhtaUserExample();
        OhtaUserExample.Criteria criteria= example.createCriteria();
        criteria.andOpenIdEqualTo(user.getOpenId());
        return ohtaUserMapper.updateByExampleSelective(user, example);
    }

    @Override
    public PageBean getAllUser(Integer limit, Integer page){
        try {
            OhtaUserExample example = new OhtaUserExample();
            OhtaUserExample.Criteria criteria = example.createCriteria();
            int count = (int) ohtaUserMapper.countByExample(example);
            if(count>0) {
                PageBean pageBean = new PageBean(page, count, limit);
                example.setLimit(limit);
                example.setOffset(pageBean.getStart());
                List<OhtaUser> list = (ohtaUserMapper.selectByExample(example));
                pageBean.setList(list);
                return pageBean;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
