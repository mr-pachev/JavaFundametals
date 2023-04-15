import java.util.*;

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
            } else if (isExist(teamMap, creator)) {
                System.out.printf("%s cannot create another team!%n", creator);
            } else {
                List<String> teamList = new ArrayList<>();
                teamList.add(creator);
                teamMap.put(team, teamList);
                System.out.printf("Team %s has been created by %s!%n", team, creator);
            }
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
            } else if (isExist(teamMap, user)) {
                System.out.printf("Member %s cannot join team %s!%n", user, teamName);
            } else {
                List<String> teamList = teamMap.get(teamName);
                teamList.add(user);
                teamMap.put(teamName, teamList);
            }
            input = scanner.nextLine();
        }

        List<String> disbandList = new ArrayList<>();
        Map<String, List<String>> finishMap = new LinkedHashMap<>();

        Map<String, List<String>> descByValues = new LinkedHashMap<>();

        teamMap.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
                .forEachOrdered(x -> descByValues.put(x.getKey(), x.getValue()));

        for (String s : descByValues.keySet()) {
            Collections.sort(descByValues.get(s));
        }

        for (Map.Entry<String, List<String>> entry : teamMap.entrySet()) {
            List<String> currentList = descByValues.get(entry.getKey());

            if (entry.getValue().size() == 1) {
                disbandList.add(entry.getKey());
                teamMap.remove(entry.getKey());
            } else {
                finishMap.put(entry.getKey(), currentList);
            }

        }

        for (Map.Entry<String, List<String>> entry : finishMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.printf("- %s%n", entry.getValue().get(0));
            for (int i = 1; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s%n", entry.getValue().get(i));
            }
        }

        System.out.println("Teams to disband:");
        Collections.sort(disbandList);
        if (!disbandList.isEmpty()) {
            System.out.println(disbandList.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ""));
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

    //метод за проверка дължините на списъците
    public static boolean isBigger(Map<String, List<String>> map, int length) {
        boolean isBigger = false;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (length > entry.getValue().size()) {
                isBigger = true;
            }
        }
        return isBigger;
    }
}
