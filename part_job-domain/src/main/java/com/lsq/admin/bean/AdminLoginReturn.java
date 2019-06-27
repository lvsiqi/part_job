package com.lsq.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdminLoginReturn {
    private String account;

    private String identity;

    private String description;
}
