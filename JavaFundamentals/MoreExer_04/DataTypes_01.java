package MoreExer_04;

        import java.util.Scanner;

public class DataTypes_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input){
            case "int":
                int number = Integer.parseInt(scanner.nextLine());
                System.out.print(number * 2);
                break;
            case "real":
                double num = Double.parseDouble(scanner.nextLine());
                System.out.printf("%.2f", num * 1.5);
                break;
            case "string":
                String text = scanner.nextLine();
                System.out.printf("$%s$",text);
                break;
        }

    }
}
