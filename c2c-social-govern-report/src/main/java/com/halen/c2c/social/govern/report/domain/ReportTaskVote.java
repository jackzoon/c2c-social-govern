package com.halen.c2c.social.govern.report.domain;

/**
 * 举报任务投票
 */
public class ReportTaskVote {
    /**
     * 未知
     */
    public static final Integer UNKNOWN = -1;
    /**
     * 投票通过
     */
    public static final Integer APPROVED = 1;
    /**
     * 投票未通过
     */
    public static final Integer UNAPPROVED = 2;

    private Long id;
    private Long reviewerId;
    private Long reportTaskId;
    private Integer voteResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Long getReportTaskId() {
        return reportTaskId;
    }

    public void setReportTaskId(Long reportTaskId) {
        this.reportTaskId = reportTaskId;
    }

    public Integer getVoteResult() {
        return voteResult;
    }

    public void setVoteResult(Integer voteResult) {
        this.voteResult = voteResult;
    }
}
