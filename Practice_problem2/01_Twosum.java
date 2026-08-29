import java.util.Scanner;

class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[4];

        System.out.println("Enter 4 numbers:");
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter target:");
        int target = sc.nextInt();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    System.out.println("[" + i + ", " + j + "]");
                }
            }
        }

        sc.close();
    }
}
