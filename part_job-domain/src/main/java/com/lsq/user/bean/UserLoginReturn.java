package com.lsq.user.bean;

import com.lsq.user.domain.User;
import com.lsq.user.domain.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginReturn {
    private User userData;

    private UserDetail userDetail;

    private String description;
}
