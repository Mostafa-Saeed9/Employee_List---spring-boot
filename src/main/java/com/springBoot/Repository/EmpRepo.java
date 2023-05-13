package com.springBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.Entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
