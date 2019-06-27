package com.lsq.job.service.impl;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.basebean.baseresponse.SystemResponse;
import com.lsq.job.bean.JobPageBean;
import com.lsq.job.bean.JobTypeAvgSalary;
import com.lsq.job.bean.JobTypeReturn;
import com.lsq.job.bean.QueryPageBean;
import com.lsq.job.domain.JobSalaryAverage;
import com.lsq.job.domain.JobTypeConfig;
import com.lsq.job.domain.PartTimeJob;
import com.lsq.job.repository.IJobSalaryAverageRepository;
import com.lsq.job.repository.IJobTypeConfigRepository;
import com.lsq.job.repository.IPartTimeJobRepository;
import com.lsq.job.service.IPartTimeJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lsq.constants.SystemConstants.*;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/4/6 15:39
 */
@Service
public class IPartTimeJobServiceImpl implements IPartTimeJobService {
    @Autowired
    private IPartTimeJobRepository partTimeJobRepository;
    @Autowired
    private IJobTypeConfigRepository jobTypeConfigRepository;
    @Autowired
    IJobSalaryAverageRepository jobSalaryAverageRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse addPartTimeJob(PartTimeJob partTimeJob) {

        if (partTimeJobRepository.insertSelective(partTimeJob) == 1 && jobSalaryAverageRepository.insertSelective(this.getSalaryAverage(partTimeJob)) == 1) {
            return new SystemResponse<PartTimeJob>(SYSTEM_SUCCESS_KEY, partTimeJob);
        } else {
            return new SystemResponse<PartTimeJob>(SYSTEM_FAIL_KEY, partTimeJob);
        }
    }

    @Override
   public List<JobTypeReturn> selectAllJobType() {
       List<JobTypeConfig> temps = jobTypeConfigRepository.selectAll();
        ArrayList<JobTypeReturn> results = new ArrayList<>();
        Map<String,ArrayList<String>> tempMap = new HashMap<>(5);
        for(JobTypeConfig temp : temps)
        {
            boolean flag = true;
            for (Map.Entry<String,ArrayList<String>> entry : tempMap.entrySet()) {
                if(entry.getKey().equals(temp.getGroup())){
                    tempMap.get(temp.getGroup()).add(temp.getValue());
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ArrayList<String> a = new ArrayList<>();
                a.add(temp.getValue());
                tempMap.put(temp.getGroup(),a);
            }
        }
        for (Map.Entry<String,ArrayList<String>> entry : tempMap.entrySet()) {
            JobTypeReturn jobTypeReturn =new JobTypeReturn();
            jobTypeReturn.setGroup(entry.getKey());
            jobTypeReturn.setValues(entry.getValue());
            results.add(jobTypeReturn);
        }

        return results;
    }

    @Override
    public BaseResponse selectJobPageByAccount(QueryPageBean queryPageBean) {
        if(queryPageBean != null) {
            queryPageBean.setLimitStart((queryPageBean.getPageNum() - 1) * queryPageBean.getPageSize());
            int total = partTimeJobRepository.selectCountByAccount(queryPageBean.getAccount());
            List<PartTimeJob> partTimeJobs = partTimeJobRepository.selectPageByAccount(queryPageBean);
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, new JobPageBean(total, partTimeJobs));
        }
        else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY,null);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse deleteById(Long id) {
        if(partTimeJobRepository.deleteByPrimaryKey(id) == 1 && jobSalaryAverageRepository.deleteByJobId(id) == 1){
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY,null);
        }else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY, null);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse updateById(PartTimeJob record) {
        if(partTimeJobRepository.updateByPrimaryKeySelective(record) == 1 && jobSalaryAverageRepository.updateByJobIdSelective(this.getSalaryAverage(record)) == 1){
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY,null);
        }else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY,null);
        }
    }

    @Override
    public BaseResponse selectJobPageByName(QueryPageBean queryPageBean) {
        if(queryPageBean != null) {
            queryPageBean.setLimitStart((queryPageBean.getPageNum() - 1) * queryPageBean.getPageSize());
            int total = partTimeJobRepository.selectCountByName(queryPageBean.getJobName());
            List<PartTimeJob> partTimeJobs = partTimeJobRepository.selectPageByName(queryPageBean);
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, new JobPageBean(total, partTimeJobs));
        }
        else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY,null);
        }
    }

    @Override
    public BaseResponse selectJobPageAll(QueryPageBean queryPageBean) {
        if(queryPageBean != null) {
            queryPageBean.setLimitStart((queryPageBean.getPageNum() - 1) * queryPageBean.getPageSize());
            int total = partTimeJobRepository.selectCountAll();
            List<PartTimeJob> partTimeJobs = partTimeJobRepository.selectPageAll(queryPageBean);
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, new JobPageBean(total, partTimeJobs));
        }
        else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY,null);
        }
    }

    @Override
    public BaseResponse selectPageByFactor(QueryPageBean queryPageBean) {
        if(queryPageBean != null) {
            queryPageBean.setLimitStart((queryPageBean.getPageNum() - 1) * queryPageBean.getPageSize());
            int total = partTimeJobRepository.selectCountByFactor(queryPageBean);
            List<PartTimeJob> partTimeJobs = partTimeJobRepository.selectPageByFactor(queryPageBean);
            return new SystemResponse<>(SYSTEM_SUCCESS_KEY, new JobPageBean(total, partTimeJobs));
        }
        else {
            return new SystemResponse<>(SYSTEM_FAIL_KEY,null);
        }
    }

    @Override
    public BaseResponse selectAvgSalaryByType() {
        return new SystemResponse<>(SYSTEM_SUCCESS_KEY, jobSalaryAverageRepository.selectAvgSalaryByType());
    }



    public JobSalaryAverage getSalaryAverage(PartTimeJob partTimeJob){
        JobSalaryAverage jobSalaryAverage = new JobSalaryAverage();
        jobSalaryAverage.setAccount(partTimeJob.getAccount());
        jobSalaryAverage.setAvgSalary(partTimeJob.getAvgSalary());
        jobSalaryAverage.setJobId(partTimeJob.getId());
        jobSalaryAverage.setJobType(partTimeJob.getType());
        return jobSalaryAverage;
    }

}
