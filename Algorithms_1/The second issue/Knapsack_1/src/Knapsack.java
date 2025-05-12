import java.util.ArrayList;
import java.util.List;
public class  Knapsack {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        //todo اضفنا هنا الاغراض مع حجمها ووزنها وسعرها
        items.add(new Item(2, 3, 5));
        items.add(new Item(4, 7, 13));
        items.add(new Item(3, 5, 10));


        int capacity = 10; // حجم الصندوق
        int[][] DP = new int[items.size() + 1][capacity + 1];

        for (int i = 1; i <= items.size(); i++) {
            for (int j = 1; j <= capacity; j++) {
                if (items.get(i - 1).size > j) {
                    DP[i][j] = DP[i - 1][j];
                }
                else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i - 1][j - items.get(i - 1).size] + items.get(i - 1).price);
                }
            }
        }
        int result = DP[items.size()][capacity];
        System.out.println(" Maximum possible value of items in the box: " + result);

        List<Item> selectedItems = new ArrayList<>();
        int j = capacity;
        for (int i = items.size(); i > 0 && result > 0; i--) {
            if (result != DP[i - 1][j]) {
                selectedItems.add(items.get(i - 1));
                result -= items.get(i - 1).price;
                j -= items.get(i - 1).size;
            }
        }

        System.out.println("Selected purposes:");
        for (Item item : selectedItems) {
            System.out.println("size: " + item.size + ",weight: " + item.weight + ", price: " + item.price);
        }
    }
}

