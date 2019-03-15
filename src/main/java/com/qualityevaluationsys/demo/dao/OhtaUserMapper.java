package com.qualityevaluationsys.demo.dao;

import com.qualityevaluationsys.demo.domain.OhtaUser;
import com.qualityevaluationsys.demo.domain.OhtaUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OhtaUserMapper {
    long countByExample(OhtaUserExample example);

    int deleteByExample(OhtaUserExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(OhtaUser record);

    int insertSelective(OhtaUser record);

    List<OhtaUser> selectByExample(OhtaUserExample example);

    OhtaUser selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") OhtaUser record, @Param("example") OhtaUserExample example);

    int updateByExample(@Param("record") OhtaUser record, @Param("example") OhtaUserExample example);

    int updateByPrimaryKeySelective(OhtaUser record);

    int updateByPrimaryKey(OhtaUser record);
}