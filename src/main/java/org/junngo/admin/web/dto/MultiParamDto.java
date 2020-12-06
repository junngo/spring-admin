package org.junngo.admin.web.dto;

import lombok.Data;

@Data
public class MultiParamDto {
    private String account;
    private String email;
    private int page;
}
