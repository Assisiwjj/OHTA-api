package com.qualityevaluationsys.demo.service;

import com.qualityevaluationsys.demo.domain.BasicJoint;
import com.qualityevaluationsys.demo.domain.BasicJointExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface basicJoint {
    int deleteByPrimaryKey(Integer id);

    int insert(BasicJoint record);

    BasicJoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(BasicJoint record);


}
