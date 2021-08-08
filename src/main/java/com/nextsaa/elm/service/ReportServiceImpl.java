package com.nextsaa.elm.service;

import com.nextsaa.elm.dto.LeaveReportDTO;
import com.nextsaa.elm.repository.LeaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final LeaveRepository leaveRepository;

    public ReportServiceImpl(final LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Override
    public List<LeaveReportDTO> retrieveLeaveReports() {
        return leaveRepository.generateLeaveReport();
    }
}
