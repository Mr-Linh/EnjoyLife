package com.lin.EnjoyLife.mapper;

import com.lin.EnjoyLife.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    @Insert("insert into message (MessageId,UserId,MessageTime,MessageContent) values (#{MessageId},#{UserId},#{MessageTime},#{MessageContent})")
    Integer addMessage(Message message);

    @Select("select * from message")
    List<Message> messageShow();

    @Select("select count(*) from message where MessageTime like concat('%',#{MessageTime},'%') ")
    Integer messageCount(@Param("MessageTime") String MessageTime);
}
