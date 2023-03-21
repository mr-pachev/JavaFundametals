import java.util.ArrayList;
import java.util.Arrays;
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
        int x12 = Integer.parseInt(scanner.nextLine());
        int y12 = Integer.parseInt(scanner.nextLine());

        printSmallerLine(x1, y1, x2, y2, x11, y11, x12, y12);
    }

    //метод определящ дължина на права
    public static Double length (int x1, int y1, int x2, int y2){
        return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
    }
    //метод за намиране на най-близкото число до нула от подаден масив
    public static Double findClosestNumber(double x, double y) {
       return Math.sqrt(Math.pow((0 - x), 2) + Math.pow((0 - y), 2));
    }


    //метод принтиране първо на нан-близката точка от права
    public static void printCloserPoints(int x1, int y1, int x2, int y2){
        if (findClosestNumber(x1, y1) <= findClosestNumber(x2, y2)){
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        }else {
            System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        }
    }

    public static void printSmallerLine (int x1, int y1, int x2, int y2, int x11, int y11, int x12, int y12){
        if(length(x1, y1, x2, y2) >= length(x11, y11, x12, y12)){
            printCloserPoints(x1, y1, x2, y2);
        }else {
            printCloserPoints(x11, y11, x12, y12);
        }
    }
}
