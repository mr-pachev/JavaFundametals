package MoreExerCompanyRoster_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();

        for (int currentEmployee = 1; currentEmployee <= n; currentEmployee++) { //цикъл според въведените брой служители
            String[] incoming = scanner.nextLine().split(" ");

            String name = incoming[0]; //име на служителя
            double salary = Double.parseDouble(incoming[1]); //заплата на служителя
            String position = incoming[2]; //длъжност на служителя
            String currentDepartment = incoming[3]; //отдел, в който работи служителя
            String email = "n/a"; //имейл на служителя
            int age = -1; //години на служителя

            if (incoming.length == 5) { //проверка дали входящите данни съдържат имейл или години
                if (isNumeric(incoming[4])) {
                    age = Integer.parseInt(incoming[4]);
                } else {
                    email = incoming[4];
                }
            } else if (incoming.length > 4) { //входящите данни съдържат и имейл и години
                email = incoming[4];
                age = Integer.parseInt(incoming[5]);
            }

            Employee employee = new Employee(name, salary, position, currentDepartment, email, age); //създаване на обект служител
            employeeList.add(employee); //вкарване на обекта служител в списък
        }

        for (Employee employee : employeeList) { //обхождаме листа със служителите
            String departmentOfEmployee = employee.getDepartment(); //отдела на конкретния служител
            Department department = new Department(employee.getDepartment(), employee.getSalary(), employee.getName()); //създаване на обект отдел
            double salaryOfDepartment = employee.getSalary(); //заплата на конкретния отдел и служител от завъртането

            if (departmentList.isEmpty()) { //проверка дали листа с отделите е празен
                departmentList.add(department);
                continue;
            }

            for (Department departmentObject : departmentList) { //обхождане на листа с отделите за сумиране на заплатите
                String departmentOfDepartment = departmentObject.getDepartment(); //конкретния отдел от списъка с отдели

                if (!departmentOfDepartment.equals(departmentOfEmployee)) { //проверка дали отдела съществува в списъка с отдели
                    departmentList.add(department); //създаване добавяне на отдел в списъка
                    break;
                } else {
                    departmentObject.setSalary(salaryOfDepartment);
                    break;
                }
            }

        }
        double maxSalary = 0;
        String bestDepartment = "";

        for (Department department : departmentList){ //обхождане на листа с отделите, зада се извади отдела с най-високи заплати
            if ((department.getSalary()) >= maxSalary){
                maxSalary = department.getSalary();
                bestDepartment = department.getDepartment();
            }
        }
        List<DepartmentAll> departmentAllList = new ArrayList<>(); //списък със служителите на най-

        for (Employee employee : employeeList) { //обхождаме листа със служителите
            String departmentOfEmployee = employee.getDepartment(); //отдела на конкретния служител

            if (departmentOfEmployee.equals(bestDepartment)){
                DepartmentAll department = new DepartmentAll(employee.getName(), employee.getSalary(), employee.getPosition(), employee.getDepartment(), employee.getEmail(), employee.getAge());
                departmentAllList.add(department);
            }
        }
        System.out.println();
    }

    //метод за проверка даден стринг дали е число
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
