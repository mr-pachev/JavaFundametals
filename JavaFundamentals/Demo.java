import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        int indexSmall = index(pointsList);
        int indexAnother = anotherPoint(pointsList, indexSmall);
        System.out.printf("(%d, %d)(%d, %d)", pointsList.get(indexSmall), pointsList.get(indexSmall+1), pointsList.get(indexAnother), pointsList.get(indexAnother+1));
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
    public static Integer index(List<Integer> list){
        int min = Integer.MAX_VALUE;
        int current = 0;
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);

            if(current <= min){
                min = current;
                index = i;
            }
        }
        return index;
    }

    public static Integer anotherPoint(List<Integer> list, int index){
        int anotherIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i != index){
                anotherIndex = i;
                break;
            }
        }
        return anotherIndex;
    }
}
