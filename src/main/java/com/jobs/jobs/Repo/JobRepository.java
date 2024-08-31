package com.jobs.jobs.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobs.jobs.Models.Customer;
import com.jobs.jobs.Models.Job;
import com.jobs.jobs.Models.Worker;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCustomer(Customer customer);
    List<Job> findByWorker(Worker worker);
}
