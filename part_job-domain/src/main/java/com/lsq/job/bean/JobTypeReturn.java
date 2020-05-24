package com.lsq.job.bean;

import lombok.Data;
/**
 * @Description: java类作用描述

 * @Author: lvsiqi

 * @CreateDate: 2019/4/6 16:02

 */
import java.util.ArrayList;

@Data
public class JobTypeReturn {
    String group;
    ArrayList<String> values;
}
