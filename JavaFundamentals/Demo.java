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

        int x21 = Integer.parseInt(scanner.nextLine());
        int y21 = Integer.parseInt(scanner.nextLine());

        double length1 = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
        double length2 = Math.sqrt(((x21 - x11) * (x21 - x11)) + ((y21 - y11) * (y21 - y11)));

        int index = 0;

        if (length1 >= length2) {
            int[] arr = {x1, x2};
            int[] realAtt = {x1, y1, x2, y2};
            index = findClosestNumber(arr);
            for (int i = 0; i < realAtt.length; i++) {
                if (realAtt[i] == index) {
                    System.out.printf("(%d, %d)", realAtt[i], realAtt[i + 1]);
                    break;
                }
            }
            for (int i = 0; i < realAtt.length; i++) {
                if (realAtt[i] != index) {
                    System.out.printf("(%d, %d)", realAtt[i], realAtt[i + 1]);
                    break;
                }
            }

        } else {
            int[] arr = {x11, x21};
            int[] realAtt = {x11, y11, x21, y21};
            index = findClosestNumber(arr);
            for (int i = 0; i < realAtt.length; i++) {
                if (realAtt[i] == index) {
                    System.out.printf("(%d, %d)", realAtt[i], realAtt[i + 1]);
                    break;
                }
            }
            for (int i = 0; i < realAtt.length; i++) {
                if (realAtt[i] != index) {
                    System.out.printf("(%d, %d)", realAtt[i], realAtt[i + 1]);
                    break;
                }
            }
        }


        System.out.println();
    }

    //метод за намиране на най-близкото число до нула от подаден масив
    public static Integer findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int val = nums[0];
        for (int i : nums) {
            if (i == 0) return 0;
            if (i > 0) {
                ans = i;
                break;
            }
            val = i;
        }
        if (ans == 0) return nums[nums.length - 1];
        if (Math.abs(val) < ans) return val;
        return ans;
    }
}
