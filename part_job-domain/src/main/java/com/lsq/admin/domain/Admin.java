package com.lsq.admin.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Admin {
    private Integer id;

    @NotBlank(message = "账号不能为空")
    private String account;

    @NotBlank(message = "密码不能为空")
    private String password;

}
