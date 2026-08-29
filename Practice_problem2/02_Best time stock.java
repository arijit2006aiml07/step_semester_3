import java.util.Scanner;

class BestTimeStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] prices = new int[6];

        System.out.println("Enter 6 stock prices:");
        for (int i = 0; i < 6; i++) {
            prices[i] = sc.nextInt();
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        System.out.println("Maximum Profit = " + maxProfit);

        sc.close();
    }
}
