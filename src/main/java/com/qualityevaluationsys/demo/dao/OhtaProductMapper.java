package com.qualityevaluationsys.demo.dao;

import com.qualityevaluationsys.demo.domain.OhtaProduct;
import com.qualityevaluationsys.demo.domain.OhtaProductExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OhtaProductMapper {
    long countByExample(OhtaProductExample example);

    int deleteByExample(OhtaProductExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(OhtaProduct record);

    int insertSelective(OhtaProduct record);

    List<OhtaProduct> selectByExample(OhtaProductExample example);

    OhtaProduct selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") OhtaProduct record, @Param("example") OhtaProductExample example);

    int updateByExample(@Param("record") OhtaProduct record, @Param("example") OhtaProductExample example);

    int updateByPrimaryKeySelective(OhtaProduct record);

    int updateByPrimaryKey(OhtaProduct record);

    List selectAllProduct();
}