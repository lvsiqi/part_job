package com.lsq.user.bean;

import lombok.Data;

import java.util.List;
@Data
public class UserItems {
    private String account;

    private List<Long> items;
}
