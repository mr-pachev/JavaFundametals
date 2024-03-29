package FinalExams;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> resultMap = new LinkedHashMap<>();    //речник с резултатите

        for (int i = 1; i <= n; i++) {                                  //пълнене на речника
            String input = scanner.nextLine();                          //вход -> произведението|композитора|гамата
            String[] piecesParts = input.split("\\|");
            List<String> dataList = new ArrayList<>();

            String piece = piecesParts[0];       //пройзведение
            String composer = piecesParts[1];    //композитор
            String gamma = piecesParts[2];       //гама

            dataList.add(composer);
            dataList.add(gamma);
            resultMap.put(piece, dataList);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {

            String command = input.split("\\|")[0];   //команда

            switch (input.split("\\|")[0]) {
                case "Add": {
                    String piecesAdd = input.split("\\|")[1];
                    String composerAdd = input.split("\\|")[2];
                    String gammaAdd = input.split("\\|")[3];
                    List<String> addList = new ArrayList<>();
                    addList.add(composerAdd);
                    addList.add(gammaAdd);

                    if (isExist(resultMap, piecesAdd)) {
                        System.out.printf("%s is already in the collection!%n", piecesAdd);
                    } else {
                        resultMap.put(piecesAdd, addList);
                        System.out.printf("%s by %s in %s added to the collection!%n", piecesAdd, composerAdd, gammaAdd);
                    }
                    break;
                }
                case "Remove": {
                    String piecesRemoved = input.split("\\|")[1];

                    if (isExist(resultMap, piecesRemoved)) {

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

                    if (isExist(resultMap, piecesChange)) {
                        dataList.remove(1);
                        dataList.add(gammaChange);
                        resultMap.put(piecesChange, dataList);

                        System.out.printf("Changed the key of %s to %s!%n", piecesChange, gammaChange);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piecesChange);
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

    public static boolean isExist(Map<String, List<String>> mapCheck, String key) {
        return mapCheck.containsKey(key);
    }
}
