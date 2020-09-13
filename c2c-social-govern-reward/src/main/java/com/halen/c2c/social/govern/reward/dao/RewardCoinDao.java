package com.halen.c2c.social.govern.reward.dao;

import com.halen.c2c.social.govern.reward.domain.RewardCoin;

public interface RewardCoinDao {
    /**
     * 增加奖励金币记录
     * @param rewardCoin
     */
    void add(RewardCoin rewardCoin);
}
