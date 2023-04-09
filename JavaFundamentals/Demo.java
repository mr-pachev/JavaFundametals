import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];

            List<String> piecesList = new ArrayList<>();
            piecesList.add(composer);
            piecesList.add(key);

            piecesMap.put(piece, piecesList);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String command = input.split("\\|")[0];
            String piece = input.split("\\|")[1];

            switch (command) {
                case "Add":
                    String composer = input.split("\\|")[2];
                    String key = input.split("\\|")[3];

                    if (piecesMap.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        List<String> pieceList = new ArrayList<>();
                        pieceList.add(composer);
                        pieceList.add(key);

                        piecesMap.put(piece, pieceList);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (piecesMap.containsKey(piece)) {
                        piecesMap.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = input.split("\\|")[2];

                    if (piecesMap.containsKey(piece)) {
                        List<String> piecesList = piecesMap.get(piece);
                        piecesList.set(1, newKey);
                        piecesMap.put(piece, piecesList);
                        System.out.printf("Changed the key of %s to {new key}!%n", newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            
            input = scanner.nextLine();
        }

    }
}
