package com.halen.c2c.social.govern.report.dao;

import com.halen.c2c.social.govern.report.domain.ReportTask;
import com.halen.c2c.social.govern.report.domain.ReportTaskVote;
import com.halen.c2c.social.govern.report.mapper.ReportTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportTaskDaoImpl implements ReportTaskDao {

    @Autowired
    private ReportTaskMapper reportTaskMapper;

    @Override
    public void add(ReportTask reportTask) {
        reportTaskMapper.insert(reportTask);
    }

    @Override
    public ReportTask queryById(Long id) {
        return reportTaskMapper.selectById(id);
    }

    @Override
    public void update(ReportTask reportTask) {
        reportTaskMapper.update(reportTask);
    }

}
