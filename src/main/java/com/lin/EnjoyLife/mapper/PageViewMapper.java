package com.lin.EnjoyLife.mapper;

import com.lin.EnjoyLife.pojo.PageView;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PageViewMapper {

    @Select("select * from pageview where pid = #{pid}")
    PageView searchByPid(@Param("pid") Integer pid);
}
