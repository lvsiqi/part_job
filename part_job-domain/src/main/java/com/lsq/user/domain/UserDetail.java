package com.lsq.user.domain;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/5/2 10:20
 */
@Data
public class UserDetail {
    private Long id;

    private String account;

    private String hobby = "";

    private String speciality = "";

    private String label;

    private String experience = "";

    private String evaluation = "";

    private String[] labelList;

    public void labelConvert() {
        if (this.getLabelList() != null) {
            StringBuffer temp = new StringBuffer();
            for (String labelString : this.getLabelList()) {
                temp.append(labelString);
                temp.append("/");
            }
            if (temp.length() > 0) {
                String a = temp.toString();
                this.setLabel(a.substring(0, a.length() - 1));
            } else {
                this.setLabel("");
            }
        }
    }
}