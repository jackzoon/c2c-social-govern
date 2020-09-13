package com.halen.c2c.social.govern.report.mapper;

import com.halen.c2c.social.govern.report.domain.ReportTaskVote;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReportTaskVoteMapper {

    /**
     * 插入举报任务投票
     * @param reportTaskVote
     */
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    @Insert("INSERT INTO report_task_vote(reviewer_id,report_task_id,vote_result)" +
            " VALUES(#{reviewerId},#{reportTaskId},#{voteResult})")
    void insert(ReportTaskVote reportTaskVote);

    /**
     * 更新举报任务投票
     * @param reportTaskVote
     */
    @Update("UPDATE report_task_vote SET " +
            "vote_result = #{voteResult} " +
            "WHERE reviewer_id = #{reviewerId} " +
            "AND report_task_id = #{reportTaskId}")
    void update(ReportTaskVote reportTaskVote);

    @Select("SELECT * FROM report_task_vote WHERE report_task_id = #{reportTaskId}")
    List<ReportTaskVote> selectByReportTaskId(Long reportTaskId);
}
