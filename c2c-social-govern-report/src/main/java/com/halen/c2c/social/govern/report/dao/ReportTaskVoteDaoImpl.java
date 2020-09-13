package com.halen.c2c.social.govern.report.dao;

import com.halen.c2c.social.govern.report.domain.ReportTaskVote;
import com.halen.c2c.social.govern.report.mapper.ReportTaskVoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportTaskVoteDaoImpl implements ReportTaskVoteDao{

    @Autowired
    private ReportTaskVoteMapper reportTaskVoteMapper;

    @Override
    public void add(ReportTaskVote reportTaskVote) {
        reportTaskVoteMapper.insert(reportTaskVote);
    }

    /**
     * 更新举报任务投票
     * @param reportTaskVote
     */
    @Override
    public void update(ReportTaskVote reportTaskVote) {
        reportTaskVoteMapper.update(reportTaskVote);
    }

    @Override
    public List<ReportTaskVote> queryByReportTaskId(Long reportTaskId) {
        return reportTaskVoteMapper.selectByReportTaskId(reportTaskId);
    }
}
