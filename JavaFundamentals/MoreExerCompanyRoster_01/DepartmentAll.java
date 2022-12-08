package MoreExerCompanyRoster_01;

public class DepartmentAll {
    private String department;
    private double salary;
    private String name;
    private String position; //длъжност
    private String email; //имейл
    private int age; //възраст

    public DepartmentAll(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
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

    public String getPosition() {
        return this.position;
    }

    public String getEmail() {
        return this.email;
    }

    public int getAge() {
        return this.age;
    }
}
