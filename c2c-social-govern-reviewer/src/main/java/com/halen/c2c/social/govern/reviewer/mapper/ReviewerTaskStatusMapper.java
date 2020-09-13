package com.halen.c2c.social.govern.reviewer.mapper;

import com.halen.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ReviewerTaskStatusMapper {

    /**
     * 插入评审员处理任务状态
     * @param reviewerTaskStatus
     */
    @Insert("INSERT INTO reviewer_task_status(reviewer_id,report_task_id,status)" +
            " VALUES(#{reviewerId},#{reportTaskId},#{status})")
    void insert(ReviewerTaskStatus reviewerTaskStatus);

    /**
     * 更新评审员处理任务的状态
     * @param reviewerTaskStatus
     */
    @Update("UPDATE reviewer_task_status SET status = #{status} WHERE reviewer_id=#{reviewerId}" +
            " AND report_task_id = #{reportTaskId}")
    void update(ReviewerTaskStatus reviewerTaskStatus);

}
