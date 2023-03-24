import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double plunder = 0;

        for (int day = 1; day <= days; day++) {
            plunder += dailyPlunder;

            if (day % 3 == 0) {
                double bonusPlunder = 0;
                bonusPlunder = 50 * 1.0 / 100 * dailyPlunder;
                plunder += bonusPlunder;
            }
            if (day % 5 == 0) {
                double losePlinder = 0;
                losePlinder = 30 * 1.0 / 100 * plunder;
                plunder -= losePlinder;
            }
        }

        if (plunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", plunder);
        } else {
            double percent = 0;
            percent = plunder * 100 / expectedPlunder;
            System.out.printf("Collected only %.2f%% of the plunder.", percent);
        }
    }
}
