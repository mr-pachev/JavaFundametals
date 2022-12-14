package MoreExerTeamworkProjects_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой отбори, които трябва да се ригистрират

        List<Team> teamList = new ArrayList<>(); //списък с обектите от клас екип
        List<String> userTeamList = new ArrayList<>();
        boolean isTrue = true;

        for (int currentTeam = 1; currentTeam <= n; currentTeam++) {
            String input = scanner.nextLine();

            isTrue = true;
            String creator = input.split("-")[0]; //създател на екипа
            String teamName = input.split("-")[1]; //създадения екип

            if(teamList.isEmpty()){ //първоначално запълване на листа с екипите
                userTeamList = new ArrayList<>();
                userTeamList.add(creator);
                Team team = new Team(teamName, creator, userTeamList);
                teamList.add(team);
                System.out.printf("Team %s has been created by %s!%n", teamName, creator); //при вече създаден екип
                continue;
            }

            for (Team team : teamList){
               if (team.getName().equals(teamName)){ //проверка дали екипа вече е създаден
                   System.out.printf("Team %s was already created!%n", teamName); //при вече създаден екип
                   isTrue = false;
                   break;
                }else if (team.getCreator().equals(creator)){ //проверка дали създателя вече не е създавал екип
                   System.out.printf("%s cannot create another team!", creator); //при вече създаден друг екип
                   isTrue = false;
                   break;
               }
            }
            if (isTrue){ //проверка дали горните условия не са изпълнени
                userTeamList = new ArrayList<>();
                userTeamList.add(creator);
                Team team = new Team(teamName, creator, userTeamList);
                teamList.add(team);
                System.out.printf("Team %s has been created by %s!%n", teamName, creator); //при създаване на екип
            }else {
                continue;
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end of assignment")) {
            isTrue = true;
            String user = command.split("->")[0]; //потребител, който иска да се присъедини към екипа
            String wishTeamName = command.split("->")[1]; //желан екип за присъединяване

            for (Team team : teamList){
                if (team.getName().equals(wishTeamName)) { //проверка дали желания екип съществува
                    isTrue = false;
                    team.getUserList().add(user);
                    break;
                }
            }
            if (isTrue){
                System.out.printf("Team %s does not exist!%n", wishTeamName); //при несъщестуващ екип
            }

            for (Team team : teamList){
                if (team.getUserList().contains(user)){ //проверка дали потребителя вече не съществува в някой екип
                    System.out.printf("Member %s cannot join team %s!%n", user, wishTeamName); //при вече съществуващ потребител в някой екип
                    break;
                }
            }

            command = scanner.nextLine();
        }
        System.out.printf("");
    }
}
