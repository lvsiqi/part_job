package com.lsq.partjob.job.controller;

import com.lsq.basebean.baseresponse.BaseResponse;
import com.lsq.job.bean.JobTypeReturn;
import com.lsq.job.bean.QueryPageBean;
import com.lsq.job.domain.PartTimeJob;
import com.lsq.job.service.IPartTimeJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: lvsiqi
 * @CreateDate: 2019/4/6 14:04
 */
@Controller
@RequestMapping("/job")
public class JobBaseController {
    @Autowired
    private IPartTimeJobService partTimeJobService;

    @RequestMapping("/add_job")
    @ResponseBody
    public BaseResponse addJob(@RequestBody PartTimeJob partTimeJob) {
        partTimeJob.setCreateTime(new Date());
        return partTimeJobService.addPartTimeJob(partTimeJob);
    }

    @RequestMapping("/select_job_type")
    @ResponseBody
    public List<JobTypeReturn> selectJobType() {
        return partTimeJobService.selectAllJobType();
    }

    @RequestMapping("/select_job_by_account")
    @ResponseBody
    public BaseResponse selectJobPageByAccount(@RequestBody QueryPageBean queryPageBean) {
        return partTimeJobService.selectJobPageByAccount(queryPageBean);
    }

    @RequestMapping("/delete_job_by_id")
    @ResponseBody
    public BaseResponse deleteJobById(@RequestBody PartTimeJob partTimeJob) {
        return partTimeJobService.deleteById(partTimeJob.getId());
    }

    @RequestMapping("/update_job")
    @ResponseBody
    public BaseResponse updateJob(@RequestBody PartTimeJob partTimeJob) {
        partTimeJob.setUpdateTime(new Date());
        return partTimeJobService.updateById(partTimeJob);
    }

    @RequestMapping("/select_job_by_name")
    @ResponseBody
    public BaseResponse selectJobByName(@RequestBody QueryPageBean queryPageBean) {
        return partTimeJobService.selectJobPageByName(queryPageBean);
    }

    @RequestMapping("/select_job_all")
    @ResponseBody
    public BaseResponse selectJobAll(@RequestBody QueryPageBean queryPageBean) {
        return partTimeJobService.selectJobPageAll(queryPageBean);
    }

    @RequestMapping("/select_job_by_factor")
    @ResponseBody
    public BaseResponse selectJobByFactor(@RequestBody QueryPageBean queryPageBean) {
        return partTimeJobService.selectPageByFactor(queryPageBean);
    }

}
