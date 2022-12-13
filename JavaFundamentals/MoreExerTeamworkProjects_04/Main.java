package MoreExerTeamworkProjects_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой отбори, които трябва да се ригистрират
        String input = "";
        List<Team> teamList = new ArrayList<>();

        for (int currentTeam = 1; currentTeam <= n; currentTeam++) {
            input = scanner.nextLine();
            List<String> teamUserList = new ArrayList<>();

            String creator = input.split("-")[0]; //създател на екипа
            String teamName = input.split("-")[1]; //създадения екип

            Team team = new Team(creator, teamUserList); //създаване на обект
            teamList.add(team); //пълнене на лист с обекти

            System.out.printf("Team %s has been created by %s!%n", teamName, creator);
        }

        String command = scanner.nextLine();

        while (!command.equals("end of assignment")){
            String inputData = scanner.nextLine();

            String user = command.split("->")[0]; //потребител, който иска да се присъедини към екипа




            command = scanner.nextLine();
        }
    }
}
