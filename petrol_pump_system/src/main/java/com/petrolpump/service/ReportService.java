package com.petrolpump.service;

import com.petrolpump.model.Report;
import com.petrolpump.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report generateReport(Report report) {
        return reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportByDate(LocalDate date) {
        return reportRepository.findByDate(date)
                .orElseThrow(() -> new RuntimeException("No report found for date: " + date));
    }
}
