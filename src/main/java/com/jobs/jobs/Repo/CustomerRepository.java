package com.jobs.jobs.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobs.jobs.Models.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
