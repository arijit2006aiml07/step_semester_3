import java.util.Scanner;

class ContainsDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[4];

        System.out.println("Enter 4 numbers:");
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextInt();
        }

        boolean duplicate = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    duplicate = true;
                }
            }
        }

        System.out.println(duplicate);

        sc.close();
    }
}
