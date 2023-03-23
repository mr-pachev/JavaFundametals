import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureList = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\|")).toList());

        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] commandData = input.split("\\s+");
            String command = commandData[0];

            switch (command) {
                case "Loot":
                    List<String> lootList = lootList(commandData);
                    for (int i = 0; i < lootList.size(); i++) {
                        if (!treasureList.contains(lootList.get(i))) {
                            treasureList.add(0, lootList.get(i));
                        }
                    }
                    break;
                case "Drop":
                    int indexDrop = Integer.parseInt(commandData[1]);

                    if (indexDrop >= 0 && indexDrop < treasureList.size()) {
                        String current = treasureList.get(indexDrop);
                        treasureList.remove(indexDrop);
                        treasureList.add(current);
                    }
                    break;
                case "Steal":
                    List<String> stealList = new ArrayList<>();
                    int stealSum = Integer.parseInt(commandData[1]);

                    if (treasureList.size() <= stealSum) {
                        System.out.println(treasureList.toString().replaceAll("[\\[\\]]", ""));
                        treasureList.clear();
                    } else {
                        for (int i = 1; i <= stealSum; i++) {
                            stealList.add(0, treasureList.get(treasureList.size() - 1));
                            treasureList.remove(treasureList.size() - 1);
                        }
                        System.out.println(stealList.toString().replaceAll("[\\[\\]]", ""));
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        if (treasureList.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        }else {
            System.out.printf("Average treasure gain: %.2f pirate credits.",  avr(treasureList));
        }
    }

    public static List<String> lootList(String[] arr) {
        List<String> current = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            current.add(arr[i]);
        }
        return current;
    }
    public static Double avr (List<String> list){
        int counterSum = 0;

        for (int i = 0; i < list.size(); i++) {
            counterSum += list.get(i).length();
        }
        return  counterSum * 1.0 / list.size();
    }
}
