package com.nextsaa.elm.service;

import com.nextsaa.elm.dto.LeaveReportDTO;

import java.util.List;

public interface ReportService {

    List<LeaveReportDTO> retrieveLeaveReports();
}
