import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int[] liftArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < liftArr.length; i++) {
            int currentCabin = liftArr[i];

            if (currentCabin < 4) {
                int freeSpace = 4 - currentCabin;
                if (freeSpace <= people) {
                    liftArr[i] += freeSpace;
                    people -= freeSpace;
                }else {
                    liftArr[i] = people;
                    people = 0;
                }

            }
        }

        if (people == 0 || isFull(liftArr)){
            if (people == 0 && !isFull(liftArr)){
                System.out.println("The lift has empty spots!");
                print(liftArr);
            }else if (people != 0 && isFull(liftArr)){
                System.out.printf("There isn't enough space! %d people in a queue!%n", people);
                print(liftArr);
            }
        }
    }
    public static boolean isFull (int[] arr){
        boolean isFull = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 4){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public static void print (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
