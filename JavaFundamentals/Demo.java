import java.util.*;
import java.util.spi.AbstractResourceBundleProvider;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> teamMap = new LinkedHashMap<>();            //речник със създател и екип
        List<String> membersList = new ArrayList<>();                   //списък с потребители на дадения курс
        Map<String, List<String>> teamsUsers = new TreeMap<>();   //речник с екип и участниците й

        for (int i = 1; i <= n; i++) {                                  //запълване на речника със създател и екип
            String[] inputData = scanner.nextLine().split("-");

            String creator = inputData[0];                              //създател на екипа
            String team = inputData[1];                                 //име на създадения екип

            if (teamMap.containsValue(team)) {                          //проверка дали екипа съществува вече
                System.out.printf("Team %s was already created!%n", team);
                continue;
            }

            if (teamMap.containsKey(creator)) {                         //проверка дали потребителя/създателя вече е създал екип
                System.out.printf("%s cannot create another team!", creator);
                continue;
            }
            teamMap.put(creator, team);
            System.out.printf("Team %s has been created by %s!%n", team, creator);
            membersList = new ArrayList<>();
            membersList.add(creator);
            teamsUsers.put(team, membersList);
        }

        String input = scanner.nextLine();

        while (!input.equals("end of assignment")) {
            String[] inputData = input.split("->");

            String user = inputData[0];                             //потребител искащ присъединяване
            String currentTeam = inputData[1];                      //текущ екип

            membersList = new ArrayList<>();

            if (!teamsUsers.containsKey(currentTeam)) {             //проверка дали екипа, към който потребителя иска да се присъедини съществува
                System.out.printf("Team %s does not exist!%n", currentTeam);

                input = scanner.nextLine();
                continue;
            }

            boolean isExist = false;

            for (Map.Entry<String, List<String>> entry : teamsUsers.entrySet()) { //проверка дали конкретния потребител съществував в някой от курсовете
                if (entry.getValue().contains(user)) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {                                                        //добавяне на дадения потребител към дадения екип
                for (Map.Entry<String, List<String>> entry : teamsUsers.entrySet()) {
                    if (entry.getKey().contains(currentTeam)) {
                        membersList = entry.getValue();                              //листа с потребителите на конкретния екип
                        membersList.add(user);                          //добавяне на конкретния потребител към вече съществуващ списък на даден екип
                        teamsUsers.put(currentTeam, membersList);                    //добавяне на новия потребител към конкретния екип
                        break;
                    }
                }
            } else {
                System.out.printf("Member %s cannot join team %s!%n", user, currentTeam);
            }
            input = scanner.nextLine();
        }


       for (String s : teamsUsers.keySet()){        //сортиране на стойността на речника по възходящ ред
           Collections.sort(teamsUsers.get(s));
       }

        teamsUsers = teamsUsers.entrySet().stream()   //сортиране на ключа на речника по низходящ ред
                        .sorted(Map.Entry.<String, List<String>>comparingByKey().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        System.out.println();



        for (Map.Entry<String, List<String>> entry : teamsUsers.entrySet()) {
            if (entry.getValue().size() > 1) {                          //условие да се принтира екип с повече от един потребител
                System.out.printf("%s%n", entry.getKey());              //принтиране на името на екипа по реда на възходящ ред
            }

            for (String member : entry.getValue()){
                if (teamMap.containsKey(member) && entry.getValue().size() > 1){    //проверка дали потребителя от списъка е създател и дали списъка има повече от един член
                    System.out.printf("- %s%n", member);
                }else if (entry.getValue().size() > 1){                 //условие да се принтира екип с повече от един потребител
                    System.out.printf("-- %s%n", member);
                }
            }
        }

        System.out.println("Teams to disband:");
        for (Map.Entry<String, List<String>> entry : teamsUsers.entrySet()) {

            if (entry.getValue().size() == 1){
                System.out.printf("%s%n", entry.getKey());
            }
        }
    }
}
