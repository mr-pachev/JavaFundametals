package Exercises._05;

import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> arrayList = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        Collections.reverse(arrayList); // пренарежда елементите в обратен ред

        System.out.println(arrayList.toString() // превръща списъка в стринг
                .replace("[", "") // замества символа '[' с 'интервал'
                .replace("]", "") // замества символа ']' с 'интервал'
                .trim() // премахва интервала в началото и/или края
                .replaceAll(",", "") // замества "," с "" - премахва запетайките
                .replaceAll("\\s+", " ") // премахва двойният интервал
        );
    }
}