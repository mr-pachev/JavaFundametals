package FinalExams;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> resultMap = new LinkedHashMap<>(); //речник с резултатите

        for (int i = 1; i <= n; i++) {                        //пълнене на речника
            String input = scanner.nextLine();                //вход на произведението|композитора|гамата

            String piece = input.split("\\|")[0];       //пройзведение
            String composer = input.split("\\|")[1];    //композитор
            String gamma = input.split("\\|")[2];       //гама

            List<String> dataList = resultMap.get(piece);

            if (dataList == null){
                dataList = new ArrayList<>();
            }

            dataList.add(composer);
            dataList.add(gamma);
            resultMap.put(piece, dataList);

        }
        System.out.println();

    }
}
