import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> dataList = new ArrayList<>();
        Map<String, List<Integer>> conquestMap = new LinkedHashMap<>();

        while(!input.equals("Sail")){
            String city = input.split("\\|\\|")[0];
            int people = Integer.parseInt(input.split("\\|\\|")[1]);
            int golds = Integer.parseInt(input.split("\\|\\|")[2]);

            if (!conquestMap.containsKey(city)){
                dataList.add(people);
                dataList.add(golds);
                conquestMap.put(city, dataList);
            }else {
                dataList = conquestMap.get(city);
                dataList.set(0, people);
                dataList.set(1, golds);
            }

            input = scanner.nextLine();
        }
    }
}
