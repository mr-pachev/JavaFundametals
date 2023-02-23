package FinalExams;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pieceCount = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> pieceDataMap = new LinkedHashMap<>(); //мап съхраняващ информацията за пиесите

        for (int piece = 1; piece <= pieceCount ; piece++) {
            List<String> piecesValueList = new ArrayList<>(); //нов лист, в който ще се съдържат името на композитора и коя тоналност е пиесата-всичко това се явява value на мапа
            String inputPieces = scanner.nextLine();
            String pieceName = inputPieces.split("\\|")[0];
            String composer = inputPieces.split("\\|")[1];
            String tone = inputPieces.split("\\|")[2];

            piecesValueList.add(composer); //запълване на листа
            piecesValueList.add(tone);
            pieceDataMap.put(pieceName, piecesValueList); //запълване на value на мапа
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")){

            if(command.contains("Add")){
                String pieceName = command.split("\\|")[1];
                String composer = command.split("\\|")[2];
                String tone = command.split("\\|")[3];
                List<String> newPieceList = new ArrayList<>(); //промените ще се извършат в новия лист
                newPieceList.add(composer);
                newPieceList.add(tone);

                if(isExist(pieceName, pieceDataMap)){
                    System.out.printf("%s is already in the collection!%n", pieceName);
                }else {
                    pieceDataMap.put(pieceName, newPieceList); //добавяне на новия лист с промените към съществуващия мап
                    System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, tone);
                }
            }else if(command.contains("Remove")){
                String pieceName = command.split("\\|")[1];

                if(isExist(pieceName, pieceDataMap)){
                    pieceDataMap.remove(pieceName);
                    System.out.printf("Successfully removed %s!%n", pieceName);
                }else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                }
            }else if(command.contains("ChangeKey")){
                String pieceName = command.split("\\|")[1];
                String tone = command.split("\\|")[2];
                List<String> newValueTone = pieceDataMap.get(pieceName); //създаване на нов лист, в който ще се извършат промените, взимаме стойността на value-което всъщност е списъка от мапа

                if(isExist(pieceName, pieceDataMap)){
                    newValueTone.remove(1); //премахване на елемент от списъка с индекс 1-tone
                    newValueTone.add(tone); //добавяне на новия елемент
                    pieceDataMap.put(pieceName, newValueTone); //добавяне на промените в мапа
                    System.out.printf("Changed the key of %s to %s!%n", pieceName, tone);
                }else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                }

            }

            command = scanner.nextLine();
        }
        pieceDataMap.entrySet().forEach(items -> System.out.printf("%s -> Composer: %s, Key: %s%n", items.getKey(), items.getValue().get(0), items.getValue().get(1)));
    }
    public static boolean isExist(String piece, Map<String, List<String>> pieceInfo){ //метод за проверка дали пиесата съществува в мапа
        return pieceInfo.containsKey(piece);
    }
}
