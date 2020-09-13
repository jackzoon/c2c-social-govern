package com.halen.c2c.social.govern.reviewer.dao;

import com.halen.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;
import com.halen.c2c.social.govern.reviewer.mapper.ReviewerTaskStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewerTaskStatusDaoImpl implements ReviewerTaskStatusDao {
    @Autowired
    private ReviewerTaskStatusMapper reviewerTaskStatusMapper;

    @Override
    public void add(ReviewerTaskStatus reviewerTaskStatus) {
        reviewerTaskStatusMapper.insert(reviewerTaskStatus);
    }

    @Override
    public void update(ReviewerTaskStatus reviewerTaskStatus) {
        reviewerTaskStatusMapper.update(reviewerTaskStatus);
    }
}
