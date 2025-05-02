package com.validation.controller;

import com.validation.dto.PatientDischargeRequest;
import com.validation.service.impl.PatientDischargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discharge/api")
public class DischargeProcessEventController {
    @Autowired
    private PatientDischargeService patientDischargeService;

    @PostMapping("/process")
    public String dischargePatient(@RequestBody PatientDischargeRequest request) {
        return patientDischargeService.dischargePatient(request.getPatientId(), request.getPatientName());
    }
}