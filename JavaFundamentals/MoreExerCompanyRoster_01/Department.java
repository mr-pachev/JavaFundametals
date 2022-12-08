package MoreExerCompanyRoster_01;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String department;
    private double salary;
    private String name;

    private List<Double> salaryList;

    public Department(String department, double salary, String name, List<Double> salaryList) {
        this.department = department;
        this.salary = salary;
        this.name = name;
        this.salaryList = salaryList;
    }

    public String getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getName() {
        return this.name;
    }

    public List<Double> getSalaryList() {
        return this.salaryList;
    }

    public double setSalary(double salary, List<Double> salaryCurrentList) {
        this.salary += salary;
        return this.salary / salaryCurrentList.size();
    }

    public List<Double> setSalaryList(double salary) {
      salaryList.add(salary);
       return salaryList;
    }

}
