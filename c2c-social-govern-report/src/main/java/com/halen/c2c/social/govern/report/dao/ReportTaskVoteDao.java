package com.halen.c2c.social.govern.report.dao;

import com.halen.c2c.social.govern.report.domain.ReportTaskVote;

import java.util.List;

public interface ReportTaskVoteDao {

    void add(ReportTaskVote reportTaskVote);

    void update(ReportTaskVote reportTaskVote);

    List<ReportTaskVote> queryByReportTaskId(Long reportTaskId);

}
