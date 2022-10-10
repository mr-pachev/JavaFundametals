package Lab._06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs_04 {

    static class Song { // клас Song
        String typeList; // поле-параметър на класа
        String name; // поле-параметър на класа
        String time; // поле-параметър на класа

        public void setTypeList(String typeList) { // метод за промяна на полето typeList с зададен стринг от вън
            this.typeList = typeList;
        }

        public String getTypeList() { // метод за достъп до вече промененото поле от класа Song
            return this.typeList;
        }

        public void setName(String name) { // метод за промяна на полето name с зададен стринг от вън
            this.name = name;
        }

        public String getName() { // метод за достъп до вече промененото поле от класа Song
            return this.name;
        }

        public void setTime(String time) { // метод за промяна на полето time с зададен стринг от вън
            this.time = time;
        }

        public String getTime() {
            return this.time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songsList = new ArrayList<>(); // списък, който ще съдържа песните въведени от конзолата

        for (int i = 1; i <= n; i++) {
            String[] inputSong = scanner.nextLine().split("_"); // създаване на масив с разделител долна черта за всяка текуща песен

            String currentTypeList = inputSong[0];
            String currentName = inputSong[1];
            String currentTime = inputSong[2];

            Song currentSong = new Song(); // създаваме обект от класа Song, чийто полета трябва да запълним
            currentSong.setTypeList(currentTypeList);
            currentSong.setName(currentName);
            currentSong.setTime(currentTime);

            songsList.add(currentSong); // прибавяне на обекта currentSong от класа Song към списъка songList
        }
        String command = scanner.nextLine();

        if (command.equals("all")) {
            for (Song item : songsList) { // тип данне(Song) с име item от списък songList
                System.out.println(item.getName()); // от обекта item на класа Song, който се съдържа в списъка songList ще принтира само getName
            }
        } else {
            for (Song item : songsList) {
                if (command.equals(item.getTypeList())) { // проверка дали командата отговаря на полето typeList от обекта items на класа Song в списъка songList
                    System.out.println(item.getName()); // от обекта item на класа Song, който се съдържа в списъка songList ще принтира само getName
                }
            }
        }
    }
}
