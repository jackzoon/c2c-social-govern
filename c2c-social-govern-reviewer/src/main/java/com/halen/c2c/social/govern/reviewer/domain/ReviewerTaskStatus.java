package com.halen.c2c.social.govern.reviewer.domain;

/**
 * 评审员执行任务状态
 */
public class ReviewerTaskStatus {

    /**
     * 处理中
     */
    public static final Integer PROCESSING = 1;

    /**
     * 处理完成
     */
    public static final Integer FINISHED = 2;

    private Long id;
    private Long reviewerId;
    private Long reportTaskId;
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
