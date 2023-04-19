import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureList = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")){
            String command = input.split(" ")[0];

            if (command.equals("Loot")){
                List<String> lootList = Arrays.stream(input.split(" ")).collect(Collectors.toList());

                for (int i = 1; i < lootList.size(); i++) {
                    if (!treasureList.contains(lootList.get(i))){
                        treasureList.add(0, lootList.get(i));
                    }
                }

            }else if (command.equals("Drop")){
                int removeIndex = Integer.parseInt(input.split(" ")[1]);

                if (isValid(treasureList, removeIndex)){
                    String element = treasureList.get(removeIndex);
                    treasureList.remove(removeIndex);
                    treasureList.add(element);
                }
            }else if (command.equals("Steal")){

            }



            input = scanner.nextLine();
        }

    }
    public static boolean isValid (List<String> list, int index){
        return (index >= 0 && index < list.size());
    }
}
