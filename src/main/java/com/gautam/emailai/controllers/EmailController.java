package com.gautam.emailai.controllers;

import com.gautam.emailai.dtos.EmailRequest;
import com.gautam.emailai.services.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Value("${FRONTEND_URL}")
    private String FRONTEND_URL;

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @CrossOrigin(origins = "${FRONTEND_URL}")
    @PostMapping("/generate")
    public ResponseEntity<String> emailGenerator(@RequestBody EmailRequest emailRequest) {
        String response = emailService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);
    }

}
