import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> teamMap = new LinkedHashMap<>();

        for (int currentTeam = 1; currentTeam <= n; currentTeam++) {
            String[] input = scanner.nextLine().split("-");
            String creator = input[0];
            String team = input[1];

            //пълнене на речника с екип и дъздател според условията
            if (teamMap.containsKey(team)) {
                System.out.printf("Team %s was already created!%n", team);
                continue;
            }
            if (isExist(teamMap, creator)) {
                System.out.printf("%s cannot create another team!%n", creator);
                continue;
            }
            List<String> teamList = new ArrayList<>();
            teamList.add(creator);
            teamMap.put(team, teamList);
            System.out.printf("Team %s has been created by %s!%n", team, creator);

        }

        String input = scanner.nextLine();

        //входни данни до получаване на определената команда за спиране
        while (!input.equals("end of assignment")) {
            String[] inputData = input.split("->");

            String user = inputData[0];
            String teamName = inputData[1];

            //допълване на екипите според условията
            if (!teamMap.containsKey(teamName)) {
                System.out.printf("Team %s does not exist!%n", teamName);
                input = scanner.nextLine();
                continue;
            }
            if (isExist(teamMap, user)) {
                System.out.printf("Member %s cannot join team %s!%n", user, teamName);
                input = scanner.nextLine();
                continue;
            }

            List<String> teamList = teamMap.get(teamName);
            teamList.add(user);
            teamMap.put(teamName, teamList);

            input = scanner.nextLine();
        }

        teamMap = teamMap.entrySet().stream()
                .sorted((s1, s2) -> {
                    int sort = Integer.compare(s2.getValue().size(), s1.getValue().size());
                    if (sort == 0) {
                        sort = s1.getKey().compareTo(s2.getKey());
                    }
                    return sort;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        for (Map.Entry<String, List<String>> entry : teamMap.entrySet()) {

            if (entry.getValue().size() > 1) {
                System.out.println(entry.getKey());
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (i == 0) {
                        System.out.printf("- %s%n", entry.getValue().get(i));
                    } else {
                        System.out.printf("-- %s%n", entry.getValue().get(i));
                    }
                }
            }
        }
        System.out.println("Teams to disband:");

        for (Map.Entry<String, List<String>> entry1 : teamMap.entrySet()) {
            if (entry1.getValue().size() == 1) {
                System.out.println(entry1.getKey());
            }
        }
    }

    //метод за проверка дали създателя вече го има в речника
    public static boolean isExist(Map<String, List<String>> map, String creator) {
        boolean isExist = false;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().get(0).equals(creator)) {
                isExist = true;
            }
        }
        return isExist;
    }
}