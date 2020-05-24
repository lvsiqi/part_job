package com.lsq.user.bean;

import com.lsq.job.domain.PartTimeJob;
import com.lsq.user.domain.ApplyForJob;
import com.lsq.user.domain.User;
import com.lsq.user.domain.UserDetail;
import lombok.Data;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/5/10 16:23
 */
@Data
public class ApplyJobReturn {
    private ApplyForJob applyForJob;

    private PartTimeJob partTimeJob;

    private User user;

    private UserDetail userDetail;
}

