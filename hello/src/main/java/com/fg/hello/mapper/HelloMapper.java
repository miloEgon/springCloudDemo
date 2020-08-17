package com.fg.hello.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HelloMapper {

    @Select("select * from xzqa_author where id = 1")
    Object getNames();
}
