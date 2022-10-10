package Exercises._07;

import java.util.*;

public class StudentAcademy_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentDataMap = new LinkedHashMap<>(); //дневник с името на студента и оценките му

        for (int i = 1; i <= n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentDataMap.containsKey(studentName)) { //проверка доли студента се съдържа в дневника
                studentDataMap.put(studentName, new ArrayList<>());
            }
            studentDataMap.get(studentName).add(grade); // към стойността на текущия студента-key се добавя текущата оценка
        }
        Map<String, Double> studentAverageGrade = new LinkedHashMap<>(); //дневник с името на студента и средната оценка навсеки студент

        for (Map.Entry<String, List<Double>> average : studentDataMap.entrySet()) { //обхождане на дневника със студента и оценките му
            String name = average.getKey();
            List<Double> gradeGrade = average.getValue();
            double averageGrade = getAverageGrade(gradeGrade);

            if (averageGrade >= 4.50) {
                studentAverageGrade.put(name, averageGrade);
            }
        }
        studentAverageGrade.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
    }

    public static double getAverageGrade(List<Double> grades) { //метод за намиране на средната оценка на всеки студент
        double sumGrade = 0;
        for (double grade : grades) {
            sumGrade += grade;
        }
        return sumGrade / grades.size();
    }
}
