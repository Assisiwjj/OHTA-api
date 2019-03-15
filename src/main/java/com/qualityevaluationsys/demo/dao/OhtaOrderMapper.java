package com.qualityevaluationsys.demo.dao;

import com.qualityevaluationsys.demo.domain.OhtaOrder;
import com.qualityevaluationsys.demo.domain.OhtaOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OhtaOrderMapper {
    long countByExample(OhtaOrderExample example);

    int deleteByExample(OhtaOrderExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(OhtaOrder record);

    int insertSelective(OhtaOrder record);

    List<OhtaOrder> selectByExample(OhtaOrderExample example);

    OhtaOrder selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") OhtaOrder record, @Param("example") OhtaOrderExample example);

    int updateByExample(@Param("record") OhtaOrder record, @Param("example") OhtaOrderExample example);

    int updateByPrimaryKeySelective(OhtaOrder record);

    int updateByPrimaryKey(OhtaOrder record);
}