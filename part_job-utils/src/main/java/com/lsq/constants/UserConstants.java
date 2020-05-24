package com.lsq.constants;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/4/22 14:33
 */
public interface UserConstants {
    String USER_REGISTER_ERROR_001 = "账户已存在";

    String USER_REGISTER_SUCCESS = "注册成功";

    String USER_UPDATE_FAIL = "更新失败";

    String USER_UPDATE_SUCCESS = "更新成功";

    String USER_DETAIL_UPDATE_ERROR_001 = "该用户信息不存在";

    String USER_DETAIL_UPDATE_ERROR_002 = "信息已存在，不能重复添加";

    String USER_STATE_001 = "Incomplete";

    String USER_STATE_002 = "completed";

    String JOB_APPLY_ERROR_001 = "该工作已申请过";

    String JOB_APPLY_FAIL = "申请失败";

}
