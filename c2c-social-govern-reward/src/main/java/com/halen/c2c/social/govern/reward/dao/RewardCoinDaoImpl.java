package com.halen.c2c.social.govern.reward.dao;

import com.halen.c2c.social.govern.reward.domain.RewardCoin;
import com.halen.c2c.social.govern.reward.mapper.RewardCoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RewardCoinDaoImpl implements RewardCoinDao{

    @Autowired
    private RewardCoinMapper rewardCoinMapper;

    @Override
    public void add(RewardCoin rewardCoin) {
        rewardCoinMapper.insert(rewardCoin);
    }
}
