package com.halen.c2c.social.govern.report.dao;

import com.halen.c2c.social.govern.report.domain.ReportTask;
import com.halen.c2c.social.govern.report.domain.ReportTaskVote;

import java.util.List;

/**
 * 举报任务Dao接口
 */
public interface ReportTaskDao {

    /**
     * 增加一个举报任务
     * @param reportTask
     */
    void add(ReportTask reportTask);

    /**
     * 根据ID查询举报任务
     * @param id
     * @return
     */
    ReportTask queryById(Long id);

    void update(ReportTask reportTask);
}
