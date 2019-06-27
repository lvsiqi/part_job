package com.lsq.merchant.bean;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CompanyTypeReturn {
    String group;
    ArrayList<String> values;
}
