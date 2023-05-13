package com.springBoot.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springBoot.Entity.Employee;
import com.springBoot.Service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String showPage(Model m) {

		List<Employee> emplist = service.getAllEmp();
		m.addAttribute("emplist", emplist);
		return "index";
	}

	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_employee";
	}

	@PostMapping("/register")
	public String registerEmp(@ModelAttribute Employee e, HttpSession session) {
		System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg", "Employee Added Successfuly!");
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = service.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}

	@PostMapping("/update")
	public String editEmployee(@ModelAttribute Employee e, HttpSession session) {

		session.setAttribute("msg", "Employee Edited Successfuly..");
		service.addEmp(e);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id, HttpSession session) {
		session.setAttribute("msg", "Employee Deleted Successfuly..");
		service.deleteEmp(id);
		return "redirect:/";

	}
}
