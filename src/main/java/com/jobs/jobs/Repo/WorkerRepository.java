package com.jobs.jobs.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobs.jobs.Models.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
