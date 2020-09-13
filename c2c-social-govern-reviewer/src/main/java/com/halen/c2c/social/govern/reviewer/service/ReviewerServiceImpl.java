package com.halen.c2c.social.govern.reviewer.service;

import com.halen.c2c.social.govern.reviewer.api.ReviewerService;
import com.halen.c2c.social.govern.reviewer.dao.ReviewerTaskStatusDao;
import com.halen.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

@Service(
        version = "1.0.0",
        interfaceClass = ReviewerService.class,
        cluster = "failfast",
        loadbalance = "roundrobin"
)
public class ReviewerServiceImpl implements ReviewerService {

    @Autowired
    private ReviewerTaskStatusDao reviewerTaskStatusDao;

    @Override
    public List<Long> selectReviewers(Long reportTaskId) {
        System.out.println("模拟通过算法选择一批评审员");
        List<Long> reviewIds = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        for (Long id : reviewIds) {
            ReviewerTaskStatus reviewerTaskStatus = new ReviewerTaskStatus();
            reviewerTaskStatus.setReviewerId(id);
            reviewerTaskStatus.setReportTaskId(reportTaskId);
            reviewerTaskStatus.setStatus(ReviewerTaskStatus.PROCESSING);
            reviewerTaskStatusDao.add(reviewerTaskStatus);
        }
        return reviewIds;
    }

    @Override
    public void finishVote(Long reviewerId, Long reportTaskId) {
        ReviewerTaskStatus reviewerTaskStatus = new ReviewerTaskStatus();
        reviewerTaskStatus.setReportTaskId(reportTaskId);
        reviewerTaskStatus.setReviewerId(reviewerId);
        reviewerTaskStatus.setStatus(ReviewerTaskStatus.FINISHED);
        reviewerTaskStatusDao.update(reviewerTaskStatus);
    }
}
