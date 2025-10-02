package com.gautam.emailai.dtos;

import lombok.Data;

@Data
public class EmailRequest {
    private String content;
    private String tone;
}
