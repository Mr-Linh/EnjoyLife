package com.lin.EnjoyLife.mapper;

import com.lin.EnjoyLife.pojo.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TaskMapper {

    @Insert("insert into task (TaskId,Category1,Category2,Publisher,PublishTime,DeadLine,Theme,Content,Special,TLevel,Price,PublisherPhone,TState,Executor,ExecutorPhone,AppealReason,Score) values (#{TaskId},#{Category1},#{Category2},#{Publisher},#{PublishTime},#{DeadLine},#{Theme},#{Content},#{Special},#{TLevel},#{Price},#{PublisherPhone},#{TState},#{Executor},#{ExecutorPhone},#{AppealReason},#{Score})")
    Integer addTask(Task task);

    @Select("select * from task where PublishTime like concat('%',#{PublishTime},'%') ")
    List<Task> queryForTask(@Param("PublishTime") String PublishTime);

    @Select("select * from task where TState=1 && (TaskId like concat('%',#{searchContent},'%') || Theme like concat('%',#{searchContent},'%'))")
    List<Task> taskCenterSearch(@Param("searchContent") String searchContent);

    @Select("select * from task where Publisher=#{Publisher} and (TState=0 || TState=1)")
    List<Task> queryTaskByPublisher1(@Param("Publisher") String Publisher);

    @Select("select * from task where Publisher=#{Publisher} and (TState=4 || TState=5 || TState=7)")
    List<Task> queryTaskByPublisher2(@Param("Publisher") String Publisher);

    @Select("select * from task where Publisher=#{Publisher} and (TState=2 || TState=3 || TState=6 || TState=8 || TState=9 || TState=10)")
    List<Task> queryTaskByPublisher3(@Param("Publisher") String Publisher);

    @Select("select * from task where Publisher=#{Publisher}")
    List<Task> queryTaskByPublisher4(@Param("Publisher") String Publisher);

    @Select("select * from task where Executor=#{Executor} and (TState=4 || TState=5 || TState=7)")
    List<Task> queryTaskByExecutor2(@Param("Executor") String Executor);

    @Select("select * from task where Executor=#{Executor} and (TState=2 || TState=3 || TState=6 || TState=8 || TState=9 || TState=10)")
    List<Task> queryTaskByExecutor3(@Param("Executor") String Executor);

    @Select("select * from task where Executor=#{Executor}")
    List<Task> queryTaskByExecutor4(@Param("Executor") String Executor);

    @Select("select * from task where TaskId=#{TaskId}")
    Task queryForTaskByTaskId(@Param("TaskId") String TaskId);

    @Select("select * from task where TState=1")
    List<Task> queryTaskListAll();

    @Select("select * from task where Category1=#{Category1} and TState=1")
    List<Task> queryTaskList(@Param("Category1") String Category1);

    @Select("select * from task where Category1=#{Category1} and Category2=#{Category2} and TState=1")
    List<Task> queryTaskList2(@Param("Category1") String Category1, @Param("Category2") String Category2);

    @Update("update task set TState=4,Executor=#{Executor},ExecutorPhone=#{ExecutorPhone} where TaskId=#{TaskId}")
    Integer receiptTaskUpdate(@Param("TaskId") String TaskId, @Param("Executor") String Executor, @Param("ExecutorPhone") String ExecutorPhone);

    @Update("update task set TState=3 where TaskId=#{TaskId}")
    Integer undoTaskUpdate(@Param("TaskId") String TaskId);

    @Update("update task set TState=5 where TaskId=#{TaskId}")
    Integer finishTaskUpdate(@Param("TaskId") String TaskId);

    @Update("update task set TState=6 where TaskId=#{TaskId}")
    Integer confirmFinishUpdate(@Param("TaskId") String TaskId);

    @Select("select count(*) from task")
    Integer taskTotal();

    @Select("select * from task where TState=1")
    List<Task> queryForTaskChecked();

    @Select("select * from task where TState=0")
    List<Task> queryForTaskCheck();

    @Update("update task set TState=11 where TaskId=#{TaskId}")
    Integer discardTask(@Param("TaskId") String TaskId);

    @Select("select * from task where TState=0 limit #{offset},#{size}")
    List<Task> queryForTaskCheckPage(@Param("offset") Integer offset, @Param("size") Integer size);

    @Update("update task set TState=1 where TaskId=#{TaskId}")
    Integer taskPassUpdate(@Param("TaskId") String TaskId);

    @Update("update task set TState=2 where TaskId=#{TaskId}")
    Integer taskWrongUpdate(@Param("TaskId") String TaskId);

    @Select("select * from task where TState=7")
    List<Task> queryForTaskComplain();

    @Select("select * from task where TState=7 limit #{offset},#{size}")
    List<Task> queryForTaskComplainPage(@Param("offset") Integer offset, @Param("size") Integer size);

    @Update("update task set TState=7 where TaskId=#{TaskId}")
    Integer complainTaskUpdate(@Param("TaskId") String TaskId);

    @Update("update task set TState=8 where TaskId=#{TaskId}")
    Integer complainTaskPassUpdate(@Param("TaskId") String TaskId);

    @Update("update task set TState=9 where TaskId=#{TaskId}")
    Integer complainTaskWrongUpdate(@Param("TaskId") String TaskId);

    @Update("update task set TState=10 where TaskId=#{TaskId}")
    Integer complainTaskCancelUpdate(@Param("TaskId") String TaskId);

    @Update("update task set AppealReason=#{AppealReason} where TaskId=#{TaskId}")
    Integer addReasonUpdate(@Param("TaskId") String TaskId, @Param("AppealReason") String AppealReason);

    @Update("update task set TState=10 where TaskId=#{TaskId}")
    Integer undoComplain(@Param("TaskId") String TaskId);

    @Update("update task set Score=#{Score} where TaskId=#{TaskId}")
    Integer giveScore(@Param("TaskId") String TaskId, @Param("Score") double Score);
}
