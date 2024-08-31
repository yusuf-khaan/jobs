package com.jobs.jobs.ServiceLayer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.jobs.Models.Customer;
import com.jobs.jobs.Models.Job;
import com.jobs.jobs.Models.Worker;
import com.jobs.jobs.Repo.JobRepository;
import com.jobs.jobs.Repo.CustomerRepository;
import com.jobs.jobs.Repo.WorkerRepository;
import com.jobs.jobs.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
public class JobService {

    public JobService() {
    }

    @Autowired
    JobRepository jobRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    WorkerRepository workerRepository;

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Long jobId, Job jobDetails) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
        job.setTitle(jobDetails.getTitle());
        job.setDescription(jobDetails.getDescription());
        return jobRepository.save(job);
    }

    public void deleteJob(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
        if ("PENDING".equals(job.getStatus())) {
            jobRepository.delete(job);
        }
    }

    public Job acceptJob(Long jobId, Worker worker) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
        job.setStatus("ACCEPTED");
        job.setWorker(worker);
        return jobRepository.save(job);
    }

    public Job rejectJob(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
        job.setStatus("REJECTED");
        return jobRepository.save(job);
    }

    public List<Job> getJobsByCustomer(Customer customer) {
        return jobRepository.findByCustomer(customer);
    }

    public List<Job> getJobsByWorker(Worker worker) {
        return jobRepository.findByWorker(worker);
    }

    public Job getJobDetails(Long jobId) {
        return jobRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
    }
}
