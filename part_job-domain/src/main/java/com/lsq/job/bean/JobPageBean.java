package com.lsq.job.bean;

import com.lsq.job.domain.PartTimeJob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobPageBean {
    private int total;

    private List<PartTimeJob> partTimeJobs;
}
