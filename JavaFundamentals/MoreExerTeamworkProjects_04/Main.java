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
            }

            if (isExistCreator(teamList, creator)) {
                System.out.printf("%s cannot create another team!%n", creator); //вече създател на един екип
                continue;
            }

            if (isExistTeam(teamList, teamName)) {
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

            //добавяне на потребител към съществуващ екип
            teamList.stream().filter(team -> team.getName().equals(wishTeamName)).forEach(team -> team.setUserList(user));
            command = scanner.nextLine();
        }

        List<String> disbandList = new ArrayList<>(); //създаванен на лист с разпуснати екипи

        //добавяне на екип само с един член към лист disbandList
        teamList.stream().filter(team -> team.getUserList().size() == 1).forEach(team -> disbandList.add(team.getName()));
        Collections.sort(disbandList); //сортира листа по възходящ ред

        //сортиране на листа с обектите отговарящи на изискванията по броя членове в низходящ ред
        teamList = teamList.stream().sorted((s1, s2) -> Integer.compare(s2.getUserList().size(), s1.getUserList().size())).collect(Collectors.toList());

        //сортиране на листа с обекти отговарящи на изискванията по име на екипите по възходящ ред
        teamList = teamList.stream().sorted((s1, s2) -> String.CASE_INSENSITIVE_ORDER.compare(s1.getName(), s2.getName())).collect(Collectors.toList());




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

    //добавяне на патребител към даден екип
    public static boolean isExistUserinTeam(List<Team> teamList, String user) {
        for (Team team : teamList) {
            if (team.getUserList().contains(user)) { //проверка дали потребителя вече съществува в някой екип
                return true;
            }
        }
        return false;
    }

}
