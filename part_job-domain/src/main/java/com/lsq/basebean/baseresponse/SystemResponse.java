package com.lsq.basebean.baseresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/3/25 10:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemResponse<T> implements BaseResponse {
    private String state;

    private T messages;
}
