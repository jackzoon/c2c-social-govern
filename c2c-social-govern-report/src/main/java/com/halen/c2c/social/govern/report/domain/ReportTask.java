package com.halen.c2c.social.govern.report.domain;

/**
 * 举报任务
 */
public class ReportTask {

    public static final Integer VOTE_RESULT_UNKNOWN = -1;
    public static final Integer VOTE_RESULT_APPROVED = 1;
    public static final Integer VOTE_RESULT_UNAPPROVED = 2;

    private Long id;
    private String type;
    private Long reportUserId;
    private String reportContent;
    private Long targetId;
    private Integer voteResult;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(Long reportUserId) {
        this.reportUserId = reportUserId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Integer getVoteResult() {
        return voteResult;
    }

    public void setVoteResult(Integer voteResult) {
        this.voteResult = voteResult;
    }
}
