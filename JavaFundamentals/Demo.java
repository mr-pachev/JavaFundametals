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

        if (x1 >= 0 && x2 >= 0) {
            line1 = Math.abs(x1 + x2);
        } else if (x1 < 0 && x2 < 0) {
            line1 = Math.abs(x1 - x2);
        } else if (x1 < 0 && x2 > 0) {
            line1 = Math.abs(x1) + Math.abs(x2);
        } else if (x1 > 0 && x2 < 0) {
            line1 = Math.abs(x1) + Math.abs(x2);
        }

        if (x11 >= 0 && x21 >= 0) {
            line2 = Math.abs(x1 + x2);
        } else if (x1 < 0 && x21 < 0) {
            line2 = Math.abs(x11 - x21);
        } else if (x11 < 0 && x21 > 0) {
            line2 = Math.abs(x11) + Math.abs(x21);
        } else if (x11 > 0 && x21 < 0) {
            line2 = Math.abs(x11) + Math.abs(x21);
        }

        if (line1 >= line2) {
            int[] pointsArr = {Math.abs(x1), y1, Math.abs(x2), y2, Math.abs(x11), y11, Math.abs(x21), y21};
            int[] realArr = {x1, y1, x2, y2, x11, y11, x21, y21};
            int min = Integer.MAX_VALUE;
            int index = 0;

            for (int i = 0; i < pointsArr.length / 2; i+=2) {

                if (pointsArr[i] <= min) {
                    min = pointsArr[i];
                    index = i;
                }
            }

            for (int i = 0; i < realArr.length / 2; i++) {
                if (i == index) {
                    System.out.printf("(%d, %d)", realArr[i], realArr[i + 1]);
                    i++;
                }
            }
            for (int i = 0; i < realArr.length / 2; i++) {
                if (i != index) {
                    System.out.printf("(%d, %d)", realArr[i], realArr[i + 1]);
                    i++;
                }
            }


        } else {
            int[] pointsArr = {Math.abs(x1), y1, Math.abs(x2), y2, Math.abs(x11), y11, Math.abs(x21), y21};
            int[] realArr = {x1, y1, x2, y2, x11, y11, x21, y21};
            int min = Integer.MAX_VALUE;
            int index = 0;

            for (int i = 4; i < pointsArr.length; i+=2) {

                if (pointsArr[i] <= min) {
                    min = pointsArr[i];
                    index = i;
                }
            }

            for (int i = 4; i < realArr.length; i++) {
                if (i == index) {
                    System.out.printf("(%d, %d)", realArr[i], realArr[i + 1]);
                    i++;
                }
            }
            for (int i = 4; i < realArr.length; i++) {
                if (i != index) {
                    System.out.printf("(%d, %d)", realArr[i], realArr[i + 1]);
                    i++;
                }
            }
        }

    }
}
