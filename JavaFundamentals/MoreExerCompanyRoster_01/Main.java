package MoreExerCompanyRoster_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double averageSalary = 0; //средна заплата на отдела
        int counterCurrentDepartmentSalary = 0; //брояч на заплатите в най-добре заплатения отдел
        double maxSalary = 0;
        String theBestDepartment = "";
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
