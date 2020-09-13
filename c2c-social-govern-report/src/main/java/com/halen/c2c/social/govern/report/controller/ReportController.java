package com.halen.c2c.social.govern.report.controller;

import com.halen.c2c.social.govern.report.domain.ReportTask;
import com.halen.c2c.social.govern.report.domain.ReportTaskVote;
import com.halen.c2c.social.govern.report.service.ReportTaskService;
import com.halen.c2c.social.govern.report.service.ReportTaskVoteService;
import com.halen.c2c.social.govern.reviewer.api.ReviewerService;
import com.halen.c2c.social.govern.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 举报服务
 */
@RestController
public class ReportController {

    @Reference(version = "1.0.0",
            interfaceClass = ReviewerService.class,
            cluster = "failfast")
    private ReviewerService reviewerService;

    @Reference(version = "1.0.0",
            interfaceClass = RewardService.class,
            cluster = "failfast")
    private RewardService rewardService;

    @Autowired
    private ReportTaskService reportTaskService;
    @Autowired
    private ReportTaskVoteService reportTaskVoteService;

    /**
     * 提交举报接口
     * @param reportTask
     * @return
     */
    @GetMapping("/report")
    public String report(ReportTask reportTask) {
        // 在本地数据库增加一个举报任务
        reportTaskService.add(reportTask);
        // 调用评审员服务，选择一批评审员
        List<Long> reviewerIds = reviewerService.selectReviewers(reportTask.getId());
        // 在本地数据库初始化这批评审员投票状态
        reportTaskVoteService.initVote(reviewerIds,reportTask.getId());
        // 模拟发送push消息给评审员
        System.out.println("模拟发送push消息给评审员.....");
        return "success";
    }

    /**
     * 查询举报任务
     * @param id
     * @return
     */
    @GetMapping("/report/query/{id}")
    public ReportTask queryReportTaskById(@PathVariable("id") Long id) {
        return reportTaskService.queryById(id);
    }

    /**
     * 对举报任务进行投票
     * @param reviewerId
     * @param reportTaskId
     * @param voteResult
     * @return
     */
    @GetMapping("/report/vote")
    public String vote(Long reviewerId, Long reportTaskId, Integer voteResult) {
        // 本地数据库记录一次投票
        reportTaskVoteService.vote(reviewerId, reportTaskId, voteResult);
        // 调用评审员服务，标记本次投票结束
        reviewerService.finishVote(reviewerId, reportTaskId);
        // 对举报任务进行归票
        Boolean hasFinishVote = reportTaskVoteService.calculateVotes(reportTaskId);

        // 发放奖励
        if (hasFinishVote) {
            List<ReportTaskVote> reportTaskVotes = reportTaskVoteService.queryByReportTaskId(reportTaskId);
            rewardService.giveReward(reportTaskVotes.stream().
                    map(ReportTaskVote::getReviewerId).collect(Collectors.toList()));
            // 推送消息到MQ，告知其他系统，本次评审结果
            System.out.println("推送消息到MQ，告知其他系统，本次评审结果");
        }
        return "success";
    }


}
