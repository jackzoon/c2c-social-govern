package com.halen.c2c.social.govern.reviewer.api;

import java.util.List;

/**
 * 评审员服务的接口
 */
public interface ReviewerService {

    /**
     * 选择评审员
     * @param reportTaskId 举报任务ID
     * @return 评审员用户ID
     */
    List<Long> selectReviewers(Long reportTaskId);

    /**
     * 完成投票
     * @param reviewerId 评审员ID
     * @param reportTaskId 举报任务ID
     */
    void finishVote(Long reviewerId, Long reportTaskId);

}
