public class Cart {
    private int[] prices;
    private int count;
    private final String cartId;

    public Cart(String cartId, int maxSize) {
        this.cartId = cartId;
        this.prices = new int[maxSize];
        this.count = 0;
    }

    public void addItem(int price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }
}
