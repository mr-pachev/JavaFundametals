import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int allDay = Integer.parseInt(scanner.nextLine());          //дни за плячкосване
        int targetPlunder = Integer.parseInt(scanner.nextLine());   //плячкосване на ден
        int expectedPlunder = Integer.parseInt(scanner.nextLine()); //очаквано плячкосване

        double bonus = 0;
        double loss = 0;
        int sumPlunder = 0;

        for (int day = 1; day <= allDay; day++) {
            sumPlunder += targetPlunder;

            if (day % 3 == 0) {
                bonus = 50 * 1.0 / 100 * targetPlunder;
                sumPlunder += bonus;
            }

            if (day % 5 == 0) {
                loss = 30 * 1.0 / 100 * sumPlunder;
                sumPlunder -= loss;
            }
        }

        if (sumPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %s plunder gained.", sumPlunder);
        } else {
            double percentPlunder = (sumPlunder * 1.0 / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percentPlunder);
        }

    }
}
