package com.lsq.user.service;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.user.bean.QueryLabel;

public interface IUserLabelService {
    BaseResponse getAllGroup();

    BaseResponse getLabelByGroup(QueryLabel queryLabel);
}
