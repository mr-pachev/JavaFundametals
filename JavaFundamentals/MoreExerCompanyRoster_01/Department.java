package MoreExerCompanyRoster_01;

public class Department {
    private String department;
    private String employee;
    private double  salary;

    public Department(String department, String employee, double salary){
        this.department = department;
        this.employee = employee;
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getDepartment(){
        return this.department;
    }
}
