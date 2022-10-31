package MoreExer_04;

import java.util.Scanner;

public class MultiplicationSign_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numFirst = Integer.parseInt(scanner.nextLine());
        int numSecond = Integer.parseInt(scanner.nextLine());
        int numThird = Integer.parseInt(scanner.nextLine());

        if ((numFirst == 0) || (numSecond == 0) || (numThird == 0)){
            System.out.println("zero");
        }else if ((numFirst < 0) && (numSecond > 0) && (numThird > 0)){
            System.out.println("negative");
        }else if ((numFirst > 0) && (numSecond < 0) && (numThird > 0)){
            System.out.println("negative");
        }else if ((numFirst > 0) && (numSecond > 0) && (numThird < 0)){
            System.out.println("negative");
        }else if ((numFirst < 0) && (numSecond < 0) && (numThird < 0)){
            System.out.println("negative");
        }else if ((numFirst < 0) && (numSecond < 0) && (numThird > 0)){
            System.out.println("positive");
        }else if ((numFirst < 0) && (numSecond > 0) && (numThird < 0)){
            System.out.println("positive");
        }else if ((numFirst > 0) && (numSecond < 0) && (numThird < 0)){
            System.out.println("positive");
        }else if ((numFirst > 0) && (numSecond > 0) && (numThird > 0)){
            System.out.println("positive");
        }


    }

}
