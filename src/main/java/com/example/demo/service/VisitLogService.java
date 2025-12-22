package com.example.demo.service;

import java.util.List;

import com.example.demo.model.VisitLog;

public interface VisitLogService {

    VisitLog createVisitLog(Long visitorId, VisitLog log);

    VisitLog getLog(Long id);

    List<VisitLog> getLogsByVisitor(Long visitorId);
}
