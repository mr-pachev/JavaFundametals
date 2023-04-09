import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map <String, List<String>> piecesMap = new LinkedHashMap<>();

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

        

    }
}
