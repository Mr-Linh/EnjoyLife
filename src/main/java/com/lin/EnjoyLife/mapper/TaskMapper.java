package com.lin.EnjoyLife.mapper;

import com.lin.EnjoyLife.pojo.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {

    @Insert("insert into task (TaskId,Category1,Category2,Publisher,PublishTime,DeadLine,Theme,Content,Special,TLevel,Price,PublisherPhone,TState,Executor,ExecutorPhone,Evaluation) values (#{TaskId},#{Category1},#{Category2},#{Publisher},#{PublishTime},#{DeadLine},#{Theme},#{Content},#{Special},#{TLevel},#{Price},#{PublisherPhone},#{TState},#{Executor},#{ExecutorPhone},#{Evaluation})")
    Integer addTask(Task task);

    @Select("select * from task where concat(PublishTime) like '%' || 'PublishTime' || '%' ")
    List<Task> queryForTask(@Param("PublishTime") String PublishTime);
}
