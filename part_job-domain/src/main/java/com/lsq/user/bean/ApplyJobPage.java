package com.lsq.user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyJobPage {
    private int total;

    private List<ApplyJobReturn> applyJobs;
}
