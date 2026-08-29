import java.util.Scanner;

class MergeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        int[] result = new int[6];

        System.out.println("Enter 3 elements of first array:");
        for (int i = 0; i < 3; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter 3 elements of second array:");
        for (int i = 0; i < 3; i++) {
            arr2[i] = sc.nextInt();
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }

            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        System.out.println("Merged Array:");

        for (int x = 0; x < result.length; x++) {
            System.out.print(result[x] + " ");
        }

        sc.close();
    }
}
