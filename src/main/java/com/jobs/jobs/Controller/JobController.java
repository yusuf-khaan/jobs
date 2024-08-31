package com.jobs.jobs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jobs.jobs.Models.Customer;
import com.jobs.jobs.Models.Job;
import com.jobs.jobs.Models.Worker;
import com.jobs.jobs.ServiceLayer.CustomerService;
import com.jobs.jobs.ServiceLayer.JobService;
import com.jobs.jobs.ServiceLayer.WorkerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    @Autowired
    public JobService jobService;

    @Autowired
    public WorkerService workerService;

    @Autowired
    public CustomerService customerService;

    JobService jobServices = new JobService();

    WorkerService workerServices = new WorkerService();

    @PostMapping("/create")
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @PutMapping("update/{jobId}")
    public Job updateJob(@PathVariable Long jobId, @RequestBody Job jobDetails) {
        return jobService.updateJob(jobId, jobDetails);
    }

    @DeleteMapping("delete/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable Long jobId) {
        jobService.deleteJob(jobId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{jobId}/accept")
    public Job acceptJob(@PathVariable Long jobId, @RequestBody Worker worker) {
        return jobService.acceptJob(jobId, worker);
    }

    @PutMapping("/{jobId}/reject")
    public Job rejectJob(@PathVariable Long jobId) {
        return jobService.rejectJob(jobId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Job> getJobsByCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return jobService.getJobsByCustomer(customer);
    }

    @GetMapping("/worker/{workerId}")
    public List<Job> getJobsByWorker(@PathVariable Long workerId) {
        Worker worker = workerService.getWorkerById(workerId);
        return jobService.getJobsByWorker(worker);
    }

    @GetMapping("getJobDetails/{jobId}")
    public Job getJobDetails(@PathVariable Long jobId) {
        return jobService.getJobDetails(jobId);
    }
}
