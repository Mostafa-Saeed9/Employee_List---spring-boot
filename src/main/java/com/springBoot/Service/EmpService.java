package com.springBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.Entity.Employee;
import com.springBoot.Repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo repo;

	public void addEmp(Employee e) {
		repo.save(e);
	}

	public List<Employee> getAllEmp() {

		return repo.findAll();
	}

	public Employee getEmpById(int id) {
		java.util.Optional<Employee> e = repo.findById(id);

		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEmp(int id) {

		repo.deleteById(id);
	}
}
