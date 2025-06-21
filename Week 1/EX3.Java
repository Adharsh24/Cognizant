import java.util.Arrays;

public class EcommerceSearchExample {

    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String toString() {
            return "[" + productId + ", " + productName + ", " + category + "]";
        }
    }

    
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

   
    public static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shampoo", "Personal Care"),
            new Product(103, "Notebook", "Stationery"),
            new Product(104, "Smartphone", "Electronics"),
            new Product(105, "T-Shirt", "Clothing")
        };

        // Linear Search
        Product result1 = linearSearch(products, "Smartphone");
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Product not found"));

        // Sort array for Binary Search
        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        // Binary Search
        Product result2 = binarySearch(products, "Smartphone");
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Product not found"));
    }
}
