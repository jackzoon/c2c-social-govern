package com.halen.c2c.social.govern.report.service;

import com.halen.c2c.social.govern.report.dao.ReportTaskDao;
import com.halen.c2c.social.govern.report.domain.ReportTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportTaskServiceImpl implements ReportTaskService {
    @Autowired
    private ReportTaskDao reportTaskDao;
    @Override
    public void add(ReportTask reportTask) {
        reportTask.setVoteResult(ReportTask.VOTE_RESULT_UNKNOWN);
        reportTaskDao.add(reportTask);
    }

    @Override
    public ReportTask queryById(Long id) {
        return reportTaskDao.queryById(id);
    }
}
