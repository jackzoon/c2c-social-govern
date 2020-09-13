package com.halen.c2c.social.govern.reward.service;

import com.halen.c2c.social.govern.reward.api.RewardService;
import com.halen.c2c.social.govern.reward.dao.RewardCoinDao;
import com.halen.c2c.social.govern.reward.domain.RewardCoin;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(
        version = "1.0.0",
        interfaceClass = RewardService.class,
        cluster = "failfast",
        loadbalance = "roundrobin"
)
public class RewardServiceImpl implements RewardService {

    @Autowired
    private RewardCoinDao rewardCoinDao;

    @Override
    public void giveReward(List<Long> reviewerIds) {
        for (Long reviewerId : reviewerIds) {
            RewardCoin rewardCoin = new RewardCoin();
            rewardCoin.setReviewerId(reviewerId);
            rewardCoin.setCoins(10L);
            rewardCoinDao.add(rewardCoin);
        }
    }
}
