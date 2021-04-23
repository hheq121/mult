package com.example.dao.mapper;

import com.example.dao.entity.BookType;
import com.example.dao.entity.BookTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookTypeMapper {
    long countByExample(BookTypeExample example);

    int deleteByExample(BookTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookType record);

    int insertSelective(BookType record);

    List<BookType> selectByExample(BookTypeExample example);

    BookType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookType record, @Param("example") BookTypeExample example);

    int updateByExample(@Param("record") BookType record, @Param("example") BookTypeExample example);

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);
}