package FinalExams;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой разстения с тяхната рядкост

        Map<String, List<Double>> plantMap = new LinkedHashMap<>(); //речник съдържащ разстенията
        List<Double> plantInfoList = new ArrayList<>();

        for (int currentPlant = 0; currentPlant < n; currentPlant++) {
            String[] inputArr = scanner.nextLine().split("<->");  //масив от стрингове с входните данни
            String plantName = inputArr[0];                             //име на текущото разстение
            double rarity = Double.parseDouble(inputArr[1]);            //рядкост на текущото разстение

            if(!plantMap.containsKey(plantName)){
                plantInfoList = new ArrayList<>();
                plantInfoList.add(rarity);
                plantMap.put(plantName, plantInfoList);
            }else {
                plantInfoList = plantMap.get(0);
                plantInfoList.set(0, rarity);
            }
        }

        System.out.println();

    }
}
