package com.halen.c2c.social.govern.report.service;

import com.halen.c2c.social.govern.report.dao.ReportTaskDao;
import com.halen.c2c.social.govern.report.dao.ReportTaskVoteDao;
import com.halen.c2c.social.govern.report.domain.ReportTask;
import com.halen.c2c.social.govern.report.domain.ReportTaskVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportTaskVoteServiceImpl implements ReportTaskVoteService {

    @Autowired
    private ReportTaskVoteDao reportTaskVoteDao;
    @Autowired
    private ReportTaskDao reportTaskDao;

    @Override
    public void initVote(List<Long> reviewerIds, Long reportTaskId) {
        for (Long reviewerId : reviewerIds) {
            ReportTaskVote vote = new ReportTaskVote();
            vote.setReviewerId(reviewerId);
            vote.setReportTaskId(reportTaskId);
            vote.setVoteResult(ReportTaskVote.UNKNOWN);
            reportTaskVoteDao.add(vote);
        }
    }

    @Override
    public void vote(Long reviewerId, Long reportTaskId, Integer voteResult) {
        ReportTaskVote reportTaskVote = new ReportTaskVote();
        reportTaskVote.setReviewerId(reviewerId);
        reportTaskVote.setReportTaskId(reportTaskId);
        reportTaskVote.setVoteResult(voteResult);
        reportTaskVoteDao.update(reportTaskVote);
    }

    @Override
    public Boolean calculateVotes(Long reportTaskId) {
        List<ReportTaskVote> reportTaskVotes = reportTaskVoteDao.queryByReportTaskId(reportTaskId);
        Integer quorum = reportTaskVotes.size() / 2 + 1;
        Integer approvedVotes = 0;
        Integer unapprovedVotes = 0;
        ReportTask reportTask = new ReportTask();
        reportTask.setId(reportTaskId);
        for (ReportTaskVote reportTaskVote : reportTaskVotes) {
            if (reportTaskVote.getVoteResult().equals(ReportTaskVote.APPROVED)) {
                approvedVotes++;
            } else if (reportTaskVote.getVoteResult().equals(ReportTaskVote.UNAPPROVED)) {
                unapprovedVotes++;
            }
        }
        if (approvedVotes >= quorum) {
            reportTask.setVoteResult(ReportTask.VOTE_RESULT_APPROVED);
        } else if (unapprovedVotes >= quorum) {
            reportTask.setVoteResult(ReportTask.VOTE_RESULT_UNAPPROVED);
        } else {
            return false;
        }
        reportTaskDao.update(reportTask);
        return true;
    }

    @Override
    public List<ReportTaskVote> queryByReportTaskId(Long reportTaskId) {
        return reportTaskVoteDao.queryByReportTaskId(reportTaskId);
    }
}
