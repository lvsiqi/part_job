package com.lsq.user.bean;

import lombok.Data;

import java.util.List;

@Data
public class UserLabelReturn {
    private String groupName;

    private List<String> labelValues;
}
