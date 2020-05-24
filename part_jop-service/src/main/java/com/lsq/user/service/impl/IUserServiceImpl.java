package com.lsq.user.service.impl;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.LoginResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.job.bean.QueryPageBean;
import com.lsq.job.domain.PartTimeJob;
import com.lsq.job.repository.IApplyForJobRepository;
import com.lsq.job.repository.IPartTimeJobRepository;
import com.lsq.merchant.domain.Merchant;
import com.lsq.merchant.repository.IMerchantRepository;
import com.lsq.user.bean.QueryApplyJob;
import com.lsq.user.bean.UserItems;
import com.lsq.user.bean.UserLoginReturn;
import com.lsq.user.domain.User;
import com.lsq.user.domain.UserDetail;
import com.lsq.user.repository.IUserDetailRepository;
import com.lsq.user.repository.IUserRepository;
import com.lsq.user.service.IUserService;
import com.lsq.user.util.UserCF;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.lsq.constants.LoginConstants.*;
import static com.lsq.constants.SystemConstants.*;
import static com.lsq.constants.UserConstants.*;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/4/21 21:01
 */
@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserDetailRepository userDetailRepository;

    @Autowired
    private IApplyForJobRepository applyForJobRepository;

    @Autowired
    private IPartTimeJobRepository partTimeJobRepository;

    @Autowired
    private IMerchantRepository merchantRepository;

    @Override
    public BaseResponse userLoginCheck(User user) {
        User result = userRepository.selectByAccount(user.getAccount());
        UserDetail detail = userDetailRepository.selectByAccount(user.getAccount());
        if (detail == null) {
            detail = new UserDetail();
        }
        if (result == null) {
            return new LoginResponse<>(LOGIN_FAIL_KEY, new UserLoginReturn(user, detail, LOGIN_ERROR_001));
        }
        if (StringUtils.equals(user.getPassword(), result.getPassword())) {
            return new LoginResponse<>(LOGIN_SUCCESS_KEY, new UserLoginReturn(result, detail, LOGIN_SUCCESS_DESCRIPTION));
        } else {
            return new LoginResponse<>(LOGIN_FAIL_KEY, new UserLoginReturn(user, detail, LOGIN_ERROR_002));
        }
    }

    @Override
    public BaseResponse userRegister(User user) {
        User db = userRepository.selectByAccount(user.getAccount());
        Merchant db2 = merchantRepository.selectByAccount(user.getAccount());
        user.setCreateTime(new Date());
        user.setState(USER_STATE_001);
        if (db != null || db2 != null) {
            return new SystemResponse<>(SYSTEM_FAIL_KEY, USER_REGISTER_ERROR_001);
        } else if (userRepository.insertSelective(user) == 1) {
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, USER_REGISTER_SUCCESS);
        } else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY, USER_REGISTER_SUCCESS);
        }
    }

    @Override
    public BaseResponse userUpdate(User user) {
        user.setUpdateTime(new Date());
        if (userRepository.updateByAccountSelective(user) != 1) {
            return new SystemResponse<>(SYSTEM_FAIL_KEY, USER_UPDATE_FAIL);
        } else {
            User temp = userRepository.selectByAccount(user.getAccount());
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, temp);
        }
    }

    @Override
    public BaseResponse userCF(User user) {
        List<String> accountList = userRepository.selectAllAccount();
        List<UserItems> userItemsList = new ArrayList<>();
        for (String account : accountList) {
            UserItems userItems = new UserItems();
            List<Long> tempItems = applyForJobRepository.selectJobIdByUserAccount(account);
            userItems.setAccount(account);
            if (tempItems == null || tempItems.size() == 0) {
                continue;
            }
            userItems.setItems(tempItems);
            userItemsList.add(userItems);
        }
        if (applyForJobRepository.selectByUserAccount(user.getAccount()) == null || applyForJobRepository.selectByUserAccount(user.getAccount()).size() == 0) {
            return new SystemResponse<>(SYSTEM_FAIL_KEY, "用户无行为记录");
        }
        Map<Long, Double> results = UserCF.userCF(userItemsList, user.getAccount(), SYSTEM_RECOMMEND_TOP);
        List<Map.Entry<Long, Double>> list = new ArrayList<>(results.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        results.clear();
        for (Map.Entry<Long, Double> mapEntry : list) {
            results.put(mapEntry.getKey(), mapEntry.getValue());
        }
        Iterator it = results.entrySet().iterator();
        List<Long> topN = new ArrayList<>();
        int num = 0;
        while (it.hasNext()) {
            if (num >= JOB_RECOMMEND_TOP) {
                break;
            }
            Map.Entry entity = (Map.Entry) it.next();
            topN.add((Long) entity.getKey());
            num++;
        }
        List<PartTimeJob> recommends = new ArrayList<>();
        for (Long jobId : topN) {
            recommends.add(partTimeJobRepository.selectByPrimaryKey(jobId));
        }
        return new SystemResponse<>(SYSTEM_SUCCESS_KEY, recommends);
    }

    @Override
    public BaseResponse selectByUserDetail(UserDetail userDetail) {
        QueryPageBean queryPageBean = new QueryPageBean();
        if (userDetail.getLabelList().length == 0) {
            queryPageBean.setLimitStart(0);
            queryPageBean.setPageSize(10);
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, partTimeJobRepository.selectPageByFactor(queryPageBean));
        } else {
            List<PartTimeJob> results = new ArrayList<>();
            for (String type : userDetail.getLabelList()) {
                queryPageBean.setLimitStart(0);
                queryPageBean.setPageSize(10);
                queryPageBean.setJobType(type);
                results.addAll(partTimeJobRepository.selectPageByFactor(queryPageBean));
            }
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, results);
        }
    }
}
