package com.gautam.emailai.services;

import com.gautam.emailai.dtos.EmailRequest;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final AiService aiService;

    public EmailService(AiService aiService) {
        this.aiService = aiService;
    }

    public String generateEmailReply(EmailRequest emailRequest) {
        String prompt = buildPrompt(emailRequest);
        return aiService.call(prompt);
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder newPrompt = new StringBuilder();
        newPrompt.append("You are an assistant that drafts professional email replies.\n" +
                "You will be given:\n" +
                "1. The original email content.\n" +
                "2. The tone in which the reply should be written.(If not specified then use professional by default.)\n" +
                "Your task:\n" +
                "1. Generate only the reply email content in the specified tone.\n" +
                "2. Do not include explanations, instructions, or any extra text.\n" +
                "3. The output must be ready to use directly as the email reply.");

        newPrompt.append("Email Content : ").append(emailRequest.getContent());
        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            newPrompt.append("Email Tone : ").append(emailRequest.getTone());
        }
        return newPrompt.toString();
    }
}
