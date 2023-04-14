import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> teamMap = new LinkedHashMap<>();

        for (int curretnteam = 1; curretnteam <= n; curretnteam++) {
            String[] input = scanner.nextLine().split("-");
            String creator  = input[0];
            String team  = input[1];

            if (teamMap.containsKey(creator)){
                System.out.printf("Team %s was already created!", team);
            }else {
                List<String> teamList = new ArrayList<>();
                teamList.add(creator);
                teamMap.put(team, teamList);
            }

        }


    }
}
