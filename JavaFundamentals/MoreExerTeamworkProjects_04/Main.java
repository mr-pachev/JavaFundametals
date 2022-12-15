package MoreExerTeamworkProjects_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой отбори, които трябва да се ригистрират

        List<Team> teamList = new ArrayList<>(); //списък с обектите от клас екип
        boolean isExistsTeam = false;

        for (int currentTeam = 1; currentTeam <= n; currentTeam++) {
            String input = scanner.nextLine(); //екип и неговият създател

            isExistsTeam = false;
            String creator = input.split("-")[0]; //създател на екипа
            String teamName = input.split("-")[1]; //създадения екип

            if (teamList.isEmpty()) { //първоначално запълване на листа с екипите
                List<String> userTeamList = new ArrayList<>(); //лист с хората в дадения екип
                userTeamList.add(creator); //добавяне на създателя към дадения екип
                Team team = new Team(teamName, creator, userTeamList); //създаване на обект екип
                teamList.add(team); //добавяне на обекта към листа с обекти
                System.out.printf("Team %s has been created by %s!%n", teamName, creator); //при вече създаден екип
                continue;
            }

            for (Team team : teamList) {
                if (team.getName().equals(teamName)) { //проверка дали екипа вече е създаден
                    System.out.printf("Team %s was already created!%n", teamName); //при вече създаден екип
                    isExistsTeam = true;
                    break;
                } else if (team.getCreator().equals(creator)) { //проверка дали създателя вече не е създавал екип
                    System.out.printf("%s cannot create another team!", creator); //при вече създаден друг екип
                    isExistsTeam = true;
                    break;
                }
            }
            if (!isExistsTeam) { //проверка дали горните условия не са изпълнени
                List<String> userTeamList = new ArrayList<>();
                userTeamList.add(creator); //добавяне на създателя към дадения екип
                Team team = new Team(teamName, creator, userTeamList);
                teamList.add(team);
                System.out.printf("Team %s has been created by %s!%n", teamName, creator); //при създаване на екип
            } else {
                continue;
            }
        }

        String command = scanner.nextLine(); //добавяне на потребител и желан екип за присъединяване
        boolean isBreak = false;

        while (!command.equals("end of assignment")) {
            String user = command.split("->")[0]; //потребител, който иска да се присъедини към екипа
            String wishTeamName = command.split("->")[1]; //желан екип за присъединяване

            int counter = 0;
            for (Team team : teamList) {
                counter++;
                if (team.getName().equals(wishTeamName)) { //проверка дали желания екип съществува
                    isExistsTeam = true;
                    continue;
                }
                if (counter == teamList.size()) {
                    if (!isExistsTeam) {
                        System.out.printf("Team %s does not exist!%n", wishTeamName); //при несъщестуващ екип
                        isBreak = true;
                    }
                }
            }
            if (isBreak) {
                command = scanner.nextLine();
                isExistsTeam = false;
                isBreak = false;
                continue;
            }

            for (Team team : teamList) {
                if (team.getUserList().contains(user)) { //проверка дали потребителя вече съществува в някой екип
                    System.out.printf("Member %s cannot join team %s!%n", user, wishTeamName); //при вече съществуващ потребител в някой екип
                    isBreak = true;
                    break;
                }
            }

            if (!isBreak) {
                for (Team team : teamList) {
                    if (team.getName().equals(wishTeamName)) { //добавяне на потребител към желаната група
                        team.setUserList(user);
                        isExistsTeam = false;
                    }
                }
            }

            command = scanner.nextLine();
        }
        List<String> disbandList = new ArrayList<>(); //създаванен на лист с разпуснати екипи
        List<Team> finalTeamList = new ArrayList<>(); //създаване но лист с обекти отговарящи на заданието

        for (Team team : teamList) {
            if (team.getUserList().size() == 1) {
                disbandList.add(team.getName()); //пълнене на листа с разпуснатите екипи
            } else {
                team = new Team(team.getName(), team.getCreator(), team.getUserList());
                finalTeamList.add(team); //пълнене на листо с обекти с коректните екипи
            }
        }

        Collections.sort(disbandList); //сортира листа по възходящ ред

        List<Team> teamListSortedByCountMembers = new ArrayList<>();
        int maxNumMembers = 0;
        int currentNumMembers = 0;
        for (Team team : finalTeamList){ //сортиране на листа с обектите отговалящи на изискванията по броя членове в низходящ ред
            currentNumMembers = team.getUserList().size();
            if (currentNumMembers >= maxNumMembers){ //проверка дали текущия лист с членове е най-големия до момента
                maxNumMembers = currentNumMembers;
                team = new Team(team.getName(), team.getCreator(), team.getUserList());
                teamListSortedByCountMembers.add(0, team);
            }
        }

        List<Team> teamListSortedByName = new ArrayList<>();
        for (Team team : teamListSortedByCountMembers){ //сортиране на листа с обекти отговарящи на изискванията по име на екипите по възходящ ред
            currentNumMembers = team.getName().toCharArray()[0];
            if (currentNumMembers >= maxNumMembers){
                maxNumMembers = currentNumMembers;
                team = new Team(team.getName(), team.getCreator(), team.getUserList());
                teamListSortedByName.add(team);
            }
        }

        for (Team team : teamListSortedByName) {
            System.out.println(team.toString()); //печатане на името на екипа
            int counter = 0;
            for (String user : team.getUserList()) {
                if (counter == 0) {
                    System.out.printf("- %s%n", user); //печатане на създателя на екипа
                } else {
                    System.out.printf("-- %s%n", user); //печатане на другите участници в екипа
                }
                counter++;
            }
        }
        System.out.print("Teams to disband:");

        if (!disbandList.isEmpty()) { //проверка дали има разпуснати екипи да отпечатване
            System.out.println();
            for (String teamName : disbandList) {
                System.out.println(teamName);
            }
        }

    }
}
