package com.qualityevaluationsys.demo.service;

import com.qualityevaluationsys.demo.domain.OhtaUser;
import com.qualityevaluationsys.demo.domain.OhtaUserExample;
import com.qualityevaluationsys.demo.utils.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OhtaUserService {
    public abstract int insert(OhtaUser record);

//    public abstract List<OhtaUser> selectByExample(OhtaUser record);

    public abstract int update(OhtaUser record);

    public abstract int updateByExample(OhtaUser record);

    PageBean getAllUser(Integer limit, Integer page);
}
