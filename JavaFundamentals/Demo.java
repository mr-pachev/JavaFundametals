import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());

        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        int x11 = Integer.parseInt(scanner.nextLine());
        int y11 = Integer.parseInt(scanner.nextLine());

        int x21 = Integer.parseInt(scanner.nextLine());
        int y21 = Integer.parseInt(scanner.nextLine());

        int line1 = 0;
        int line2 = 0;

        if (x1 >= 0 && x2 >= 0){
            line1 = Math.abs(x1 + x2);
        }else if (x1 < 0 && x2 < 0){
            line1 = Math.abs(x1 - x2);
        }else if (x1 < 0 && x2 > 0){
            line1 = Math.abs(x1) + Math.abs(x2);
        }else if (x1 > 0 && x2 < 0){
            line1 = Math.abs(x1) + Math.abs(x2);
        }

        if (x11 >= 0 && x21 >= 0){
            line2 = Math.abs(x1 + x2);
        }else if (x1 < 0 && x21 < 0){
            line2 = Math.abs(x11 - x21);
        }else if (x11 < 0 && x21 > 0){
            line2 = Math.abs(x11) + Math.abs(x21);
        }else if (x11 > 0 && x21 < 0){
            line2 = Math.abs(x11) + Math.abs(x21);
        }

        int[] pointsArr = { Math.abs(x1),  Math.abs(x2),  Math.abs(x11),  Math.abs(x21)};


        System.out.println();
    }
}
