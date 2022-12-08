package MoreExerCompanyRoster_01;

public class Department {
    private String department;
    private double salary;
    private String name;

    public Department(String department, double salary, String name) {
        this.department = department;
        this.salary = salary;
        this.name = name;
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

    public double setSalary(double salary) {
        return this.salary+=salary;
    }

}
