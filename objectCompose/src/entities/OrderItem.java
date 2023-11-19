package entities;

public class OrderItem {

    private static Integer quantity;
    private static Double price;
    private Product product;

    public OrderItem () {

    }

    public OrderItem (Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public static Integer getQuantity() {
        return quantity;
    }

    public static void setQuantity(Integer quantity) {
        OrderItem.quantity = quantity;
    }

    public static Double getPrice() {
        return price;
    }

    public static void setPrice(Double price) {
        OrderItem.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public static Double subTotal () {
        return quantity * price;
    }

    @Override
    public String toString() {
        return getProduct().getName()
                + ", $"
                + String.format("%.2f", price)
                + ", Quantity: "
                + quantity
                + ", Subtotal: $"
                + String.format("%.2f", subTotal());
    }
}
