package com.halen.c2c.social.govern.reviewer.dao;

import com.halen.c2c.social.govern.reviewer.domain.ReviewerTaskStatus;

public interface ReviewerTaskStatusDao {
    void add(ReviewerTaskStatus reviewerTaskStatus);

    void update(ReviewerTaskStatus reviewerTaskStatus);
}
