package com.cognizant;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.model.Department;
import com.cognizant.model.Employee;
import com.cognizant.model.Skill;
import com.cognizant.service.DepartmentService;
import com.cognizant.service.EmployeeService;
import com.cognizant.service.SkillService;

@SpringBootApplication
public class OrmLearn2Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearn2Application.class);
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	private static void testSaveEmployee() {
		LOGGER.info("Start");
		Department department = departmentService.get(1);
		Employee employee = new Employee();
		employee.setName("Ankana");
		employee.setPermanent(true);
		employee.setDateOfBirth(new Date());
		employee.setSalary(1000.50);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}
	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(5);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}
	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Department department = departmentService.get(1);
		Employee employee = employeeService.get(5);
		employee.setName("Ankana Basu");
		employee.setPermanent(true);
		employee.setDateOfBirth(new Date());
		employee.setSalary(10800.50);
		employee.setDepartment(department);
		employeeService.update(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}
	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department department = departmentService.get(1);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("Department:{}", department.getEmployeeList());
		LOGGER.info("End");
	}
	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(3);
		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		employee.setSkillList(skillList);
		System.out.println(employee.getSkillList());
		employeeService.save(employee);
		LOGGER.info("End");
	}
	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.testGetAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearn2Application.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
//		testSaveEmployee();
//      testGetEmployee();
//		testUpdateEmployee();
//		testGetDepartment();
		testAddSkillToEmployee();
//		testGetEmployee();
//		testGetAllPermanentEmployees();
	}

}
