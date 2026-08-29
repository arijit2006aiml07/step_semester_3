import java.util.Scanner;

class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[7];
        int[] newArray = new int[7];

        System.out.println("Enter 7 numbers:");
        for (int i = 0; i < 7; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter k:");
        int k = sc.nextInt();

        k = k % nums.length;

        for (int i = 0; i < nums.length; i++) {
            int newPosition = (i + k) % nums.length;
            newArray[newPosition] = nums[i];
        }

        System.out.println("Rotated Array:");

        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }

        sc.close();
    }
}
