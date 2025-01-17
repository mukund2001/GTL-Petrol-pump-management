package com.petrolpump.controller;

import com.petrolpump.model.Report;
import com.petrolpump.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping
    public Report generateReport(@RequestBody Report report) {
        return reportService.generateReport(report);
    }

    @GetMapping("/all")
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{date}")
    public Report getReportByDate(@PathVariable String date) {
        // Convert the string to a LocalDate before calling service
        LocalDate parsedDate = LocalDate.parse(date);
        return reportService.getReportByDate(parsedDate);
    }
}
