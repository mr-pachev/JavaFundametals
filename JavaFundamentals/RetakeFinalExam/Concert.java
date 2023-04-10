package RetakeFinalExam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> timeMap = new LinkedHashMap<>();
        Map<String, List<String>> membersMap = new LinkedHashMap<>();

        while (!input.equals("Start!")) {
            String command = input.split("; ")[0];
            String band = input.split("; ")[1];

            if (command.equals("Add")) {
                List<String> addList = Arrays.stream(input.split("[;,]")).collect(Collectors.toList());

                if (membersMap.containsKey(band)) {
                    List<String> membersList = membersMap.get(band);
                    membersMap.put(band, membersCheck(addList, membersList));
                } else {
                    List<String> membersList = members(addList);
                    membersMap.put(band, membersList);
                    if (timeMap.get(band) == null) {
                        timeMap.put(band, 0);
                    }
                }

            } else if (command.equals("Play")) {
                int time = Integer.parseInt(input.split("; ")[2]);

                if (membersMap.containsKey(band)) {
                    int currentBandTime = timeMap.get(band);
                    currentBandTime += time;
                    timeMap.put(band, currentBandTime);
                } else {
                    timeMap.put(band, time);
                }
            }

            input = scanner.nextLine();
        }
        int totalTime = totalTime(timeMap);

        System.out.printf("Total time: %d%n", totalTime);

        for (Map.Entry<String, Integer> entry : timeMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, List<String>> entry : membersMap.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("=>%s%n", entry.getValue().get(i));
            }
            break;
        }

    }

    //добавяне на членове към групата
    public static List<String> members(List<String> list) {
        List<String> addMemebers = new ArrayList<>();
        for (int i = 2; i < list.size(); i++) {
            addMemebers.add(list.get(i));
        }
        return addMemebers;
    }

    //проверка дали даден член съществува
    public static List<String> membersCheck(List<String> listInput, List<String> currentList) {

        for (int i = 2; i < listInput.size(); i++) {
            if (!currentList.contains(listInput.get(i))) {
                currentList.add(listInput.get(i));
            }
        }
        return currentList;
    }

    //намиране на общото време на сцената
    public static Integer totalTime(Map<String, Integer> time) {
        int allTime = 0;
        for (Map.Entry<String, Integer> entry : time.entrySet()) {
            allTime += entry.getValue();
        }
        return allTime;
    }
}
