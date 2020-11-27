package com.lin.EnjoyLife.mapper;

import com.lin.EnjoyLife.pojo.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {

    @Insert("insert into task (TaskId,Category1,Category2,Publisher,PublishTime,DeadLine,Theme,Content,Special,TLevel,Price,PublisherPhone,TState,Executor,ExecutorPhone,Evaluation) values (#{TaskId},#{Category1},#{Category2},#{Publisher},#{PublishTime},#{DeadLine},#{Theme},#{Content},#{Special},#{TLevel},#{Price},#{PublisherPhone},#{TState},#{Executor},#{ExecutorPhone},#{Evaluation})")
    Integer addTask(Task task);

    @Select("select * from task where concat(PublishTime) like '%' || 'PublishTime' || '%' ")
    List<Task> queryForTask(@Param("PublishTime") String PublishTime);

    @Select("select * from task where TState=0 && (TaskId like concat('%',#{searchContent},'%') || Theme like concat('%',#{searchContent},'%'))")
    List<Task> taskCenterSearch(@Param("searchContent") String searchContent);

    @Select("select * from task where Publisher=#{Publisher} and TState=0")
    List<Task> queryTaskByPublisher1(@Param("Publisher") String Publisher);

    @Select("select * from task where Publisher=#{Publisher} and TState=1 || TState=5")
    List<Task> queryTaskByPublisher2(@Param("Publisher") String Publisher);

    @Select("select * from task where Publisher=#{Publisher} and TState=2")
    List<Task> queryTaskByPublisher3(@Param("Publisher") String Publisher);

    @Select("select * from task where Publisher=#{Publisher}")
    List<Task> queryTaskByPublisher4(@Param("Publisher") String Publisher);

    @Select("select * from task where Executor=#{Executor} and TState=0")
    List<Task> queryTaskByExecutor1(@Param("Executor") String Executor);

    @Select("select * from task where Executor=#{Executor} and TState=1")
    List<Task> queryTaskByExecutor2(@Param("Executor") String Executor);

    @Select("select * from task where Executor=#{Executor} and TState=2")
    List<Task> queryTaskByExecutor3(@Param("Executor") String Executor);

    @Select("select * from task where Executor=#{Executor}")
    List<Task> queryTaskByExecutor4(@Param("Executor") String Executor);

    @Select("select * from task where TaskId=#{TaskId}")
    Task queryForTaskByTaskId(@Param("TaskId") String TaskId);

    @Select("select * from task where TState=0")
    List<Task> queryTaskListAll();

    @Select("select * from task where Category1=#{Category1} and TState=0")
    List<Task> queryTaskList(@Param("Category1") String Category1);

    @Select("select * from task where Category1=#{Category1} and Category2=#{Category2} and TState=0")
    List<Task> queryTaskList2(@Param("Category1") String Category1,@Param("Category2") String Category2);

    @Update("update task set TState=1,Executor=#{Executor},ExecutorPhone=#{ExecutorPhone} where TaskId=#{TaskId}")
    Integer receiptTaskUpdate(@Param("TaskId") String TaskId,@Param("Executor") String Executor,@Param("ExecutorPhone") String ExecutorPhone);

    @Update("update task set TState=4 where TaskId=#{TaskId}")
    Integer undoTaskUpdate(@Param("TaskId") String TaskId);

    @Update("update task set TState=5 where TaskId=#{TaskId}")
    Integer finishTaskUpdate(@Param("TaskId") String TaskId);

    @Update("update task set TState=2 where TaskId=#{TaskId}")
    Integer confirmFinishUpdate(@Param("TaskId") String TaskId);
}
