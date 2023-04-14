import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> teamMap = new LinkedHashMap<>();

        for (int currentTeam = 1; currentTeam <= n; currentTeam++) {
            String[] input = scanner.nextLine().split("-");
            String creator = input[0];
            String team = input[1];

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

        while (!input.equals("end of assignment")) {
            String[] inputData = scanner.nextLine().split("->");

            String user = inputData[0];
            String teamName = inputData[1];

            if (!teamMap.containsKey(teamName)){
                System.out.printf("Team %s does not exist!%n", teamName);
            }else if (isExist(teamMap, user)){
                System.out.printf("Member %s cannot join team %s!%n", user, teamName);
            }else {
                List<String> teamList = teamMap.get(teamName);
                teamList.add(user);
                teamMap.put(teamName, teamList);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : teamMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
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
