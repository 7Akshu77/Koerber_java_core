package q4;

public class Product {
    private int productId;
    private double productPrice;
    private String productName;

    public Product(int productId, double productPrice, String productName) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(productId).append(productName).append(productPrice);
        return sb.toString();
    }
}
