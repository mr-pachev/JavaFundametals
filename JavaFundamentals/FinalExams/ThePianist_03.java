package FinalExams;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> resultMap = new LinkedHashMap<>(); //речник с резултатите

        for (int i = 1; i <= n; i++) {                        //пълнене на речника
            String input = scanner.nextLine();                //вход на произведението|композитора|гамата

            String piece = input.split("\\|")[0];       //пройзведение
            String composer = input.split("\\|")[1];    //композитор
            String gamma = input.split("\\|")[2];       //гама

            List<String> dataList = resultMap.get(piece);

            if (dataList == null) {
                dataList = new ArrayList<>();
            }

            dataList.add(composer);
            dataList.add(gamma);
            resultMap.put(piece, dataList);

        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {

            String command = input.split("\\|")[0];   //команда

            switch (command) {
                case "Add": {
                    String piecesAdd = input.split("\\|")[1];
                    String composerAdd = input.split("\\|")[2];
                    String gammaAdd = input.split("\\|")[3];

                    List<String> dataList = resultMap.get(piecesAdd);

                    if (!resultMap.containsKey(piecesAdd)) {

                        dataList = new ArrayList<>();

                        dataList.add(composerAdd);
                        dataList.add(gammaAdd);
                        resultMap.put(piecesAdd, dataList);

                        System.out.printf("%s by %s in %s added to the collection!%n", piecesAdd, composerAdd, gammaAdd);
                    } else {
                        System.out.printf("%s is already in the collection!%n", piecesAdd);
                    }

                    break;
                }
                case "Remove": {
                    String piecesRemoved = input.split("\\|")[1];

                    List<String> dataList = resultMap.get(piecesRemoved);

                    if (resultMap.containsKey(piecesRemoved)) {

                        resultMap.remove(piecesRemoved);

                        System.out.printf("Successfully removed %s!%n", piecesRemoved);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piecesRemoved);
                    }
                    break;
                }

                case "ChangeKey": {
                    String piecesChange = input.split("\\|")[1];
                    String gammaChange = input.split("\\|")[2];

                    List<String> dataList = resultMap.get(piecesChange);

                    if (resultMap.containsKey(piecesChange)) {
                        String oldGamma = resultMap.get(piecesChange).get(1);
                        String oldComposer = resultMap.get(piecesChange).get(0);

                        dataList = new ArrayList<>();
                        dataList.add(oldComposer);
                        dataList.add(gammaChange);
                        resultMap.put(piecesChange, dataList);

                        System.out.printf("Changed the key of %s to %s!%n", oldGamma, gammaChange);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", gammaChange);
                    }
                    break;
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : resultMap.entrySet()) {
            System.out.printf("%s -> Composer: ", entry.getKey());

            for (int i = 0; i < entry.getValue().size(); i++) {
                if (i == 0) {
                    System.out.printf("%s, Key: ", entry.getValue().get(0));
                } else if (i == 1) {
                    System.out.println(entry.getValue().get(1));
                }

            }
        }

    }
}
