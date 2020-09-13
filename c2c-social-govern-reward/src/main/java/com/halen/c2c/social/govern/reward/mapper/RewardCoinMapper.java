package com.halen.c2c.social.govern.reward.mapper;

import com.halen.c2c.social.govern.reward.domain.RewardCoin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RewardCoinMapper {

    @Insert("INSERT INTO reward_coin(reviewer_id,coins) " +
            "VALUES(#{reviewerId},#{coins})")
    void insert(RewardCoin rewardCoin);

}
