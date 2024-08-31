package com.jobs.jobs.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.jobs.Models.Worker;
import com.jobs.jobs.Repo.WorkerRepository;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    public Worker getWorkerById(Long workerId) {
        return workerRepository.findById(workerId).orElse(null);
    }
}
