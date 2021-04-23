package com.example.dao.mapper;

import com.example.dao.entity.Myuser;
import com.example.dao.entity.MyuserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MyuserMapper {
    long countByExample(MyuserExample example);

    int deleteByExample(MyuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Myuser record);

    int insertSelective(Myuser record);

    List<Myuser> selectByExample(MyuserExample example);

    Myuser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Myuser record, @Param("example") MyuserExample example);

    int updateByExample(@Param("record") Myuser record, @Param("example") MyuserExample example);

    int updateByPrimaryKeySelective(Myuser record);

    int updateByPrimaryKey(Myuser record);
}