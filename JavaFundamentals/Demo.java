import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPlants = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plantaMap = new LinkedHashMap<>();

        for (int currentPlant = 1; currentPlant <= countPlants; currentPlant++) {
            List<Double> plantsInfo = new ArrayList<>();
            String input = scanner.nextLine();

            String plantName = input.split("<->")[0];
            double rarity = Double.parseDouble(input.split("<->")[1]);

            if (plantaMap.containsKey(plantName)){
                plantsInfo = plantaMap.get(plantName);
                plantsInfo.set(0, rarity);
            }

            plantaMap.put(plantName, plantsInfo);
        }
        System.out.println();

    }
}
