package Exercises._07;

import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String incoming = scanner.nextLine();
        Map<String, List<String>> companiesEmployeedIdMap = new LinkedHashMap<>(); //мап съдържак компания и ID-та на нейните служители

        while (!incoming.equals("End")) {
            String companiesName = incoming.split(" \\-> ")[0];
            String employeeId = incoming.split(" \\-> ")[1];
            List<String> employeedList = companiesEmployeedIdMap.get(companiesName); // лист с ID-тата на служителите на дадена компания

            if (!companiesEmployeedIdMap.containsKey(companiesName)) { //проверка дали компанията се съдържа в дневника
                companiesEmployeedIdMap.put(companiesName, new ArrayList<>());
                companiesEmployeedIdMap.get(companiesName).add(employeeId);
            } else if (!employeedList.contains(employeeId)) { //проверка дали ID-то на служителя вече не съществува в дадената компания
                companiesEmployeedIdMap.get(companiesName).add(employeeId); //добавяне на ново ID към текущата компания
            }
            incoming = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companiesEmployeedIdMap.entrySet()) {
            System.out.println(entry.getKey()); //принтира името на компанията
            entry.getValue().forEach(iD -> System.out.println("-- " + iD)); //локален forEach на value-то за принтиране на текущата стойност на мапа-всеки елимент от списъка
        }
    }
}

