package com.halen.c2c.social.govern.reward.domain;

/**
 * 奖励金币
 */
public class RewardCoin {
    private Long id;
    private Long reviewerId;
    private Long coins;

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

    public Long getCoins() {
        return coins;
    }

    public void setCoins(Long coins) {
        this.coins = coins;
    }
}
