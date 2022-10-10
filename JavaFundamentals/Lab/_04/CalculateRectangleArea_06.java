package Lab._04;

import java.util.Scanner;

public class CalculateRectangleArea_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.next());
        double lenght = Double.parseDouble(scanner.next());

        System.out.printf("%.0f", getRectangleArea(width, lenght));
    }
    public static double getRectangleArea (double a, double b){
        double area = a * b;
        return  area;
    }
}
