package com.halen.c2c.social.govern.report.service;

import com.halen.c2c.social.govern.report.domain.ReportTaskVote;

import java.util.List;

/**
 * 举报任务投票Service接口
 */
public interface ReportTaskVoteService {
    /**
     * 初始化评审员对举报任务的投票
     * @param reviewerIds
     * @param reportTaskId
     */
    void initVote(List<Long> reviewerIds, Long reportTaskId);

    void vote(Long reviewerId, Long reportTaskId, Integer voteResult);

    /**
     * 对举报任务进行归票
     * @param reportTaskId 举报任务ID
     */
    Boolean calculateVotes(Long reportTaskId);

    /**
     * 查询举报任务下的所有投票
     * @param reportTaskId 举报任务ID
     * @return
     */
    List<ReportTaskVote> queryByReportTaskId(Long reportTaskId);
}
