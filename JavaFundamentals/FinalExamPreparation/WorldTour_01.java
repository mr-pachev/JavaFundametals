package FinalExamPreparation;

import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        StringBuilder stopsBuilder = new StringBuilder(stops);

        String command = scanner.nextLine();

        while (!command.equals("Travel")){

            if (command.contains("Add Stop")){
                int index = Integer.parseInt(command.split(":")[1]);
                String newStop = command.split(":")[2];
                if(isValidIndex(index, stopsBuilder)) {
                    stopsBuilder.insert(index, newStop);
                }
            }else if(command.contains("Remove Stop")){
                int startIndex = Integer.parseInt(command.split(":")[1]);
                int endIndex = Integer.parseInt(command.split(":")[2]);
                if(isValidIndex(startIndex, stopsBuilder) && isValidIndex(endIndex, stopsBuilder)){
                    stopsBuilder.delete(startIndex, endIndex + 1);
                }
            }else if(command.contains("Switch")){
                String oldStop = command.split(":")[1];
                String newStop = command.split(":")[2];
                if(stopsBuilder.toString().contains(oldStop)){
                   String newBuilder = stopsBuilder.toString().replace(oldStop, newStop);
                   stopsBuilder = new StringBuilder(newBuilder);
                }
            }

            System.out.println(stopsBuilder);
            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stopsBuilder.toString());

    }
    public static boolean isValidIndex (Integer index, StringBuilder builder){
       return index >= 0 && index <= builder.length() - 1;
    }
}
