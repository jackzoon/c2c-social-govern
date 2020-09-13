package com.halen.c2c.social.govern.report.service;

import com.halen.c2c.social.govern.report.domain.ReportTask;

/**
 * 举报任务Service接口
 */
public interface ReportTaskService {
    void add(ReportTask reportTask);

    ReportTask queryById(Long id);
}
