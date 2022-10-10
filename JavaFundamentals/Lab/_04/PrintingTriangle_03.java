package Lab._04;

import java.util.Scanner;

public class PrintingTriangle_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTriangle(n);
        printbackLine(n);
    }

    public static void printTriangle(int number) { // метод за принтиране на триъгълника до най-дългия ред
        for (int i = 1; i <= number; i++) { // цикъл за принтиране на броя редове вкарани от конзолата
            printLine(1, i);
        }
    }

    public static void printLine(int start, int end) { // метод за принтиране на текущия ред, като двата параметъра се дават в printTriangle метода
        for (int i = start; i <= end; i++) { // принтира на реда брой цифри според зададените параметри от printTriangle метода
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void printbackLine(int end){ // метод за принтиране огледалния резултат на printTriagle метода, като се стартира с една цифра по-къс реда
        for (int i = end-1; i >= 1 ; i--) {
            printLine(1, i);
        }
    }
}
