package com.gautam.emailai.services;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    @Value("${GEMINI_API_KEY}")
    private String GEMINI_API_KEY;

    public String call(String prompt) {
        Client client = Client.builder().apiKey(GEMINI_API_KEY).build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        prompt,
                        null);
        return response.text();
    }
}
