package com.lin.EnjoyLife.mapper;

import com.lin.EnjoyLife.pojo.Manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerMapper {
    @Select("select * from manager where ManagerId = #{ManagerId}")
    Manager searchByManagerId(@Param("ManagerId") String ManagerId);

    @Update("update manager set MPassword=#{MPassword} where ManagerId=#{ManagerId}")
    Integer safeSettingConfig(@Param("ManagerId") String ManagerId,@Param("MPassword") String MPassword);
}
