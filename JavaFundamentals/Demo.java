import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        int line1 = lineLength(x1, x2);
        int line2 = lineLength(x11, x21);

        List<Integer> pointsList = new ArrayList<>(4);

        if (line1 >= line2) {
            pointsList.add(x1);
            pointsList.add(y1);
            pointsList.add(x2);
            pointsList.add(y2);
        } else {
            pointsList.add(x11);
            pointsList.add(y11);
            pointsList.add(x21);
            pointsList.add(y21);
        }

        System.out.println();
    }
    private  static Integer lineLength(int a, int b){
        int line = 0;

        if (a >= 0 && b >= 0) {
            line = Math.abs(a - b);
        } else if (a <= 0 && b < 0) {
            line = Math.abs(a - b);
        }else if (a < 0 && b <= 0) {
            line = Math.abs(a - b);
        } else if (a <= 0 && b > 0) {
            line = Math.abs(a) + Math.abs(b);
        }else if (a < 0 && b >= 0) {
            line = Math.abs(a) + Math.abs(b);
        } else if (a >= 0 && b < 0) {
            line = Math.abs(a) + Math.abs(b);
        }else if (a > 0 && b <= 0) {
            line = Math.abs(a) + Math.abs(b);
        }
        return line;
    }
}
