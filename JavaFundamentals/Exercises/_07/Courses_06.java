package Exercises._07;

import java.util.*;

public class Courses_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> coursesInfoMap = new LinkedHashMap<>(); //мап съдържащ името на курса и броя студенти в него-под формата на списък
        List<String> currentStudentName = new ArrayList<>(); //списък за текущия курс

        while (!input.equals("end")) {
            String courseName = input.split(" \\: ")[0];
            String studentName = input.split(" \\: ")[1];

            if (!coursesInfoMap.containsKey(courseName)) {
                coursesInfoMap.put(courseName, new ArrayList<>()); //пълнене на мапа с нов курс с нов списък за студенти
            }

           coursesInfoMap.get(courseName).add(studentName); //взимане на ТЕКУЩИЯ курс-key и добавянета в списъка МУ на текущ студент-value

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : coursesInfoMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size()); //принтира името на курса и броя участници в него
            entry.getValue().forEach(studentName -> System.out.println("-- " + studentName)); //локален forEach на value-то за принтиране на текущата стойност на мапа-всеки илимент от списъка
        }

    }
}
