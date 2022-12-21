package MoreExer_06;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ranking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();
        Map<String, String> coursePassMap = new LinkedHashMap<>(); //дневник с курса и неговата парола

        while (!inputData.equals("end of contests")) {
            String course = inputData.split(":")[0]; //името на курса
            String coursePassword = inputData.split(":")[1]; //паролата на курса

            coursePassMap.put(course, coursePassword); //пълнена на дневника

            inputData = scanner.nextLine();
        }

        inputData = scanner.nextLine();

        while(!inputData.equals("end of submissions"){
        }

    }
}
