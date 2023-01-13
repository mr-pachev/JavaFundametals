package MoreExerTeamworkProjects_04;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой отбори, които трябва да се ригистрират

        List<Team> teamList = new ArrayList<>(); //списък с обектите от клас екип

        for (int currentTeam = 1; currentTeam <= n; currentTeam++) {
            String input = scanner.nextLine(); //екип и неговият създател

            String creator = input.split("-")[0]; //създател на екипа
            String teamName = input.split("-")[1]; //създадения екип

            if (teamList.isEmpty()) { //първоначално запълване на листа с екипите
                List<String> userTeamList = new ArrayList<>(); //лист с хората в дадения екип
                userTeamList.add(creator); //добавяне на създателя към дадения екип
                Team team = new Team(teamName, creator, userTeamList); //създаване на обект екип
                teamList.add(team); //добавяне на обекта към листа с обекти
                System.out.printf("Team %s has been created by %s!%n", teamName, creator); //при вече създаден екип
                continue;
            }else if (isExistCreator(teamList, creator)) {
                System.out.printf("%s cannot create another team!%n", creator); //вече създател на един екип
                continue;
            }else if (isExistTeam(teamList, teamName)) {
                System.out.printf("Team %s was already created!%n", teamName); //при вече създаден екип
                continue;
            }

            List<String> userTeamList = new ArrayList<>();
            userTeamList.add(creator); //добавяне на създателя към дадения екип
            Team team = new Team(teamName, creator, userTeamList);
            teamList.add(team);
            System.out.printf("Team %s has been created by %s!%n", teamName, creator); //при създаване на екип
        }

        String command = scanner.nextLine(); //добавяне на потребител и желан екип за присъединяване
        boolean isBreak = false;

        while (!command.equals("end of assignment")) {

            String user = command.split("->")[0]; //потребител, който иска да се присъедини към екипа
            String wishTeamName = command.split("->")[1]; //желан екип за присъединяване
            int counter = 0;

            if (!isExistTeam(teamList, wishTeamName)) {
                System.out.printf("Team %s does not exist!%n", wishTeamName); //при несъщестуващ екип
                command = scanner.nextLine();
                continue;
            }

            if (isExistUserinTeam(teamList, user)) {
                System.out.printf("Member %s cannot join team %s!%n", user, wishTeamName); //при вече съществуващ потребител в някой екип
                command = scanner.nextLine();
                continue;
            }

            for (Team team : teamList) {
                if (team.getName().equals(wishTeamName)) { //добавяне на потребител към желаната група
                    team.setUserList(user);
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
        for (Team team : finalTeamList) { //сортиране на листа с обектите отговалящи на изискванията по броя членове в низходящ ред
            currentNumMembers = team.getUserList().size();
            if (currentNumMembers >= maxNumMembers) { //проверка дали текущия лист с членове е най-големия до момента
                maxNumMembers = currentNumMembers;
                team = new Team(team.getName(), team.getCreator(), team.getUserList());
                teamListSortedByCountMembers.add(0, team);
            }
        }

        List<Team> teamListSortedByName = new ArrayList<>();
        for (Team team : teamListSortedByCountMembers) { //сортиране на листа с обекти отговарящи на изискванията по име на екипите по възходящ ред
            currentNumMembers = team.getName().toCharArray()[0];
            if (currentNumMembers >= maxNumMembers) {
                maxNumMembers = currentNumMembers;
                team = new Team(team.getName(), team.getCreator(), team.getUserList());
                teamListSortedByName.add(team);
            }
        }

        for (Team team : teamListSortedByName) { //сортиране на членовете на всеки екип по име-възходящ ред
            Collections.sort(team.getUserList());
        }

        for (Team team : teamListSortedByName) {
            System.out.println(team.toString()); //печатане на името на екипа

            for (String user : team.getUserList()) {
                if (user.contains(team.getCreator())) {
                    continue;
                } else {
                    System.out.printf("-- %s%n", user); //печатане на другите участници в екипа
                }
            }
        }
        System.out.print("Teams to disband:");

        if (!disbandList.isEmpty()) { //проверка дали има разпуснати екипи за отпечатване
            System.out.println();
            for (String teamName : disbandList) {
                System.out.println(teamName);
            }
        }

    }

    //проверка дали потребителя иска да стане създател на още един екип
    public static boolean isExistCreator(List<Team> teamList, String creator) {
        for (Team team : teamList) {
            if (team.getCreator().equals(creator)) {
                return true;
            }
        }
        return false;
    }

    //проверка дали създателя вече не е създавал екип
    public static boolean isExistTeam(List<Team> teamList, String wishTeam) {
        for (Team team : teamList) {
            if (team.getName().equals(wishTeam)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExistUserinTeam(List<Team> teamList, String user) {
        for (Team team : teamList) {
            if (team.getUserList().contains(user)) { //проверка дали потребителя вече съществува в някой екип
                return true;
            }
        }
        return false;
    }

}
