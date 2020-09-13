package com.halen.c2c.social.govern.report.mapper;

import com.halen.c2c.social.govern.report.domain.ReportTask;
import com.halen.c2c.social.govern.report.domain.ReportTaskVote;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReportTaskMapper {

    /**
     * 插入举报任务
     * @param reportTask
     */
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    @Insert("INSERT INTO report_task(type,report_user_id,report_content,target_id,vote_result)" +
            " VALUES(#{type},#{reportUserId},#{reportContent},#{targetId},#{voteResult})")
    void insert(ReportTask reportTask);

    @Select("SELECT * FROM report_task WHERE id = #{id}")
    ReportTask selectById(@Param("id") Long id);

    /**
     * 更新举报任务
     * @param reportTask
     */
    @Update("UPDATE report_task SET vote_result=#{voteResult} WHERE id = #{id}")
    void update(ReportTask reportTask);

}
