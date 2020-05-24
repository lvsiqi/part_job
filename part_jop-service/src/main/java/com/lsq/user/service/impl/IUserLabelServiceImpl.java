package com.lsq.user.service.impl;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.job.repository.IJobTypeConfigRepository;
import com.lsq.user.bean.QueryLabel;
import com.lsq.user.bean.UserLabelReturn;
import com.lsq.user.service.IUserLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.lsq.constants.SystemConstants.SYSTEM_SUCCESS_KEY;

@Service
public class IUserLabelServiceImpl implements IUserLabelService {
    @Autowired
    private IJobTypeConfigRepository jobTypeConfigRepository;

    @Override
    public BaseResponse getAllGroup() {
        return new SystemResponse<>(SYSTEM_SUCCESS_KEY, jobTypeConfigRepository.selectAllGroup());
    }

    @Override
    public BaseResponse getLabelByGroup(QueryLabel queryLabel) {
        List<UserLabelReturn> results = new ArrayList<>();
        if (queryLabel != null) {
            for (String groupName : queryLabel.getGroupNames()) {
                UserLabelReturn userLabelReturn = new UserLabelReturn();
                userLabelReturn.setGroupName(groupName);
                userLabelReturn.setLabelValues(jobTypeConfigRepository.selectByGroup(groupName));
                results.add(userLabelReturn);
            }
        }
        return new SystemResponse<>(SYSTEM_SUCCESS_KEY, results);
    }
}
